/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sqlproject;

import java.sql.*;
public class MyConnection{
    public static Connection getConnection(){
        Connection con=null;
        try{
//            using driver class from oracle 
            Class.forName("oracle.jdbc.driver.OracleDriver");

             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DREAM","dream");


            

        }catch(Exception e){ System.out.println(e.getMessage());}
        return con;

    }
}