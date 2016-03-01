/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.intermmittentfaultsutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Panos
 */
public class ControlThread extends Thread {
    Thread t;
    ResultSet rs;
    int count;
    
    public ControlThread() {
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "root");
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) from mymetrics.metricvalues;";
            rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
            if (count > 0) {
                query = "SELECT * from mymetrics.metricvalues order by SERIAL_COUNT;";
                rs = stmt.executeQuery(query);
                 System.out.println("query = " + query);
            } else 
                rs = null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void run() {
        try {
            int recordSize = count;
            int i = 0;
            
            while (i<recordSize) {
                if (GlobalParams.allThreadsDone()) {
                    rs.next();
                    System.out.println("i = " + i);
                    String threadName = rs.getString("THREAD_NAME");
                    if(threadName.compareTo("main")==0) {
                        GlobalParams.setMainThreadDone(false);
                        GlobalParams.getMutexThreadMain().release();
                        i++;
                    } else if (threadName.compareTo("1")==0) {
                        GlobalParams.setThread1Done(false);
                        GlobalParams.getMutexThread1().release();
                        i++;
                    } else if (threadName.compareTo("2")==0) {
                        GlobalParams.setThread2Done(false);
                        GlobalParams.getMutexThread2().release();
                        i++;
                    } else if (threadName.compareTo("3")==0) {
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
