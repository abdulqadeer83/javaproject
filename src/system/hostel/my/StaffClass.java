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
public class StaffClass {
             ResultSet rs=null;
       PreparedStatement pst=null;
    //add staff
public void add_staff(String name, String phone, String work,String pay){
       
    try{
        String sql= "insert into staff(name,phone,work_nature,joining_date,monthly_pay) values (?, ?, ?, ?, ?)";
        pst=new MainClass().connection().prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2,  phone);
         pst.setString(3, work);
         pst.setString(4, new MainClass().getDate());
         pst.setString(5, pay);
        pst.execute();
       JOptionPane.showMessageDialog(null, "Staff added Successfully"); 
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
      
 
    }   
//end add staff      
 // enter staff pay
 public void add_pay(String id){
     String data="";
     String uid="";
     String name="";
     String pay="";
 String query = "SELECT * FROM staff WHERE id =?";
          try {
         pst =new MainClass().connection().prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            if(rs.next())
            {
                uid= rs.getString("id");
                pay= rs.getString("monthly_pay");
                name= rs.getString("name");
  
            }else{
       
            data=" No Data Found";
            JOptionPane.showMessageDialog(null, data);
            }
            
        } catch (SQLException ex) {
           
        }
       try{
        String sql= "insert into paid_pay(staff_id,paid_month,paid_day,paid_year,paid_amount) values (?, ?, ?, ?, ?)";
        pst=new MainClass().connection().prepareStatement(sql);
        pst.setString(1, uid);
        pst.setString(2,  new MainClass().getMonth());
         pst.setString(3, new MainClass().getDay());
         pst.setString(4, new MainClass().getYear());
         pst.setString(5, pay);
        pst.execute();
       JOptionPane.showMessageDialog(null, pay+" Monthly Pay has paid staff "+name); 
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }    
          
          
    }   
 //end staff pay
 
}
