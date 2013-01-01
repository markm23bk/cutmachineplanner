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
public class Identifikator {
    
        int id;
    
    public Identifikator(String tab,String sloup){
       
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

        
          
try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("select "+sloup+" from "+tab+" order by "+sloup+" desc;");

if (rs.first()){id = rs.getInt(1)+1;}
else id = 1;


}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");
System.out.println(e.toString());}
        
    }  
    
    
}
