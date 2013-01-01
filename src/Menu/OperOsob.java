/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import cutmachineplanner.NewHibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author petr
 */
public class OperOsob {
    
    
    public static void pridejOs(String jmeno,String prijmeni,String user,String pass,int role){
        
   
      if (kontrolaUdaju(jmeno,prijmeni,user,pass)){
          
      Identifikator Ident = new Identifikator("Person","cislozam");
     
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       
       //ulozeni nove osoby a povyseni jeji role o 1 kvuli comboboxu 
      CutMachine.entity.Person Pers = new CutMachine.entity.Person
              (Ident.id,jmeno,prijmeni,user,pass,role+1);
         
  
          try {
       
      session.beginTransaction();
      
      session.save(Pers);
     
 
       session.getTransaction().commit();
        
    } catch (HibernateException he) {
        he.printStackTrace();;
    }
      finally {session.close();}
    }else System.out.println("chyba pri odeslani registrace osoby");
    
        
    
    }  
    
    
    
    public static void odeberOs(String jmeno,String prijmeni,String user,String pass){
        
    if (jmeno.length() !=0)jmeno =" jmeno ='"+jmeno+"' and ";
    if (prijmeni.length() !=0)prijmeni =" prijmeni ='"+prijmeni+"' and ";
    if (user.length() !=0)user =" username ='"+user+"' and ";
    if (pass.length() !=0)pass =" password ='"+pass+"' and ";
        
        
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement(); 

    System.out.println("select cislozam from person where "+jmeno+prijmeni+user+pass+" role!=0 ;");

//test zda existuje zadany user 
ResultSet rs = st.executeQuery( "select cislozam from person where "+jmeno+prijmeni+user+pass+" role!=0 ;" );

// jestlize nenalezne usera zada o upresneni , jestli jo vymaze ho 
if (rs.first()){st.executeUpdate( "delete from Person where"+jmeno+prijmeni+user+pass+" role!=0 ;" );}
   else JOptionPane.showMessageDialog (null, "Zadej znovu udaje, uzivatel nebyl nalezen !!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);

  
}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");

System.out.println(e.toString());}
        
    }


    
public static boolean kontrolaUdaju(String jmeno,String prijmeni,String user,String pass){
boolean udajeok =true;

if (jmeno.length() ==0){ udajeok =false;JOptionPane.showMessageDialog (null, "Zadej udaj jmeno !!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}
if (prijmeni.length() ==0){ udajeok =false;JOptionPane.showMessageDialog (null, "Zadej udaj prijmeni !!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}
if (user.length() ==0){ udajeok =false;JOptionPane.showMessageDialog (null, "Zadej udaj username !!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}
if (pass.length() ==0){ udajeok =false;JOptionPane.showMessageDialog (null, "Zadej udaj password !!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}

return udajeok;}

}
