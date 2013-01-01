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
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author petr
 */
public class OperPapir {
    
    
    
    
    public static void pridejPap (String oznaceni,String rychlost){
      
       if (kontrolaUdaju(oznaceni,rychlost)){ 
       
      Identifikator Ident = new Identifikator("druhpapiru","cislopap");
     
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       
       
       //konverze rychlosti
       Integer rych = Integer.parseInt(rychlost);
       //ulozeni nove osoby a povyseni jeji role o 1 kvuli comboboxu 
      CutMachine.entity.Druhpapiru Pap = new CutMachine.entity.Druhpapiru 
              (Ident.id,oznaceni,rych);
         
          try {
      session.beginTransaction();
      session.save(Pap);
       session.getTransaction().commit();
        
    } catch (HibernateException he) {
        he.printStackTrace();;
    }
      finally {session.close();}
    }else System.out.println( "Chyba pri zadani udaju, zadej znovu !!!");
             
   
    }
    
    
    
    
    
 public static void odeberPap(String oznaceni){
        
    if (oznaceni.length() ==0 ){JOptionPane.showMessageDialog (null, "Zadej udaj oznaceni znovu!!!", "Title", JOptionPane.ERROR_MESSAGE);return;}
    
        
        
  try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();  

//test zda existuje zadany user 
ResultSet rs = st.executeQuery( "select cislopap from druhpapiru where druhpap='"+oznaceni+"' ;" );

// jestlize nenalezne usera zada o upresneni , jestli jo vymaze ho 
if (rs.first()){st.executeUpdate( "delete from druhpapiru where druhpap='"+oznaceni+"' ;" );}
   else {JOptionPane.showMessageDialog (null, "Zadej znovu udaje, papir nebyl nalezen !!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);return;}

  
}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");

System.out.println(e.toString());} 
      
    }
   
    
    
    
    
    
 public static boolean kontrolaUdaju(String oznaceni,String rychlost){
    boolean udajeok =true;

if (oznaceni.length() ==0){ udajeok =false;JOptionPane.showMessageDialog (null, "Zadej znovu oznaceni !!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}
     

 int z=Integer.parseInt(rychlost);
 if(z <1 || 600<z){udajeok = false;
     JOptionPane.showMessageDialog (null, "Zadej znovu rychlost!!!", "Title", JOptionPane.ERROR_MESSAGE);} 
        
 
   return udajeok;}
   

}
