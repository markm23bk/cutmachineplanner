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
   
   Integer c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;
   Integer vymet;
 
   
    public static boolean kontrolaBobin(String a,String b,String c,String d,String e,String f,
            String g,String h,String i,String j,String k){
        
        boolean kontrolaok = true;
  
        //c3
        try{
    int a2=Integer.parseInt(a);
    if (a2<0 || 1120<a2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c1", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
        
        //c2
             try{
    int b2=Integer.parseInt(b);
    if (b2<0 || 1120<b2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c2", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
             
       //c3
         try{
    int c3=Integer.parseInt(c);
    if (c3<0|| 1120<c3){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c3", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
      
         //c4
              try{
    int d2=Integer.parseInt(d);
    if (d2<0 || 1120<d2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c4", "Title", JOptionPane.ERROR_MESSAGE);
       kontrolaok = false;
        }
       
       //c5
                         try{
    int e2=Integer.parseInt(e);
    if (e2<0 || 1120<e2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c5", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
       //c6
                      try{
    int f2=Integer.parseInt(f);
    if (f2<0 || 1120<f2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c6", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
      //c7
                                 try{
    int g2=Integer.parseInt(g);
    if (g2<0 || 1120<g2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c7", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
      //c8
                                            try{
    int h2 =Integer.parseInt(h);
    if (h2<0 || 1120<h2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c8", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
      //c9
                                                       try{
    int i2=Integer.parseInt(i);
    if (i2<0 || 1120<i2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c9", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
                                                       
     //c10
                                                                  try{
    int j2=Integer.parseInt(j);
    if (j2<0 || 1120<j2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c10", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
     //c11
                                                                             try{
    int k2=Integer.parseInt(k);
    if (k2<0 || 1120<k2){throw new Exception();};
     
    
        }catch (Exception n){
      JOptionPane.showMessageDialog (null, "Chybne zadany format c11", "Title", JOptionPane.ERROR_MESSAGE);
      kontrolaok = false;
        }
    if (kontrolaok){return true;}else{return false;}
    }
    
    
    public KonverzeBobin(String a,String b,String c,String d,String e,String f,
            String g,String h,String i,String j,String k){
    
   c1 =Integer.parseInt(a);
   c2 =Integer.parseInt(b);
   c3 =Integer.parseInt(c);
   c4 =Integer.parseInt(d);
   c5 =Integer.parseInt(e);
   c6 =Integer.parseInt(f);
   c7 =Integer.parseInt(g);
   c8 =Integer.parseInt(h);
   c9 =Integer.parseInt(i);
   c10=Integer.parseInt(j);
   c11=Integer.parseInt(k);
   //int vymet;    
        
    }
    
}
