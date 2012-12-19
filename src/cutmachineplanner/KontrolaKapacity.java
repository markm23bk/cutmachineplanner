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
public class KontrolaKapacity {
    boolean kapacitaok;
    
    public KontrolaKapacity(KonverzeDatum Dat){
   
        //incializace kapacitaok
   kapacitaok = true;
  
  String startden =Integer.toString(Dat.termden);
  String startmes =Integer.toString(Dat.termmes);
  String startrok =Integer.toString(Dat.termrok);
  String starthod =Integer.toString(Dat.termhod);
  String startmin =Integer.toString(Dat.termin);
  String endro =Integer.toString(Dat.endrok);
  String endme =Integer.toString(Dat.endmes);
  String endde =Integer.toString(Dat.endden);
  String endho =Integer.toString(Dat.endhod);
  String endmi =Integer.toString(Dat.endmin);
               
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();


ResultSet rs = st.executeQuery("select * from"
        + "(select * from "
        + "(select * from "
        + "(select * from "
        + "(select * from termin where startyear <= "+startrok+"AND"+startrok+"<= endyear)as a"
        + "where startmounth <="+startmes+"AND"+startmes+"<= endmounth)as b "
        + "where startday<="+startden+"AND"+startden+"<=endday) as c"
        + "where starthour<="+starthod+"AND"+starthod+"<=endhour)as d"
        + "where startmin<="+startmin+"AND"+startmin+"<=endmin  ;");

if (rs.first())kapacitaok = false;

         rs = st.executeQuery("select * from"
        + "(select * from "
        + "(select * from "
        + "(select * from "
        + "(select * from termin where startyear <= "+endro+"AND"+endro+"<= endyear)as a"
        + "where startmounth <="+endme+"AND"+endme+"<= endmounth)as b "
        + "where startday<="+endde+"AND"+endde+"<=endday) as c"
        + "where starthour<="+endho+"AND"+endho+"<=endhour)as d"
        + "where startmin<="+endmi+"AND"+endmi+"<=endmin  ;");
  
  if (rs.first())kapacitaok = false; 
         
        rs = st.executeQuery("select * from"
        + "(select * from "
        + "(select * from "
        + "(select * from "
        + "(select * from termin where startyear <= "+startrok+"AND"+endro+"<= endyear)as a"
        + "where startmounth <="+startmes+"AND"+endme+"<= endmounth)as b "
        + "where startday<="+startden+"AND"+endde+"<=endday) as c"
        + "where starthour<="+starthod+"AND"+endho+"<=endhour)as d"
        + "where startmin<="+startmin+"AND"+endmi+"<=endmin  ;");
         

 if (rs.first()) kapacitaok = false;  
 

}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");
System.out.println(e.toString());}
  


    }
    
    
}
