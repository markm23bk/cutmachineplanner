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
    
  int termden;
  int termmes;
  int termrok;
  int deadden;
  int deadmes;
  int deadrok;
  
  KonverzeDatum(Calendar cal1,Calendar cal2){
   
   termden = cal1.get(Calendar.DAY_OF_MONTH);
   termmes = cal1.get(Calendar.MONTH);
   termrok = cal1.get(Calendar.YEAR);
   deadden = cal2.get(Calendar.DAY_OF_MONTH);
   deadmes = cal2.get(Calendar.MONTH);
   deadrok = cal2.get(Calendar.YEAR);      
  }
    
}
