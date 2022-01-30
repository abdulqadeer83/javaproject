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
public class MenuClass {
           ResultSet rs=null;
       PreparedStatement pst=null;
    //add menu
public void add_menu(String day, String b, String l,String d){
        try{
        String sql= "insert into hostel_menu(day_name,breakfast,lunch,dinner) values (?, ?, ?, ?)";
        pst=new MainClass().connection().prepareStatement(sql);
        pst.setString(1, day);
        pst.setString(2,  b);
         pst.setString(3, l);
         pst.setString(4, d);
        pst.execute();
       JOptionPane.showMessageDialog(null, "Menu Item added Successfully"); 
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
      
 
    }   
//end add menu 
    
}
