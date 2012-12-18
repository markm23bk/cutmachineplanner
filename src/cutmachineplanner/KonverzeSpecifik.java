/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.util.Calendar;
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
    
    public static void konverze(String hlazak,String termhod,String termmin,
                String cisrol,String delrol,
                String deadhod,String deadmin,String c1,String c2,
                String c3,String c4,String c5,String c6,String c7,
                String c8,String c9,String c10,String c11,String vymet
            ,Calendar t, Calendar u,int druhpap,int sirrol,int grampap)
    {
     boolean formatok;
     boolean formatbob;
     boolean done;        
             
        //kontrola formatu specifik
        formatok = kontrolaSpec( hlazak,termhod,termmin,
                                        cisrol, delrol,deadhod, deadmin);
        //kontrola formatu boboin
         formatbob = KonverzeBobin.kontrolaBobin(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
           
         //jestlize kotrola dat selze vyskouci se z metody
        if(!(formatbob && formatok))return;
        
                //vytvoreni objektu specifika
                 KonverzeSpecifik Specifika = new KonverzeSpecifik( hlazak,termhod,termmin,
                                                            cisrol, delrol,deadhod, deadmin); 
                 //tvorbu objektu rozmeru boboin
                 KonverzeBobin Bobiny = new KonverzeBobin(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
                 //tvorba objektu datumu -termin (start,konec) a deadline 
                 KonverzeDatum Dat = new KonverzeDatum (t,u);
                 //ziskani cisla zakazky
                GeneratorCisZak Cislozak = new GeneratorCisZak ();
        
          
         //ulozeni dat
       done = UlozData.dataUlozeni(Specifika,Bobiny,Cislozak,druhpap,sirrol,grampap);
       
       //vyhodnoceni ulozeni dat
       if (!done){ JOptionPane.showMessageDialog (null, "Ulozeni zakazky se nezdarilo, zadej znovu!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}
  }
    
    
    
    
    
    
  public static boolean kontrolaSpec(String a,String b,String c,String d,String e,String f,
            String g){
      boolean format = true;
          //hlavzak 
        try{
     int z=Integer.parseInt(a);
     if(z > 99999999 || z<=0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format v cisle hlavni zakazky", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;};     
      //termhod
          try{
      int  z=Integer.parseInt(b);
     if(z > 23 || z<0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format terminu hodin", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;};        
      //termmin
                  try{
     int z=Integer.parseInt(c);
     if(z > 59 || z< 0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format terminu minut", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //cisrol
                  try{
     int z=Integer.parseInt(d);
     if(z<=0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format cisla role", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //delrol
                  try{
     int z=Integer.parseInt(e);
     if(z<1){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format delky role", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //deadhod
             try{
      int  z=Integer.parseInt(f);
     if(z > 23 || z<0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format deadline terminu hodin", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //deadmin
                         try{
     int z=Integer.parseInt(g);
     if(z > 59 || z< 0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format dealine terminu minut", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
          
      if (format)return true; else return false;
      
      
  } 
  
  public KonverzeSpecifik (String a,String b,String c,String d,String e,String f,
            String g){    
    hlavzak= a;
    terhod=Integer.parseInt(b);
    termin=Integer.parseInt(c);
    cisrol= d;
    delkrol=Integer.parseInt(e);
    deadhod =Integer.parseInt(f);
    deadmin =Integer.parseInt(g);    
  }

}
    

