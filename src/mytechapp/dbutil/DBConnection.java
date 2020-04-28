/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytechapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DBConnection {
    
    private static Connection conn;
    static{
         try
    {
     Class.forName("oracle.jdbc.OracleDriver");
    conn=DriverManager.getConnection("jdbc:oracle:thin:@//Mohit:1521/xe","onlineexam","student");
     JOptionPane.showMessageDialog(null,"connected success");
    
     
     }
         catch(Exception e)
         {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"cannot connect!!");
         }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"disconnected Successfully");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"cannot close the connection!");
            
        }
    }
           
}

