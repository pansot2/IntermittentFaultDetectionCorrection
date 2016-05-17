/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.intermmittentfaultsutils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Panos
 */
public class GlobalParams extends Thread{
    private static Semaphore mutexThreadMain = new Semaphore(0);
    private static Semaphore mutexThread1 = new Semaphore(0);
    private static Semaphore mutexThread2 = new Semaphore(0);
    private static Semaphore mutexThread3 = new Semaphore(0);
    private static boolean mainThreadDone = false;
    private static boolean thread1Done = true;
    private static boolean thread2Done = true;
    private static boolean thread3Done = true;
    
    private static volatile AtomicInteger globalCount = new AtomicInteger(0);
    private static Object compareValue=-1;
    private static Object expectedValue;
    private static int countUntil = -1;
    private static int recordSize = -1;
    private static boolean recursive = false;
    private static boolean done = false;
    

    public static void initialize() {
        mutexThreadMain = new Semaphore(0);
        mutexThread1 = new Semaphore(0);
        mutexThread2 = new Semaphore(0);
        mutexThread3 = new Semaphore(0);
        mainThreadDone = false;
        thread1Done = true;
        thread2Done = true;
        thread3Done = true;
    
        globalCount = new AtomicInteger(0);
        compareValue = -1;
        countUntil = -1;
        recordSize = -1;
        recursive = false;
        done = false;
    }
    
    public static boolean isRecursive() {
        return recursive;
    }

    public static void setRecursive(boolean recursive) {
        GlobalParams.recursive = recursive;
    }

    public static boolean isDone() {
        return done;
    }

    public static void setDone(boolean done) {
        GlobalParams.done = done;
    }

    public static AtomicInteger getGlobalCount() {
         return globalCount;
    }

    public static void setGlobalCount(AtomicInteger globalCount) {
        GlobalParams.globalCount = globalCount;
    }

    public static int getCountUntil() {
        return countUntil;
    }

    public static int getRecordSize() {
        return recordSize;
    }

    public static void setRecordSize(int recordSize) {
        GlobalParams.recordSize = recordSize;
    }

    public static void setCountUntil(int countUntil) {
        GlobalParams.countUntil = countUntil;
    }
    
    public static Object getExpectedValue() {
        return expectedValue;
    }

    public static void setExpectedValue(Object expectedValue) {
        GlobalParams.expectedValue = expectedValue;
    }

    public static Object getCompareValue() {
        return compareValue;
    }

    public static void setCompareValue(Object compareValue) {
        GlobalParams.compareValue = compareValue;
    }
    
    public static int globalCountGetAndIncrement(){
        int count = globalCount.getAndIncrement();
        return count;
    }
    
    public static void AddBlockPoints() throws InterruptedException {
        if (Thread.currentThread().getName().compareTo("main")==0) {
            GlobalParams.setMainThreadDone(true);
            mutexThreadMain.acquire();
        } else if (Thread.currentThread().getName().compareTo("1")==0) {
            GlobalParams.setThread1Done(true);
            mutexThread1.acquire();
        } else if (Thread.currentThread().getName().compareTo("2")==0) {
            GlobalParams.setThread2Done(true);
            mutexThread2.acquire();
        } else if (Thread.currentThread().getName().compareTo("3")==0) {
            GlobalParams.setThread3Done(true);
            mutexThread3.acquire();
        }
    }

    public synchronized static void SetDone() throws InterruptedException {
        if (Thread.currentThread().getName().compareTo("main")==0)
            GlobalParams.setMainThreadDone(true);
        else if (Thread.currentThread().getName().compareTo("1")==0) 
            GlobalParams.setThread1Done(true);
        else if (Thread.currentThread().getName().compareTo("2")==0) 
            GlobalParams.setThread2Done(true);
        else if (Thread.currentThread().getName().compareTo("3")==0) 
            GlobalParams.setThread3Done(true);
    }

    public static Semaphore getMutexThreadMain() {
        return mutexThreadMain;
    }

    public static Semaphore getMutexThread1() {
        return mutexThread1;
    }

    public static Semaphore getMutexThread2() {
        return mutexThread2;
    }

    public static Semaphore getMutexThread3() {
        return mutexThread3;
    }
    
    public static boolean isMainThreadDone() {
        return mainThreadDone;
    }

    public static void setMainThreadDone(boolean mainThreadDone) {
        GlobalParams.mainThreadDone = mainThreadDone;
    }

    public synchronized static boolean isThread1Done() {
        return thread1Done;
    }

    public static void setThread1Done(boolean thread1Done) {
        GlobalParams.thread1Done = thread1Done;
    }

    public synchronized static boolean isThread2Done() {
        return thread2Done;
    }

    public static void setThread2Done(boolean thread2Done) {
        GlobalParams.thread2Done = thread2Done;
    }

    public synchronized static boolean isThread3Done() {
        return thread3Done;
    }

    public static void setThread3Done(boolean thread3Done) {
        GlobalParams.thread3Done = thread3Done;
    }
    
    public synchronized static boolean allThreadsDone() {
        if (mainThreadDone==true && mutexThreadMain.availablePermits()==0 && thread1Done==true && mutexThread1.availablePermits()==0 && thread2Done==true && mutexThread2.availablePermits()==0 && thread3Done==true && mutexThread3.availablePermits()==0)
            return true;
        else
            return false;
    }
}
