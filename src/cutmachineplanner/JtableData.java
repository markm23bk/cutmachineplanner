/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import CutMachine.entity.Deadline;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Calendar;
import java.util.Vector;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author petr
 */
public class JtableData {
    
 
  
    
 public static Vector vytvorData (Calendar cal){
                    
   System.out.println("kotrola kalendare"+cal.get(Calendar.DAY_OF_MONTH));
 String den = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));           
 String mesic = Integer.toString(cal.get(Calendar.MONTH)+1); 
 String rok = Integer.toString(cal.get(Calendar.YEAR)); 
 

     System.out.println(den);
      System.out.println(mesic);
       System.out.println(rok);
 
   
 Vector <Object> row = new Vector <Object>();
  
 
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();    
//dotaz na data aktualniho dne 
ResultSet rs = st.executeQuery("SELECT t.cislozak,t.starthour,t.startminute,t.endhour,t.endminute,d.druhpap,o.c1,o.c2,o.c3,o.c4,o.c5,o.c6,o.c7,o.c8,o.c9,o.c10,"
+"o.c11, t.state FROM termin t JOIN outputmaterial o ON t.cislozak=o.cislozak JOIN inputmaterial i ON o.cislozak=i.cislozak "
        + "JOIN druhpapiru d ON i.druhpap = d.cislopap " 
+"WHERE t.startday = "+ den +" AND t.startmounth = "+ mesic +" AND t.startyear = "+rok+";" );
 

  while (rs.next()) {

 Vector <Object> r = new Vector <Object>();
  //cislozak
r.addElement(ciselFormat(rs.getString(1),8));
      System.out.println(ciselFormat(rs.getString(1),8));
//starttermin
r.addElement(casFormat(rs.getString(2),rs.getString(3)));
      System.out.println(casFormat(rs.getString(2),rs.getString(3)));
//endtermin       
r.addElement(casFormat(rs.getString(4),rs.getString(5)));
      System.out.println(casFormat(rs.getString(4),rs.getString(5)));
//druh papiru 
r.addElement(rs.getString(6)); 
      System.out.println(rs.getString(6));
//bobiny
for (int a=7;a<=17;a++){
    
    r.addElement(rs.getString(a));
   
}

   r.addElement(rs.getString(18)); 
      System.out.println(rs.getString(18));
      
   //   System.out.println(rs.getInt(15));


//prirazeni radku do modelu 

row.addElement(r);
  }
  
}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");

System.out.println(e.toString());}

//model 
return row;
}
       
       
    //uprava formatu cisla zakazky     
    public static String ciselFormat(String s,int a){
        int i;
        
        i=a-s.length();
        for(int x=1;x<=i;x++){
           s = "0"+s; 
        }
                   
        return s;
    }
         //spoejini formatu data 
       public static String casFormat(String a,String b){
        
        String s;
        
       s= ciselFormat(a,2)+":"+ciselFormat(b,2);
        
        return s;
    }
   }       


  
    
    

