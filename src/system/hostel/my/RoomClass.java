/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.hostel.my;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ARFA TECHNOLOGY
 */
public class RoomClass {
              ResultSet rs=null;
       PreparedStatement pst=null; 
    //add rooms


public void add_room(String no, String capacity, String rent){
       
    try{
        String sql= "insert into hostel_rooms(room_no,room_capacity, free_space,bed_rent) values (?, ?, ?, ?)";
        pst=new MainClass().connection().prepareStatement(sql);
        pst.setString(1, no);
        pst.setString(2,  capacity);
         pst.setString(3, capacity);
         pst.setString(4, rent);
        pst.execute();
       JOptionPane.showMessageDialog(null, "Room added Successfully");
        
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
      
 
    }   
//end add rooms  

}
