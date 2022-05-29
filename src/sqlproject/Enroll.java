/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlproject;

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
 * @author ahmedizz
 */
public class Enroll {
     public void insertUpdateDeleteCourse(char operation, Integer cid,Integer sid )
    {
      Connection con = MyConnection.getConnection();
     PreparedStatement ps;
      
      if(operation=='i')
      {
          try {
              ps = con.prepareStatement("INSERT INTO takes(cid,sid,takesid) VALUES (?,?,seq_takes.nextval)");
              ps.setInt(1, cid);
              ps.setInt(2, sid);
             
             
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done Course added");
              }
          } catch (SQLException ex) {
              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
//     UPDATE `course` SET `label`=?,`hours_number`=? WHERE `id`=?
//     if(operation=='u')
//      {
//          try {
//              ps = con.prepareStatement("UPDATE courses SET cname=?,hours=? WHERE cid=?");
//              ps.setString(1, label);
//              ps.setInt(2, hours);
//              ps.setInt(3,id);
//              if(ps.executeUpdate()>0)
//              {
//                  JOptionPane.showMessageDialog(null, "Done Course Updated");
//              }
//          } catch (SQLException ex) {
//              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
//          }
//      }
       if(operation=='d')
      {
          try {
              ps = con.prepareStatement("DELETE FROM takes WHERE cid=?");
              
              ps.setInt(1,cid);
              if(ps.executeUpdate()>0)
              {
                  JOptionPane.showMessageDialog(null, "Done Enroll Deleted");
              }
          } catch (SQLException ex) {
//              Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
          }
          
      }
    }
    public void fillCourseJtable(JTable table,int sid)
    {
        Connection con = MyConnection.getConnection();
     PreparedStatement ps;
     
        try {
            ps=con.prepareStatement("select COURSES.CNAME ,COURSES.HOURS from TAKES,STUDENTS,COURSES where COURSES.CID=TAKES.CID and STUDENTS.SID=?");
            ps.setInt(1,sid);
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object[] row ;
            while(rs.next())
            {
                row = new Object[2];
                row[0]=rs.getString(1);
                row[1]=rs.getInt(2);
                model.addRow(row);
            }
            
            }
        catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
