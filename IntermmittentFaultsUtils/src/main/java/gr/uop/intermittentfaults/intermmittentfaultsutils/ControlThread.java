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
    Statement stmt;
    
    public ControlThread() {
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "root");
            stmt = connection.createStatement();
            String query = "SELECT COUNT(*) from mymetrics.metricvalues;";
            rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
            GlobalParams.setCountUntil(count);
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
            int recordSize = GlobalParams.getCountUntil();
            int i = 0;
            ResultSet rs0, rs1, rs2, rs3;
            
            String query = "SELECT * from (SELECT * from mymetrics.metricvalues order by SERIAL_COUNT limit " + recordSize + ") as PART WHERE PART.THREAD_NAME='main' order by PART.SERIAL_COUNT DESC LIMIT 1;";
            String query1 = "SELECT * from (SELECT * from mymetrics.metricvalues order by SERIAL_COUNT limit " + recordSize + ") as PART WHERE PART.THREAD_NAME='1' order by PART.SERIAL_COUNT DESC LIMIT 1;";
            String query2 = "SELECT * from (SELECT * from mymetrics.metricvalues order by SERIAL_COUNT limit " + recordSize + ") as PART WHERE PART.THREAD_NAME='2' order by PART.SERIAL_COUNT DESC LIMIT 1;";
            String query3 = "SELECT * from (SELECT * from mymetrics.metricvalues order by SERIAL_COUNT limit " + recordSize + ") as PART WHERE PART.THREAD_NAME='3' order by PART.SERIAL_COUNT DESC LIMIT 1;";
            
            rs0 = stmt.executeQuery(query);
            rs0.next();
            
            rs1 = stmt.executeQuery(query1);
            rs1.next();
            
            rs2 = stmt.executeQuery(query2);
            rs2.next();
            
            rs3 = stmt.executeQuery(query3);
            rs3.next();
            
            while (i<recordSize) {
                if (GlobalParams.allThreadsDone()) {
                    rs.next();
                    System.out.println("i = " + i);
                    String threadName = rs.getString("THREAD_NAME");
                    if(threadName.compareTo("main")==0) {
                        GlobalParams.setMainThreadDone(false);
                        GlobalParams.getMutexThreadMain().release();
                        i++;
                        if (rs.getString("SERIAL_COUNT").compareTo(rs0.getString("SERIAL_COUNT"))==0 && !GlobalParams.isRecursive())
                            GlobalParams.getMutexThreadMain().release();
                        if ((i==recordSize-1) && GlobalParams.isRecursive()) {
                            GlobalParams.getMutexThread1().release();
                            GlobalParams.getMutexThread2().release();
                            GlobalParams.getMutexThread3().release();
                            GlobalParams.getMutexThreadMain().release();
                        }
                    } else if (threadName.compareTo("1")==0) {
                        GlobalParams.setThread1Done(false);
                        GlobalParams.getMutexThread1().release();
                        i++;
                        if (rs.getString("SERIAL_COUNT").compareTo(rs1.getString("SERIAL_COUNT"))==0 && !GlobalParams.isRecursive())
                            GlobalParams.getMutexThread1().release();
                        if ((i==recordSize-1) && GlobalParams.isRecursive()) {
                            GlobalParams.getMutexThread1().release();
                            GlobalParams.getMutexThread2().release();
                            GlobalParams.getMutexThread3().release();
                            GlobalParams.getMutexThreadMain().release();
                        }
                    } else if (threadName.compareTo("2")==0) {
                        GlobalParams.setThread2Done(false);
                        GlobalParams.getMutexThread2().release();
                        i++;
                        if (rs.getString("SERIAL_COUNT").compareTo(rs2.getString("SERIAL_COUNT"))==0 && !GlobalParams.isRecursive())
                            GlobalParams.getMutexThread2().release();
                        if ((i==recordSize-1) && GlobalParams.isRecursive()) {
                            GlobalParams.getMutexThread1().release();
                            GlobalParams.getMutexThread2().release();
                            GlobalParams.getMutexThread3().release();
                            GlobalParams.getMutexThreadMain().release();
                        }
                    } else if (threadName.compareTo("3")==0) {
                        GlobalParams.setThread3Done(false);
                        GlobalParams.getMutexThread3().release();
                        i++;
                        if (rs.getString("SERIAL_COUNT").compareTo(rs3.getString("SERIAL_COUNT"))==0 && !GlobalParams.isRecursive())
                            GlobalParams.getMutexThread3().release();
                        if ((i==recordSize-1) && GlobalParams.isRecursive()) {
                            GlobalParams.getMutexThread1().release();
                            GlobalParams.getMutexThread2().release();
                            GlobalParams.getMutexThread3().release();
                            GlobalParams.getMutexThreadMain().release();
                        }
                    }
                }
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this);
            t.start();
        }
    }
}
