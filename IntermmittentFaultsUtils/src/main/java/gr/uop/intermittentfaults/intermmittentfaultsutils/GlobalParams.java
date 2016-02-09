/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.intermmittentfaultsutils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Panos
 */
public class GlobalParams {
    public static volatile AtomicInteger globalCount = new AtomicInteger();
    public synchronized static int globalCountGetAndIncrement(){
        int count = globalCount.getAndIncrement();
        System.out.println("-------- " + count);
        return count;
    }
}
