/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.util.Calendar;

/**
 *
 * @author petr
 */
public class KonverzeDatum {
 
  Integer termden;
  Integer termmes;
  Integer termrok;
  
  Integer termhod;
  Integer termin;
  
  Integer deadhod;
  Integer deadmin; 
  
  Integer deadden;
  Integer deadmes;
  Integer deadrok;
  
  Integer endrok;
  Integer endmes;
  Integer endden;
  Integer endhod;
  Integer endmin;
  
  
  public KonverzeDatum(Calendar ter,Calendar dead,String termho,String termmi,
                           String deadho,String deadmi,DobaVyroby doba){
   
   termden = ter.get(Calendar.DAY_OF_MONTH);
   termmes = ter.get(Calendar.MONTH)+1;
   termrok = ter.get(Calendar.YEAR);
   termhod =Integer.parseInt(termho);
   termin = Integer.parseInt(termmi);
  
   deadden = dead.get(Calendar.DAY_OF_MONTH);
   deadmes = dead.get(Calendar.MONTH)+1;
   deadrok = dead.get(Calendar.YEAR);  
   deadhod = Integer.parseInt(deadho);
   deadmin = Integer.parseInt(deadmi);
   
   //pricteni data a tvorba konecneho terminu 
    ter.set(termrok, termmes-1, termden, termhod, termin);
    ter.add(Calendar.MINUTE,doba.doba);
          
   endrok = ter.get(Calendar.YEAR);
   endmes = ter.get(Calendar.MONTH)+1;
   endden = ter.get(Calendar.DAY_OF_MONTH);
   endhod = ter.get(Calendar.HOUR_OF_DAY);
   endmin = ter.get(Calendar.MINUTE);
   
    
  }
    
}
