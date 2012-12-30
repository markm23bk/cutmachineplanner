/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author petr
 */
public class DobaVyroby {
    //doba v minutach 
    int doba;
    
    
    public DobaVyroby(int druhpap,int delkrol){
        
  String idpap = Integer.toString(druhpap);  
      
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();    
ResultSet rs = st.executeQuery("SELECT rychlost FROM druhpapiru WHERE cislopap="+idpap+";");
  
 rs.first();
 doba=delkrol/(Integer.parseInt(rs.getString(1)));     
     
}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");
  
    }
    
}
}