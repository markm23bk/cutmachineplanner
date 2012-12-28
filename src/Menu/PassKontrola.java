/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author petr
 */
public class PassKontrola {
    
    public static int kontrolaHesla (String user, String pass){
        
        int id=0;
      try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();

ResultSet rs = st.executeQuery("select cislozam"
         +" from person "
        +" where username ="+user+" and password="+pass+";");

if (rs.first())id = Integer.parseInt(rs.getString(0));

}catch(Exception e){ System.out.println("chyba autorizace");
System.out.println(e.toString());}
  
   return id;   
    }
}

