/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import cutmachineplanner.NewJFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author petr
 */
public class OperAuten {
    
    public static void autentizuj(String user,String pass){
        
      boolean autok=true; 
      
        try{ Class.forName("com.mysql.jdbc.Driver"); }
  catch(Exception e){ System.out.println("Chyba driveru");
  System.out.println(e.toString());
}

try{
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cutPlanner","root","");
Statement st = conn.createStatement();  

//test zda existuje zadany user 
ResultSet rs = st.executeQuery( "select cislozam from Person where username='"+user+"' and password='"+pass+"' ;");



// jestlize nenalezne usera zada o upresneni, jestli ano , inicializuje promenou osoba v JFrame 
if (!rs.first()){autok = false;JOptionPane.showMessageDialog (null, "Zadej udaje znovu, uzivatel nebyl nalezen!!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);return;}
else NewJFrame.osoba = rs.getInt(1);
  
}catch(Exception e){ System.out.println("Chyba volani, neprihlaseno");

System.out.println(e.toString());}




if (autok)JOptionPane.showMessageDialog (null, " AUTENTIZOVAN!!!", 
                 "Title", JOptionPane.ERROR_MESSAGE);
        
    }
        
        
    }
    

