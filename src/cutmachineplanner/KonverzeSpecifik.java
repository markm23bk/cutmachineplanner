/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import javax.swing.JOptionPane;

/**
 *
 * @author petr
 */
public class KonverzeSpecifik {
    
    String hlavzak;
    int terden;
    int termes;
    int terrok;
    int terhod;
    int termin;
    String cisrol;
    int delkrol;
    int deadden;
    int deadmes;
    int daedrok;
    int deadhod;
    int deadmin;
    
    public KonverzeSpecifik(String a,String b,String c,String d,String e,String f,
            String g,String h,String i,String j,String k,String l,String m){
        //hlavzak 
        try{
     int z=Integer.parseInt(a);
     if(z > 99999999 || z<=0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format v cisle hlavni zakazky", "Title", JOptionPane.ERROR_MESSAGE);
        };
        
        //termden 
              try{
     int z=Integer.parseInt(b);
     if(z > 99999999 || z<=0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format v cisle zakazky", "Title", JOptionPane.ERROR_MESSAGE);
        };
        
    }
    
}
