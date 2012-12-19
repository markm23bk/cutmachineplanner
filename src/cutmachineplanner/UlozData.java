/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author petr
 */
public class UlozData {
      boolean done;
      
    public static boolean dataUlozeni(KonverzeSpecifik Specifika,KonverzeBobin Bobiny,
                                KonverzeDatum Dat,GeneratorCisZak Cislozak,int druhpap,
                                DobaVyroby Doba)
    
    {
       
     // tvorba session tovarny
    Session session = NewHibernateUtil.getSessionFactory().openSession();
     

     //tab deadline 
    CutMachine.entity.Deadline Dead = new CutMachine.entity.Deadline(Cislozak.nove,Dat.deadden,
                  Dat.deadmes,Dat.deadrok,Dat.deadhod,Dat.deadmin);
    
    //tab inputmaterial 
     Integer druh = new Integer(druhpap);
     CutMachine.entity.Inputmaterial Input = new  CutMachine.entity.Inputmaterial(Cislozak.nove,
                  Specifika.cisrol,Specifika.sirrol,druh);
     
    //tab outputmaterial 
  
     CutMachine.entity.Outputmaterial Output = new  CutMachine.entity.Outputmaterial(Cislozak.nove,
                      Bobiny.c1,Bobiny.c2,Bobiny.c3,Bobiny.c4,Bobiny.c5,Bobiny.c6,Bobiny.c7,
                       Bobiny.c8,Bobiny.c9,Bobiny.c10,Bobiny.c11);
     
     //tab responsibility
     CutMachine.entity.Responsibility Respon = new CutMachine.entity.Responsibility (Cislozak.nove,
             HR.AktualniOsoba.osoba);
     
     //termin
     //dodelat vyrobni dobu a state
     //1 state / ceka na vyrobu 

     CutMachine.entity.Termin Term = new CutMachine.entity.Termin (Cislozak.nove,Dat.termden,
             Dat.termmes,Dat.termrok,Dat.termhod,Dat.termin,
             Dat.endden,Dat.endmes,Dat.endrok,Dat.endhod,Dat.endmin,Doba.doba,1);
         
  
          try {
       
      session.beginTransaction();
      
      session.save(Dead);
      session.save(Input);
      session.save(Output);
      session.save(Respon);
      session.save(Term);
 
     
        session.getTransaction().commit();
        
    } catch (HibernateException he) {
        he.printStackTrace();return false;
    }
      finally {session.close();return true;}
    }
}
        
    
    
    

