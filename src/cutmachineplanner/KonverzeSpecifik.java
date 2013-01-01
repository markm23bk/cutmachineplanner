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
    
  
    String cisvyr;
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
    
    public static void konverze(String cislovyr,String termhod,String termmin,
                String cisrol,String delrol,
                String deadhod,String deadmin,String c1,String c2,
                String c3,String c4,String c5,String c6,String c7,
                String c8,String c9,String c10,String c11,String vymet
            ,Calendar ter, Calendar dead,int druhpap,String sirrol,int cislozk)
    {
     boolean formatok;
     boolean formatbob;
     boolean kapacitaok;
     boolean done; 
     
             
        //kontrola formatu specifik
        formatok = kontrolaSpec( cislovyr,termhod,termmin,sirrol,
                                        cisrol, delrol,deadhod, deadmin);
        //kontrola formatu boboin
         formatbob = KonverzeBobin.kontrolaBobin(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
           
         //jestlize kotrola dat selze vyskouci se z metody
        if(!(formatbob && formatok))return;
        
                //vytvoreni objektu specifika
                 KonverzeSpecifik Specifika = new KonverzeSpecifik( cislovyr,
                                                            cisrol, delrol,sirrol); 
                 //tvorbu objektu rozmeru boboin
                 KonverzeBobin Bobiny = new KonverzeBobin(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11);
                 //ziskanni doby zakazky
                 DobaVyroby Doba = new DobaVyroby (druhpap,Specifika.delkrol);
                 //tvorba objektu datumu -termin (start,konec) a deadline 
                 KonverzeDatum Dat = new KonverzeDatum (ter,dead,termhod,termmin,deadhod,deadmin,Doba);
                 //kontrola vztahu mezi udaji 
               if(kontrolLog(Bobiny,Specifika,Dat))return;
                 
                 //ziskani cisla zakazky
                 GeneratorCisZak Cislozak = new GeneratorCisZak ();
                 //kotrola kapacity      
                 kapacitaok = KontrolaKapacity.volnaKapacita(Dat,cislozk);
                 
                if(!kapacitaok){JOptionPane.showMessageDialog 
                  (null, "Neni Kapacita!!! ", "Title", JOptionPane.ERROR_MESSAGE);
                    return;};
//                
//               {NewJFrame.vymazZakazku(Integer.toString(cislozk));
//                  Cislozak.nove = cislozk;};
               
                if (cislozk!=0){Cislozak.nove = cislozk;NewJFrame.vymazZakazku(Integer.toString(cislozk));};
                    

         //ulozeni dat
         done = UlozData.dataUlozeni(Specifika,Bobiny,Dat,Cislozak,druhpap,Doba);
       
         
       //vyhodnoceni ulozeni dat
       if (!done){ JOptionPane.showMessageDialog (null, "Ulozeni zakazky se nezdarilo, zadej znovu!", 
                 "Title", JOptionPane.ERROR_MESSAGE);}
  
    
    }
    
    
    
    
  public static boolean kontrolaSpec( String hlazak,String termhod,String termmin,String sirrol,
                                        String cisrol,String delrol,String deadhod,String deadmin){
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
    
      
      if (format)return true; else return false;
    
  } 
  
  
  
  //kontrola logiky mezi udaji
  public static boolean kontrolLog(KonverzeBobin Bobiny,KonverzeSpecifik Specifika,KonverzeDatum Dat){
      boolean logok=true;
       int soucet;
       Calendar zackal= Calendar.getInstance();
       Calendar ukkal= Calendar.getInstance();
       Calendar deadkal= Calendar.getInstance();
       
      //kontrola sire role a souctu bobin  
      soucet= Specifika.sirrol - (Bobiny.c1+Bobiny.c2+Bobiny.c3+Bobiny.c4+Bobiny.c5+Bobiny.c6+Bobiny.c7+
              Bobiny.c8+Bobiny.c8+Bobiny.c10+Bobiny.c11);
      if (soucet<1) {logok = false;
        JOptionPane.showMessageDialog (null, "Sire role je mensi nez soucet siri bobin,zadej znovu!!!", "Title", JOptionPane.ERROR_MESSAGE);
        }
      
      
      //kotrola dealine a teminu zahajeni a ukonceni
      zackal.set(Dat.termrok, Dat.termmes, Dat.termden, Dat.termhod, Dat.termin);
      ukkal.set(Dat.endrok, Dat.endmes, Dat.endden, Dat.endhod, Dat.endmin);
      deadkal.set(Dat.deadrok, Dat.deadmes, Dat.deadden, Dat.deadhod,Dat.deadmin);
      
      if (zackal.compareTo(deadkal)!=-1){logok = false;
           JOptionPane.showMessageDialog (null, "Termin zahajeni vyroby je po Deadlinu,zadej znovu!!!", "Title", JOptionPane.ERROR_MESSAGE);
        }
      
          
      if (ukkal.compareTo(deadkal)!=-1){logok = false;
          JOptionPane.showMessageDialog (null, "Termin ukonceni vyroby je po Deadlinu,zadej znovu!!!", "Title", JOptionPane.ERROR_MESSAGE);
        }
      
      
      return logok;  
  }
  

  
  //konstruktor
  public KonverzeSpecifik ( String cislovyr,String cisr,String delkr,String sirro ){    
    cisvyr = cislovyr;
    cisrol= cisr;
    delkrol=Integer.parseInt(delkr);
    sirrol =Integer.parseInt(sirro); 
    
  }

}
    

