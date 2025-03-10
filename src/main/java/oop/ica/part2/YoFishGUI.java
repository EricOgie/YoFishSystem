/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oop.ica.part2;


import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;
import static oop.ica.part2.Constants.*;

/**
 *
 * @author Eric Ogie Aghahowa
 */
public class YoFishGUI extends javax.swing.JFrame {

    /**
     * Creates new form YoFishGUI
     */
    public YoFishGUI() {
        // Load Data
        try{
            fishItemList = FileUtils.readInputFiles();
        }catch(Exception e){
            System.err.println(LOADING_ERR_MSG + e.getMessage());
            showErrorAndQuit();
        }
        
        // Check and abort if fishItemList is null or empty.
        if(fishItemList == null || fishItemList.isEmpty()){
            // Warn the user of empty list and quit
            System.out.println(LOADING_ERR_MSG + MISSING_ITEMS);
            showErrorAndQuit();
        }  
        // Load fishItem images
        picList = FileUtils.fetchesItemImages();
        // Load components
        initComponents();
        initTable();
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        itemLabel = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        buyButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        yoFishTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yo-Fish");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        picPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Photo"));

        picLabel.setBackground(new java.awt.Color(0, 0, 0));
        picLabel.setText("jLabel1");
        picLabel.setOpaque(true);

        itemLabel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        itemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout picPanelLayout = new javax.swing.GroupLayout(picPanel);
        picPanel.setLayout(picPanelLayout);
        picPanelLayout.setHorizontalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(itemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(picLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        picPanelLayout.setVerticalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picPanelLayout.createSequentialGroup()
                .addComponent(picLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        quitButton.setBackground(new java.awt.Color(255, 51, 0));
        quitButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quitButton.setForeground(new java.awt.Color(255, 255, 255));
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        buyButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buyButton.setText("Buy");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        yoFishTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        yoFishTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yoFishTableMouseClicked(evt);
            }
        });
        yoFishTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yoFishTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yoFishTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(yoFishTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyButton)
                            .addComponent(addButton)
                            .addComponent(quitButton))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        add();
    }//GEN-LAST:event_addButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        quit();
    }//GEN-LAST:event_formWindowClosing

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        quit();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        buy();
    }//GEN-LAST:event_buyButtonActionPerformed

    private void yoFishTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yoFishTableMouseClicked
        commonFocusActions(yoFishTable.getSelectedRow());
    }//GEN-LAST:event_yoFishTableMouseClicked

    private void yoFishTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yoFishTableKeyPressed
       // commonFocusActions(yoFishTable.getSelectedRow());
    }//GEN-LAST:event_yoFishTableKeyPressed

    private void yoFishTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yoFishTableKeyReleased
        commonFocusActions(yoFishTable.getSelectedRow());
    }//GEN-LAST:event_yoFishTableKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoFishGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoFishGUI().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton buyButton;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JButton quitButton;
    private javax.swing.JTable yoFishTable;
    // End of variables declaration//GEN-END:variables

    // class Level Object Variables
    private ArrayList<FishProduct> fishItemList;
    private ArrayList<BufferedImage> picList;
    private int index = 0;
    private boolean isFocused = false;
    YoFishTableModel model;
    
    
//---------------- User Defined Methods ---------------------- //
   /*
    * Initializes the table by creating a custom table model, 
    * linking it to the UI JTable, and setting column headers.
   */
    private void initTable(){
        // Define the instance of our custom table model
        model = new YoFishTableModel(COLUMNS, fishItemList);
        
        //Link the UI Jtable to the custom table model
        yoFishTable.setModel(model);
        
        for (int x = 0; x < yoFishTable.getColumnCount(); x++){
            // Get the column in current iteration
            TableColumn column = yoFishTable.getTableHeader().getColumnModel().getColumn(x);
            
            // Set column header for the current iteration
            column.setHeaderValue(COLUMNS[x]);
        }
        
    }// end of initTble method
    
   
  
    // Displays the image associated with the focused item, if available.
    private void displayImage(){
        // clear any previously display details
        picLabel.setText("");
        picLabel.setIcon(null);
        
        // Get focused image and display when available
        BufferedImage itemImage = picList.get(index);
        if(itemImage == null){
            picLabel.setText(IMAGE_404);
        }else{
            picLabel.setIcon(new ImageIcon(itemImage));
        }
    }
    

        
    // Shows an error message dialog and quits the application.
    private void showErrorAndQuit(){
        JOptionPane.showMessageDialog(
                null, 
                DATA_ERR, 
                ERR, 
                JOptionPane.ERROR_MESSAGE
        ); 
        // Quit application upon dialog exit
        quit();
    }
    
    // Quits the application after persisting fishItemList data to the output file.
    private void quit(){
        // Persist fishItemList in output file
        FileUtils.saveData(fishItemList);
        // Exit application
        System.exit(ZERO);
    }
    
    
   /*
    * Performs common actions when an item is focused, such as updating the image and item details display.
    *
    * @param focusedIndex The index of the focused item in the fishItemList.
   */
    private void commonFocusActions(int focusedIndex){
        index = focusedIndex;
        FishProduct itemClick = fishItemList.get(focusedIndex);
        displayImage();
        itemLabel.setText(itemClick.getItem());
        warnIfLowStock(itemClick.getStock(), itemClick.getItem(), FIVE);
        isFocused = true;
    }
    
    // Initiates the buy operation, allowing the user to purchase a selected item.
    private void buy(){
        // Check and warn user if no item is in focus
        if(!isFocused){
            // Warning user about no item selection
            showWarnings(NO_ITEM_MSG, NO_SELECT_TITLE);
            // The buy operation should break since no item is in focus.
            return;
        }
        // Get focused item
        FishProduct item = fishItemList.get(index);
        // Warn user if focused item is out of stock and break flow
        warnIfLowStock(item.getStock(), item.getItem(), LOWEST_LIMIT);
        if(item.getStock() < 1) return;
        
        // Run flow to buy seleted item
        Integer[] optionSet = getDropDownIntegers(LOWEST_LIMIT,item.getStock());
        // Get user input from dialog
        int selectedOption = showInputDialog(optionSet, ACTION_BUY);
        
        // selectedOptiont will be ZERO if user cancel input dialog.
        // and we want to break the flow if this is the case.Hence the early return below
        if(selectedOption == ZERO) return;
        
        // Since user has entered a valid non zero number, we will proceed with BUY flow
        int newStock = item.getStock() - selectedOption;
            
        // Update stock count in fishItemList
        fishItemList.get(index).setStock(newStock);
        // Update value at focused row-column intersection (i.e stock cell in the table)
        int selectedRow = yoFishTable.getSelectedRow();
        yoFishTable.setValueAt(newStock, selectedRow, STOCK_COL_INDEX);
        
        // Notify user of sale
        String confirmationMsg = Constants.buyConfirmMsg(item.getItem(), item.getFormattedPrice(),
                selectedOption, fishItemList.get(index).getStock());
        
        JLabel receiptLabel = new JLabel(confirmationMsg);
        JOptionPane.showMessageDialog(null, receiptLabel, CONFIRM_SALE_TITLE, JOptionPane.INFORMATION_MESSAGE);
    
        // Warn user if new stock count is now less than FIVE
        warnIfLowStock(fishItemList.get(index).getStock(), item.getItem(), FIVE);
    }
    
    // Initiates the add operation, allowing the user to add stock to a selected item.
    private void add(){
        // Check and warn user if no item is in focus
        if(!isFocused){
            // Warning user about no item selection
            showWarnings(NO_ITEM_MSG, NO_SELECT_TITLE);
            // The buy operation should break since no item is in focus.
            return;
        }
        
        // Generate Dropdown option set
        Integer[] optionSet = getDropDownIntegers(FIVE,TEN);
        
        // Get user input from dialog
        int selectedOption = showInputDialog(optionSet, ACTION_ADD);
        
        // selectedOptiont would be ZERO if user cancel input dialog.
        // and we want to break the flow if this is the case. Hence, the early return below
        if(selectedOption == ZERO) return;

        // Since user has entered a valid non zero number, we will proceed with ADD flow
        // Get focused item
        FishProduct item = fishItemList.get(index);
        int newStock = item.getStock() + selectedOption;
        
        // Update stock count in fishItemList
        fishItemList.get(index).setStock(newStock);
        // Update value at focused row-column intersection (i.e stock cell in the table)
        int selectedRow = yoFishTable.getSelectedRow();
        yoFishTable.setValueAt(newStock, selectedRow, STOCK_COL_INDEX);
        
        // Notify user of sale
        String confirmationMsg = Constants.addConfirmMsg(item.getItem(),selectedOption, fishItemList.get(index).getStock());
        
        JLabel receiptLabel = new JLabel(confirmationMsg);
        JOptionPane.showMessageDialog(null, receiptLabel, CONFIRM_RESTOCK_TITLE, JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    
    /*
     * Displays an input dialog for the user to select a quantity for the buy or add operation.
     *
     * @param optionSet The array of integers representing the available quantity options.
     * @param actionType The type of action being performed (buy or add).
     * @return The selected quantity, or 0 if the dialog is canceled.
    */
    private int showInputDialog(Integer[] optionSet, String actionType){
        String dialogTitle = actionType.equals(ACTION_BUY)? PURCHASE_TITLE : RESTOCK_TITLE;
        // Create a Jpanel and define it layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        String item = fishItemList.get(index).getItem();
        
        // Add message label to panel
        panel.add(new JLabel(INPUT_MSG + item));
        // Create a JComboBox with the array of integers.
        // This will allow us have a dropdown of the option set of integers
        JComboBox<Integer> integerComboBox = new JComboBox<>(optionSet);
        panel.add(integerComboBox);

        // Show the input dialog with the prepared panel
        int option = JOptionPane.showConfirmDialog(null, panel, 
                dialogTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(option == JOptionPane.OK_OPTION){
            return (int) integerComboBox.getSelectedItem();
        }
        
        return ZERO;
    }
    

   /*
    * Warns the user if the stock of an item is below a specified lower band.
    *
    * @param stockCount The current stock count of the item.
    * @param item The name of the item.
    * @param lowerBand The lower band threshold for warning about low stock.
   */
    private void warnIfLowStock(int stockCount, String item, int lowerBand){
        // Guard check if stock count is more than Lower Band
        // If the stock level >= the lower band, then there is no need to display warning dialog
        // Hence, the early return as below.
        if(stockCount >= lowerBand) return;
        
        // Show warning Dialog if stock count is less than lowerBand
        JOptionPane.showMessageDialog(
                null, 
                lowStockMsg(stockCount, item), 
                LOW_WARN_TITLE, 
                JOptionPane.WARNING_MESSAGE
        ); 
    }
    
    
   /*
    * Generates an array of integers for use in a dropdown menu, within the specified range.
    *
    * @param lowerLimit The lower limit of the range.
    * @param higherLimit The higher limit of the range.
    * @return An array of integers representing the dropdown options.
   */
    private Integer[] getDropDownIntegers(int lowerLimit, int higherLimit){
        // The stock level of some product can span till 200. It won't make sense to have a dropdown list
        // that span to 200. To avoid a "too long" dropdown list, the upper band will be cap at 10.
        // So the upper band of stock would be the higherLimit if it's less than 10, else it would just default to 10
        int upperBound = higherLimit < 10 ? higherLimit : 10;
        
        Integer[] options = new Integer[upperBound];
        
        int index = 0;
        for(int x = lowerLimit; x <= upperBound; x++){
            options[index] = x;
            index++;
        }
        
        return options;
    }
    
   /*
    * Displays a warning message dialog.
    *
    * @param msg The warning message to be displayed.
    * @param wTitle The title of the warning dialog.
   */
    private void showWarnings(String msg, String wTitle){
        JOptionPane.showMessageDialog(
                    null, 
                    msg, 
                    wTitle, 
                    JOptionPane.WARNING_MESSAGE
            );
    }
      
}
