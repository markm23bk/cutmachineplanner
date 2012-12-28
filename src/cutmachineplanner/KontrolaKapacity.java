/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author petr
 */
public class KontrolaKapacity {
   
    
    public static boolean volnaKapacita(KonverzeDatum Dat){
   
        //incializace kapacitaok
  boolean kapacitaok = true;
   int pomocny;
  
   
     
  Calendar datezac = Calendar.getInstance();
  Calendar datekon = Calendar.getInstance();
  Calendar datestart = Calendar.getInstance();
  Calendar dateend = Calendar.getInstance();
     

 
  String startrok =Integer.toString(Dat.termrok);
  String startmes =Integer.toString(Dat.termmes);
  String startden =Integer.toString(Dat.termden);
  String starthod =Integer.toString(Dat.termhod);
  String startmin =Integer.toString(Dat.termin);
  String endro =Integer.toString(Dat.endrok);
  String endme =Integer.toString(Dat.endmes);
  String endde =Integer.toString(Dat.endden);
  String endho =Integer.toString(Dat.endhod);
  String endmi =Integer.toString(Dat.endmin);
       
       
       
        System.out.println(startrok);
        System.out.println(startmes);
         System.out.println(startden);
        System.out.println(starthod);
        System.out.println(startmin);
        System.out.println(endro);
        System.out.println(endme);
        System.out.println(endde);
         System.out.println(endho);
        System.out.println(endmi);
        
        
        
  
  
  datezac.set (Dat.termrok,Dat.termmes,Dat.termden,Dat.termhod,Dat.termin);
  datekon.set (Dat.endrok,Dat.endmes,Dat.endden,Dat.endhod,Dat.endmin);


   
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();

ResultSet rs = st.executeQuery("select startyear,startmounth,startday,starthour,startminute,"
        + " endyear,endmounth,endday,endhour,endminute from termin "
        + "where (startyear ="+startrok+" and startmounth="+startmes+" and startday="+startden+")"
        + "or (endyear="+startrok+" and endmounth ="+startmes+" and endday="+startden+");");


//    System.out.println(rs.getInt(1));
//    System.out.println(rs.getInt(2));
//    System.out.println(rs.getInt(3));
//    System.out.println(rs.getInt(4));
//    System.out.println(rs.getInt(5));
//    System.out.println(rs.getInt(6));
//    System.out.println(rs.getInt(7));
//    System.out.println(rs.getInt(8));
//    System.out.println(rs.getInt(9));
//    System.out.println(rs.getInt(10));
    


while (rs.next()){
    System.out.println("cyklus");
  
     datestart.set(rs.getInt(1),rs.getInt(2) ,rs.getInt(3) ,rs.getInt(4) ,rs.getInt(5) );

   dateend.set(rs.getInt(6),rs.getInt(7) ,rs.getInt(8) ,rs.getInt(9) ,rs.getInt(10) );
  
 
  
    System.out.println(datezac.compareTo(datestart));
     System.out.println(datekon.compareTo(datestart));
      System.out.println(datezac.compareTo(dateend));
       System.out.println(datekon.compareTo(dateend));
       
      
  
  pomocny= Math.abs((datezac.compareTo(datestart)+datekon.compareTo(datestart)))+
           Math.abs((datezac.compareTo(dateend)+datekon.compareTo(dateend)));
  

  
  if (pomocny !=4){kapacitaok=false;break;}
  else System.out.println("je kapacita");
  
  
}

}catch(Exception e){ System.out.println("kapacita - Chyba volani, neprihlaseno");
System.out.println(e.toString());}
  
        System.out.println("kontrola kapacity");
 return kapacitaok; 
    }
  
    
}


 

