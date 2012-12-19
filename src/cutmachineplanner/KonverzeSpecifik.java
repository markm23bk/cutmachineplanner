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
    Integer terden;
    Integer termes;
    Integer terrok;
    Integer terhod;
    Integer termin;
    Integer sirrol;
    Integer grampap;
    String  cisrol;
    Integer delkrol;
    Integer deadden;
    Integer deadmes;
    Integer daedrok;
    Integer deadhod;
    Integer deadmin;
    
    public static void konverze(String hlazak,String termhod,String termmin,
                String cisrol,String delrol,
                String deadhod,String deadmin,String c1,String c2,
                String c3,String c4,String c5,String c6,String c7,
                String c8,String c9,String c10,String c11,String vymet
            ,Calendar ter, Calendar dead,int druhpap,String sirrol,int grampa)
    {
     boolean formatok;
     boolean formatbob;
     boolean done; 
     
             
        //kontrola formatu specifik
        formatok = kontrolaSpec( hlazak,termhod,termmin,sirrol,
                                        cisrol, delrol,deadhod, deadmin,grampa);
        //kontrola formatu boboin
         formatbob = KonverzeBobin.kontrolaBobin(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
           
         //jestlize kotrola dat selze vyskouci se z metody
        if(!(formatbob && formatok))return;
        
                //vytvoreni objektu specifika
                 KonverzeSpecifik Specifika = new KonverzeSpecifik( hlazak,
                                                            cisrol, delrol,sirrol,grampa); 
                 //tvorbu objektu rozmeru boboin
                 KonverzeBobin Bobiny = new KonverzeBobin(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
                 //ziskanni doby zakazky
                 DobaVyroby Doba = new DobaVyroby (druhpap,grampa);
                 //tvorba objektu datumu -termin (start,konec) a deadline 
                 KonverzeDatum Dat = new KonverzeDatum (ter,dead,termhod,termmin,deadhod,deadmin,Doba);
                 //ziskani cisla zakazky
                GeneratorCisZak Cislozak = new GeneratorCisZak ();
                 //kontrola kapacity
                //KontrolaKapacity Kap = new KontrolaKapacity (Dat);
                
                
               
                
        
          
         //ulozeni dat
       done = UlozData.dataUlozeni(Specifika,Bobiny,Dat,Cislozak,druhpap,Doba);
       
       //vyhodnoceni ulozeni dat
       if (!done){ JOptionPane.showMessageDialog (null, "Ulozeni zakazky se nezdarilo, zadej znovu!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}
  }
    
    
    
    
    
    
  public static boolean kontrolaSpec( String hlazak,String termhod,String termmin,String sirrol,
                                        String cisrol,String delrol,String deadhod,String deadmin,int grampap){
      boolean format = true;
          //hlavzak 
        try{
     int z=Integer.parseInt(hlazak);
     if(z > 99999999 || z<=0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format v cisle hlavni zakazky", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;};     
      //termhod
          try{
      int  z=Integer.parseInt(termhod);
     if(z > 23 || z<0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format terminu hodin", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;};        
      //termmin
                  try{
     int z=Integer.parseInt(termmin);
     if(z > 59 || z< 0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format terminu minut", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
              //sirrol
                  try{
     int z=Integer.parseInt(sirrol);
     if(z > 1120 || z< 0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format sirka role", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //cisrol
                  try{
     int z=Integer.parseInt(cisrol);
     if(z<=0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format cisla role", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //delrol
                  try{
     int z=Integer.parseInt(delrol);
     if(z<1){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format delky role", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //deadhod
             try{
      int  z=Integer.parseInt(deadhod);
     if(z > 23 || z<0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format deadline terminu hodin", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //deadmin
                         try{
     int z=Integer.parseInt(deadmin);
     if(z > 59 || z< 0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format dealine terminu minut", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      //grampap
        try{
         if(grampap == 0){throw new Exception();};
     
        }catch (Exception y){
        JOptionPane.showMessageDialog (null, "Chybne zadany format dealine terminu minut", "Title", JOptionPane.ERROR_MESSAGE);
        format = false;}; 
      
      if (format)return true; else return false;
   
      
  } 
  
  public KonverzeSpecifik ( String hlaz,String cisr,String delkr,
           String sirro, int grampa){    
    hlavzak= hlaz;
    cisrol= cisr;
    delkrol=Integer.parseInt(delkr);
    sirrol =Integer.parseInt(sirro); 
    grampap =(Integer) grampa;
  }

}
    
