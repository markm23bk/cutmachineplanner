/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author petr
 */
public class InitPanel {
    
    
    
    
   public static Vector InitPan (String ciszak){
       
       Vector <String> contpanel = new Vector ();
                     contpanel.removeAllElements();
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();

ResultSet rs = st.executeQuery("select i.cisvyrobku,t.startyear,t.startmounth,t.startday,t.starthour,"
        +" t.startminute,d.deadyear,d.deadmounth,d.deadday,d.deadhour,d.deadminute,i.druhpap,"
         +" i.sire,i.delkrol,i.cislorol,i.cislozak,o.c1,o.c2,o.c3,o.c4,o.c5,o.c6,o.c7,o.c8,o.c9,o.c10,o.c11 "
         +" from termin t join deadline d using(cislozak) join inputmaterial i using(cislozak) join outputmaterial o using(cislozak)"
        +" where i.cislozak ="+ciszak+" ;");


if (rs.first()){
    
        
    for (int a=1;a<=27;a++){
        System.out.println(rs.getString(a));
    contpanel.add(rs.getString(a));}
}
 
//}

}catch(Exception e){ System.out.println("initpanel chyba");
System.out.println(e.toString());}
  
     //   System.out.println("init panel chyba");
 
        return contpanel;
        
    }
   }
