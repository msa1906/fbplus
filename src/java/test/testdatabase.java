/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import fbjdbcconnector.fbjdbcconnector;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author xingye
 */
public class testdatabase {
    
    public static void main(String[] args){

        try{
            String query = "SELECT * FROM User ";

            ResultSet rs = fbjdbcconnector.excuteQuery(query);
            while (rs.next()) {
                int fbID = rs.getInt("UserId");
                System.out.println(fbID);
            }
        }
        catch(SQLException e){
            
        }
        finally{
            try{
                fbjdbcconnector.close();
            }
            catch(SQLException e){
                
            }
        }
        
        
        
    }
    
}
