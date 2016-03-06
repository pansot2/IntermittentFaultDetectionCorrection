/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uop.intermittentfaults.appendfilelines;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Panos
 */
public class CompareRecordReplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection  connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "root");
            Statement stmt = connection.createStatement();
            String query = "SELECT COUNT(*) from mymetrics.metricvalues;";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int count1 = rs.getInt(1);
            
            query = "SELECT COUNT(*) from mymetrics.metricreplayvalues;";
            rs = stmt.executeQuery(query);
            rs.next();
            int count2 = rs.getInt(1);
            
            if (count1!=count2) {
                System.err.println("The replay table does not match the record table.");
                exit(-1);
            }
            
            String query1 = "SELECT * from mymetrics.metricvalues order by SERIAL_COUNT;";
            String query2 = "SELECT * from mymetrics.metricreplayvalues order by SERIAL_COUNT;";
            
            ResultSet rs1 = stmt.executeQuery(query1);
            ResultSet rs2 = stmt.executeQuery(query2);
            
            int i = 0;
            
            while (i < count1) {
                rs1.next();
                rs2.next();
                System.out.println("Compare seq = " + i);
                if (rs1.getString("THREAD_NAME").compareTo(rs2.getString("THREAD_NAME"))!=0) {
                    System.err.println("The replay table does not match the record table.  SERIAL_COUNT : " + rs1.getString("SERIAL_COUNT"));
                    exit(-1);
                }
                
                if (rs1.getString("THREAD_NAME").compareTo("main")!=0) { // Comparison for all the threads except the main thread.
                
                    if (rs1.getString("LINE").compareTo(rs2.getString("LINE"))!=0) {
                        System.err.println("The replay table does not match the record table.  SERIAL_COUNT : " + rs1.getString("SERIAL_COUNT"));
                        exit(-1);
                    }

                    if (rs1.getString("CLASS_NAME").compareTo(rs2.getString("CLASS_NAME"))!=0) {
                        System.err.println("The replay table does not match the record table.  SERIAL_COUNT : " + rs1.getString("SERIAL_COUNT"));
                        exit(-1);
                    }

                    if (rs1.getString("METHOD_NAME").compareTo(rs2.getString("METHOD_NAME"))!=0) {
                        System.err.println("The replay table does not match the record table.  SERIAL_COUNT : " + rs1.getString("SERIAL_COUNT"));
                        exit(-1);
                    }
                }
                
                i++;
            }
            
            System.out.println("The Record and the Replay phase match ... ");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
