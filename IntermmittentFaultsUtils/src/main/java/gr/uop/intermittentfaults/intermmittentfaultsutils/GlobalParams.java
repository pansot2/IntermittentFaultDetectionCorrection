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
public class GlobalParams {
    private static final Object lockA = new Object();
    private static final Semaphore mutexThreadMain = new Semaphore(0);
    private static final Semaphore mutexThread1 = new Semaphore(0);
    private static final Semaphore mutexThread2 = new Semaphore(0);
    private static final Semaphore mutexThread3 = new Semaphore(0);
    
    private static volatile AtomicInteger globalCount = new AtomicInteger();
    
    public static int globalCountGetAndIncrement(){
        synchronized(lockA) {
            int count = globalCount.getAndIncrement();
            return count;
        }
    }
    
}
