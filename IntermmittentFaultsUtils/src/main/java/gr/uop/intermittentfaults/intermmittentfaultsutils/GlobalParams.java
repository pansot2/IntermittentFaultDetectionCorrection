/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.intermmittentfaultsutils;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Panos
 */
public class GlobalParams extends Thread{
    private static final Semaphore mutexThreadMain = new Semaphore(0);
    private static final Semaphore mutexThread1 = new Semaphore(0);
    private static final Semaphore mutexThread2 = new Semaphore(0);
    private static final Semaphore mutexThread3 = new Semaphore(0);
    private static boolean mainThreadDone;
    private static boolean thread1Done = true;
    private static boolean thread2Done = true;
    private static boolean thread3Done = true;
    
    private static volatile AtomicInteger globalCount = new AtomicInteger();
    
    public synchronized static int globalCountGetAndIncrement(){
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

    public synchronized static Semaphore getMutexThreadMain() {
        return mutexThreadMain;
    }

    public synchronized static Semaphore getMutexThread1() {
        return mutexThread1;
    }

    public synchronized static Semaphore getMutexThread2() {
        return mutexThread2;
    }

    public synchronized static Semaphore getMutexThread3() {
        return mutexThread3;
    }
    
    public synchronized static boolean isMainThreadDone() {
        return mainThreadDone;
    }

    public synchronized static void setMainThreadDone(boolean mainThreadDone) {
        GlobalParams.mainThreadDone = mainThreadDone;
    }

    public synchronized static boolean isThread1Done() {
        return thread1Done;
    }

    public synchronized static void setThread1Done(boolean thread1Done) {
        GlobalParams.thread1Done = thread1Done;
    }

    public synchronized static boolean isThread2Done() {
        return thread2Done;
    }

    public synchronized static void setThread2Done(boolean thread2Done) {
        GlobalParams.thread2Done = thread2Done;
    }

    public synchronized static boolean isThread3Done() {
        return thread3Done;
    }

    public synchronized static void setThread3Done(boolean thread3Done) {
        GlobalParams.thread3Done = thread3Done;
    }
    
    public synchronized static boolean allThreadsDone() {
        if (mainThreadDone==true && mutexThreadMain.availablePermits()==0 && thread1Done==true && mutexThread1.availablePermits()==0 && thread2Done==true && mutexThread2.availablePermits()==0 && thread3Done==true && mutexThread3.availablePermits()==0)
            return true;
        else
            return false;
    }
}
