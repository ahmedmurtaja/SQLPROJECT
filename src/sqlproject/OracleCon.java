package sqlproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmedizz
 */
import java.sql.*;
public class OracleCon{
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","DREAM","dream");

            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from students");
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

            con.close();

        }catch(Exception e){ System.out.println(e);}
        
        return con;
        
    } 
}