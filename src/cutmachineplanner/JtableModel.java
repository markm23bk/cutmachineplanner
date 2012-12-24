/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.util.Calendar;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author petr
 */
public class JtableModel {

   
    
    public static Vector JtableMod(){
       
      Vector<String> column = new Vector<String>();
      column.addElement("Cislo zakazky");  
      column.addElement("Poc.termin");
       column.addElement("Konc.termin");
        column.addElement("Druh papiru");
         column.addElement("c1");
         column.addElement("c2");
         column.addElement("c3");
         column.addElement("c4");
         column.addElement("c5");
         column.addElement("c6");
         column.addElement("c7");
         column.addElement("c8");
         column.addElement("c9");
         column.addElement("c10");
         column.addElement("c11");
         
         //JtableData.vytvorData(cal)
         
     
         
     return column;   
    }
    
}
