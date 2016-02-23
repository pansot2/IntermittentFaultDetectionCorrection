/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.intermmittentfaultsutils;

import java.util.ArrayList;

/**
 *
 * @author Panos
 */
public class ControlThread extends Thread {
    Thread t;
    ArrayList<Object[]> records = new ArrayList();
    
    public void run() {
        try {
            int recordSize = records.size();
            int i = 0;
            
            while (i<recordSize) {
                if (GlobalParams.allThreads3Done()) {
                    if(records.get(i)[0].toString().compareTo("main")==0) {
                        GlobalParams.setMainThreadDone(false);
                        GlobalParams.getMutexThreadMain().release();
                        i++;
                    } else if (records.get(i)[0].toString().compareTo("thread1")==0) {
                        GlobalParams.setThread1Done(false);
                        GlobalParams.getMutexThread1().release();
                        i++;
                    } else if (records.get(i)[0].toString().compareTo("thread2")==0) {
                        GlobalParams.setThread2Done(false);
                        GlobalParams.getMutexThread2().release();
                        i++;
                    } else if (records.get(i)[0].toString().compareTo("thread3")==0) {
                        GlobalParams.setThread3Done(false);
                        GlobalParams.getMutexThread3().release();
                        i++;
                    }
                }
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            GlobalParams.getMutexThreadMain().release();
            GlobalParams.getMutexThread1().release();
            GlobalParams.getMutexThread2().release();
            GlobalParams.getMutexThread3().release();
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
