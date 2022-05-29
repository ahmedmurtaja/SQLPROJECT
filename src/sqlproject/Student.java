/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlproject;

/**
 *
 * @author ahmedizz
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ahmad
 */
public class Student {
    
    public void insertUpdateDeleteStudent(char operation,Integer id, String fname,String lname,String sex,String address)
    {
      Connection con = MyConnection.getConnection();
     PreparedStatement ps=null;
      
      if(operation=='i')
      {
          try {
              ps = con.prepareStatement("INSERT INTO STUDENTS (sid,LastName, FirstName, sex,address) VALUES (seq_student.nextval,?,?,?,?)");
              ps.setString(1, fname);
              ps.setString(2, lname);
              ps.setString(3, sex);
              ps.setString(4, address);
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done student added");
              }
          } catch (SQLException ex) {
              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      if(operation=='u')
      {
          try {
              ps = con.prepareStatement("UPDATE students SET FirstName= ? ,LastName= ? ,sex= ? ,address= ? WHERE sid=?");
              ps.setString(1, fname);
              ps.setString(2, lname);
              ps.setString(3, sex);
              ps.setString(4, address);
              ps.setInt(5,id);
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done student Updated");
              }
          } catch (SQLException ex) {
              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
       if(operation=='d')
      {
          try {
              ps = con.prepareStatement("DELETE FROM students  WHERE sid=? ");
              
              ps.setInt(1,id);
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done student Deleted");
              }
              
          } catch (SQLException ex) {
              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
    
    public void fillStudentJtable(JTable table ,String ValueToSearch)
    {
        Connection con = MyConnection.getConnection();
     PreparedStatement ps;
     
        try {
            ps=con.prepareStatement("SELECT * FROM students");
//            ps.setString(1,"%"+ValueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object[] row ;
            while(rs.next())
            {
                row = new Object[5];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getString(3);
                row[3]=rs.getString(4);
                row[4]=rs.getString(5);
                
                model.addRow(row);
            }
            
            }
        catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}