/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCart;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Kevin Wang
 */
public class CourseInfoTableListener implements TableModelListener{
    
    @Override
    public void tableChanged(TableModelEvent e){
        int row = e.getFirstRow();
        TableModel model = (TableModel)e.getSource();
        Boolean data = (Boolean) model.getValueAt(row, 0);
//        System.out.println("Row: " + row + ", Data: " + data);//Debugging
        
        if(data){
            for(int rowPosition = 0; rowPosition < model.getRowCount(); rowPosition++){
                if((Boolean) model.getValueAt(rowPosition, 0) && rowPosition != row){
                    model.setValueAt(false, rowPosition, 0);
                }
            }
        }
    }
    
}
