/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cutmachineplanner;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class CustomRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            return this;
        }

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //     Number val = (Number)value;
        String number = (String) value;
        //        int va = Integer.parseInt(number);  
        if (!table.isRowSelected(row)) {

            if (Integer.parseInt((table.getValueAt(row, 15).toString())) == 1) {
//           if(row == table.getSelectedRow()){  
                c.setBackground(Color.GREEN);
            } else if (Integer.parseInt((table.getValueAt(row, 15).toString())) == 2) {
                c.setBackground(Color.RED);
            } else {
                c.setBackground(Color.YELLOW);
            }
        }
//  
//            
//            }
        return this;
        //c.setBackground(Color.RED);



    }
}