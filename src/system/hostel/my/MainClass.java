/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.hostel.my;

import java.awt.Component;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ARFA TECHNOLOGY
 */
public class MainClass {
    Connection con=null;
       ResultSet rs=null;
       PreparedStatement pst=null;
     public Connection connection(){
   try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myhostel","root","");
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
       
    return con;
    }
     
     



 
          

  //get date

public String getDate(){

DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Calendar cal = Calendar.getInstance();
return dateFormat.format(cal.getTime());
}

public String getDay(){

DateFormat dateFormat = new SimpleDateFormat("dd");
Calendar cal = Calendar.getInstance();
return dateFormat.format(cal.getTime());
}

public String getMonth(){

DateFormat dateFormat = new SimpleDateFormat("MM");
Calendar cal = Calendar.getInstance();
return dateFormat.format(cal.getTime());
}

public String getYear(){

DateFormat dateFormat = new SimpleDateFormat("yyyy");
Calendar cal = Calendar.getInstance();
return dateFormat.format(cal.getTime());
}

//end get date
     
     
// display data function
 public void getData(JButton button,DefaultTableModel tableModel,String tblname) {
       
        button.setEnabled(false);

        try (
                Statement stmt = connection().createStatement()) {
        
            ResultSet rs = stmt.executeQuery("select * from "+tblname);            
            

            ResultSetMetaData metaData = rs.getMetaData();
            
            // Names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
         
        }
        button.setEnabled(true);


    }
    
//end display data function
 
 // display data function
 public void getConditionalData(JButton button,DefaultTableModel tableModel,String tblname) {
       
        button.setEnabled(false);

        try (
                Statement stmt = connection().createStatement()) {
    
         ResultSet rs = stmt.executeQuery("select * from students,"+tblname+" WHERE students.id="+tblname+".std_id");            
           
        
            

            ResultSetMetaData metaData = rs.getMetaData();
            
            // Names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
         
        }
        button.setEnabled(true);


    }
 
  public void getConditionalData1(JButton button,DefaultTableModel tableModel,String tblname) {
       
        button.setEnabled(false);

        try (
                Statement stmt = connection().createStatement()) {
    
         ResultSet rs = stmt.executeQuery("select * from staff,"+tblname+" WHERE staff.id="+tblname+".staff_id");            
           
        
            

            ResultSetMetaData metaData = rs.getMetaData();
            
            // Names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
         
        }
        button.setEnabled(true);


    }
  
  
  //end 
  
  //delete data
  
   public void deleteEmployees(String id, String tbl){
          
         String sql="DELETE from "+tbl+" where id="+id+"";
        try
        {   Statement s=connection().prepareStatement(sql);
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
          
       
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        } 
          
          }
   
   // login starts
   public boolean login(String email, String password){
        String e=email;
        String p=password;

        boolean checkUser = false;
        String query = "SELECT * FROM hostel_admin WHERE username =? AND password =?";
          try {
         pst =connection().prepareStatement(query);
            pst.setString(1, e);
             pst.setString(2, p);
            rs = pst.executeQuery();
            if(rs.next())
            {
                checkUser = true;
                
            }
        } catch (SQLException ex) {
            
        }
         return checkUser;
    }
   //login ends
   
   
   //encryption of password
     public String hash(String input)
    {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }        
     
     //ends here
}
