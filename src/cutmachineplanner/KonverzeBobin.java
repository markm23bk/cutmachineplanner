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
public class KonverzeBobin {
   
   int c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;
   int vymet;
 
   
    public KonverzeBobin(String a,String b,String c,String d,String e,String f,
            String g,String h,String i,String j,String k){
  
        //c3
        try{
    c1=Integer.parseInt(a);
    if (c1<5 || 120<c1){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c1", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
        
        //c2
             try{
    c2=Integer.parseInt(b);
    if (c2<5 || 120<c2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c2", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
             
       //c3
         try{
    c3=Integer.parseInt(c);
    if (c3<5 || 120<c3){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c3", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
      
         //c4
              try{
    c4=Integer.parseInt(d);
    if (c4<5 || 120<c4){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c4", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
       
       //c5
                         try{
    c5=Integer.parseInt(e);
    if (c5<5 || 120<c5){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c5", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
       //c6
                      try{
    c6=Integer.parseInt(f);
    if (c6<5 || 120<c6){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c6", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
      //c7
                                 try{
    c7=Integer.parseInt(g);
    if (c7<5 || 120<c7){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c7", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
      //c8
                                            try{
    c8=Integer.parseInt(h);
    if (c8<5 || 120<c8){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c8", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
      //c9
                                                       try{
    c9=Integer.parseInt(i);
    if (c9<5 || 120<c9){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c9", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
                                                       
     //c10
                                                                  try{
    c10=Integer.parseInt(j);
    if (c10<5 || 120<c10){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c10", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
     //c11
                                                                             try{
    c11=Integer.parseInt(k);
    if (c11<5 || 120<c11){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c11", "Title", JOptionPane.ERROR_MESSAGE);
     
        }
    }
    
}
