/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbjdbcconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author xingye
 */
public class fbjdbcconnector {
    
    
    
    
    private static String mysJDBCDriver = "com.mysql.jdbc.Driver";
    private static String mysURL = "jdbc:mysql://mysql2.cs.stonybrook.edu:3306/jintchen";
    private static String mysUserID = "jintchen";
    private static String mysPassword = "109222754";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static ResultSet excuteQuery(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            Properties sysprops = System.getProperties();
            sysprops.put("user", mysUserID);
            sysprops.put("password", mysPassword);
            conn = DriverManager.getConnection(mysURL,mysUserID,mysPassword);
            if(conn == null){
                System.out.println("connected");
            }
            else{
                System.out.println("not connected");

            }

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            try {
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        return null;
    }

    public static boolean excuteUpdate(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Properties sysprops = System.getProperties();
            sysprops.put("user", mysUserID);
            sysprops.put("password", mysPassword);
            conn = DriverManager.getConnection(mysURL, sysprops);
            stmt = conn.createStatement();
            int u = stmt.executeUpdate(query);
            if (u > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            try {
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        return false;
    }
    public static void close() throws SQLException{
        rs.close();
        stmt.close();
        conn.close();
    }
    
}
