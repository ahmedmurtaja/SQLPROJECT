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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmad
 */
public class Course {
     public void insertUpdateDeleteCourse(char operation,Integer id, String label,Integer hours )
    {
      Connection con = MyConnection.getConnection();
     PreparedStatement ps;
      
      if(operation=='i')
      {
          try {
              ps = con.prepareStatement("INSERT INTO courses(cid,cname,hours) VALUES (seq_course.nextval,?,?)");
              ps.setString(1, label);
              ps.setInt(2, hours);
             
             
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done Course added");
              }
          } catch (SQLException ex) {
              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
//     UPDATE `course` SET `label`=?,`hours_number`=? WHERE `id`=?
     if(operation=='u')
      {
          try {
              ps = con.prepareStatement("UPDATE courses SET cname=?,hours=? WHERE cid=?");
              ps.setString(1, label);
              ps.setInt(2, hours);
              ps.setInt(3,id);
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done Course Updated");
              }
          } catch (SQLException ex) {
              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
       if(operation=='d')
      {
          try {
              ps = con.prepareStatement("DELETE FROM courses WHERE cid=?");
              
              ps.setInt(1,id);
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done Course Deleted");
              }
          } catch (SQLException ex) {
//              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
          }
          
      }
    }
    public void fillCourseJtable(JTable table)
    {
        Connection con = MyConnection.getConnection();
     PreparedStatement ps;
     
        try {
            ps=con.prepareStatement("SELECT * FROM courses");
           // ps.setString(1,"%"+ValueToSearch+"%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object[] row ;
            while(rs.next())
            {
                row = new Object[3];
                row[0]=rs.getInt(1);
                row[1]=rs.getString(2);
                row[2]=rs.getInt(3);
                model.addRow(row);
            }
            
            }
        catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
