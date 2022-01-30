/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.hostel.my;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ARFA TECHNOLOGY
 */
public class StudentsClass {
             ResultSet rs=null;
       PreparedStatement pst=null; 
//add student
public void add_student(String name, String phone, String cnic,String emergency,String room_no){

        String cRoom="";
    
    String query = "SELECT * FROM `hostel_rooms` WHERE room_no =?";
         
    try {
         pst =new MainClass().connection().prepareStatement(query);
            pst.setString(1, room_no);
            rs = pst.executeQuery();
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null, "Room "+room_no+" Record Not Available");
            }else{       
 
        String sql= "insert into students(name,phone,cnic,emergency_no,start_date,end_date,room_no) values (?, ?, ?, ?, ?, ?, ?)";
        pst=new MainClass().connection().prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2,  phone);
         pst.setString(3, cnic);
         pst.setString(4, emergency);
         pst.setString(5, new MainClass().getDate());
         pst.setString(6, "0");
         pst.setString(7, room_no);
        pst.execute();
       JOptionPane.showMessageDialog(null, "Student added Successfully"); 
       }
            }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
      
 
    }   
//end add student  
// enter student fee
 public void add_fee(String id){
     String data="";
     String uid="";
     String name="";
     String room="";
     String rent="";
 String query = "SELECT * FROM students,hostel_rooms WHERE students.id =? AND students.room_no=hostel_rooms.room_no";
          try {
         pst =new MainClass().connection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if(rs.next())
            {
                room = rs.getString("room_no");
                uid= rs.getString("id");
                rent= rs.getString("bed_rent");
                name= rs.getString("name");
  
            }else{
       
            data=" No Data Found";
            JOptionPane.showMessageDialog(null, data);
            }
            
        } catch (SQLException ex) {
           
        }
       try{
        String sql= "insert into paid_fee(std_id,paid_month,paid_day,paid_year,paid_amount) values (?, ?, ?, ?, ?)";
        pst=new MainClass().connection().prepareStatement(sql);
        pst.setString(1, uid);
        pst.setString(2,  new MainClass().getMonth());
         pst.setString(3, new MainClass().getDay());
         pst.setString(4, new MainClass().getYear());
         pst.setString(5, rent);
        pst.execute();
       JOptionPane.showMessageDialog(null, rent+" Fee for "+room+" has paid by "+name); 
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }    
          
          
    }   
 //end student fee
 
}
