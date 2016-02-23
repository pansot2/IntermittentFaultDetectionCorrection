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
    private static boolean mainThreadDone = false;
    private static boolean thread1Done = true;
    private static boolean thread2Done = true;
    private static boolean thread3Done = true;
    
    private static volatile AtomicInteger globalCount = new AtomicInteger();
    
    public static synchronized int globalCountGetAndIncrement(){
        int count = globalCount.getAndIncrement();
        return count;
    }
    
    public static synchronized void AddBlockPoints() throws InterruptedException {
        if (Thread.currentThread().getName().compareTo("main")==0)
            mutexThreadMain.acquire();
        else if (Thread.currentThread().getName().compareTo("1")==0) 
            mutexThread1.acquire();
        else if (Thread.currentThread().getName().compareTo("2")==0) 
            mutexThread2.acquire();
        else if (Thread.currentThread().getName().compareTo("3")==0) 
            mutexThread3.acquire();
    }

    public static synchronized void SetDone() throws InterruptedException {
        if (Thread.currentThread().getName().compareTo("main")==0)
            mainThreadDone = true;
        else if (Thread.currentThread().getName().compareTo("1")==0) 
            thread1Done = true;
        else if (Thread.currentThread().getName().compareTo("2")==0) 
            thread2Done = true;
        else if (Thread.currentThread().getName().compareTo("3")==0) 
            thread3Done = true;
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
    
    public static synchronized boolean isMainThreadDone() {
        return mainThreadDone;
    }

    public static synchronized void setMainThreadDone(boolean mainThreadDone) {
        GlobalParams.mainThreadDone = mainThreadDone;
    }

    public static synchronized boolean isThread1Done() {
        return thread1Done;
    }

    public static synchronized void setThread1Done(boolean thread1Done) {
        GlobalParams.thread1Done = thread1Done;
    }

    public static synchronized boolean isThread2Done() {
        return thread2Done;
    }

    public static synchronized void setThread2Done(boolean thread2Done) {
        GlobalParams.thread2Done = thread2Done;
    }

    public static synchronized boolean isThread3Done() {
        return thread3Done;
    }

    public static synchronized void setThread3Done(boolean thread3Done) {
        GlobalParams.thread3Done = thread3Done;
    }
    
    public static synchronized boolean allThreads3Done() {
        if (mainThreadDone==true && thread1Done==true && thread2Done==true && thread3Done==true)
            return true;
        else
            return false;
    }
}
