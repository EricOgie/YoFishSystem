/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;

// Import libraries
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Eric Ogie Aghahowa
 */
public class YoFishTableModel extends AbstractTableModel {
    
    // Class fields
    private String[] columns;
    private Object[][] data;

    public YoFishTableModel(final String[] columnList, final ArrayList<FishProduct> data) {
        // calculate the total number of columns
        int NumberOfColumns = columnList.length;
        
        // statically copy passed data
        this.columns = Arrays.copyOf(columnList, NumberOfColumns);
        
        // Define the size of 2D array
        this.data = new Object[data.size()][NumberOfColumns];
        
        int index = 0;
        for(FishProduct fish : data){
            // Create row entry item on every iteration
            Object[] rowData = new Object[]{ fish.getId(), fish.getItem(), 
                                             fish.getFormattedPrice(), fish.getStock(), 
                                             fish.getMaxSize(), fish.getLowTemp(), fish.getHighTemp()
                                           };
            
            // Add linear array to 2d Array
            this.data[index] = Arrays.copyOf(rowData, NumberOfColumns);
            index++;
        }
        
    } // end of constructor
    
    

    @Override
    public int getRowCount() {
        // calculate and return row count with respect to the total row data size
        return this.data.length;
    }

    @Override
    public int getColumnCount() {
        // calculate and return the number of columns
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // calculate and return the value at column-row interception
        return this.data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.data[rowIndex][columnIndex] = aValue;
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    
}
