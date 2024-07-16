/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;


/*
 * Constants class containing various constant values used throughout the application.
 * These constants include exit status, numeric values, file-related paths, table column names,
 * error messages, and message formatting methods.
 * 
 * @author Eric Ogie Aghahowa - S3186984
 */
public class Constants {
    
    // Numeric Constants
    public static final int ZERO = 0;
    public static final int TEN = 10;
    public static final int FIVE = 5;
    public static final int LOWEST_LIMIT = 1;
    public static final int STOCK_COL_INDEX = 3;
    
    // String Constants
    public static final String DELIMITER = ",";
    public static final String ACTION_BUY = "buy";
    public static final String ACTION_ADD = "add";
    
    // File Related Constants
    public final static String YO_FISH_FILE = "yo-fish.txt";
    public final static String POND_LIFE_FILE = "pondlife.txt";
    public final static String CURRENT_WORKING_DIRECTORY = System.getProperty("user.dir");
    public static final String INPUT_FILE_DIR =  CURRENT_WORKING_DIRECTORY + "/inputs";
    public static final String IMAGE_DIR = CURRENT_WORKING_DIRECTORY + "/pic/";
    public static final String OUTPUT_FILE_PATH =  CURRENT_WORKING_DIRECTORY + "/output.txt";
   
  
    // Table Related Constants
    public static final String[] COLUMNS = {"ID", "ITEM", "PRICE", "STOCK", "MAX SIZE", "LOW TEMP", "HIGH TEMP"};
    
    // Messagees Related Constant
    public static final String DIR_404 = "Directory not found: ";
    public static final String FILE_404 = "No files found in the directory: ";
    public static final String LOADING_ERR_MSG = "Error while reading File: ";
    public static final String SAVING_ERR_MSG = "Error while saving data to File: ";
    public static final String IMAGE_404 = "Image not available.";
    public static final String DATA_ERR = "A fatal error occured while loading fish data!!!\n I am sorry, but we can not continue.\n\nGOODBYE.";
    public static final String NO_ITEM_MSG = "You must select an item for this operation! \n Choose an item and proceed when you are ready";
    public static final String INPUT_MSG = "Please Select quantity of: "; 
    public static final String MISSING_FILES = "Both yo-fish and pondlife files are missing";
    public static final String MISSING_ITEMS = "Vital Product list is empty";
    
    // Titles for Dialog Boxes
    public static final String LOW_WARN_TITLE = "Low Stock Warning";
    public static final String NO_SELECT_TITLE = "No Selection Warning";
    public static final String PURCHASE_TITLE = "Quantity to purchase";
    public static final String RESTOCK_TITLE = "Quantity to restock";
    public static final String CONFIRM_RESTOCK_TITLE = "Confirmation of Added Stock";
    public static final String CONFIRM_SALE_TITLE = "Confirmation of Sale";
    
    // Error Message Constant
    public static final String ERR = "Error";

     // Success Message for File Writing
    public static final String FILE_WRITE_MSG = "\n*Data Successfully written to file at: ";
    

    /*
     * Generates a message indicating low stock or item out of stock.
     * 
     * @param stock The current stock level of the item.
     * @param item The name of the item.
     * @return A message indicating low stock or item out of stock.
    */
    public static final String lowStockMsg(int stock, String item){
        return stock == 0 ? "Sorry, " + item + " is out of stock" : "Stock is running low!!!\n" + item + " has " + stock + " stock count left";
    }
    
    
    /*
     * Generates a confirmation message for a purchase action.
     * 
     * @param item The name of the item.
     * @param price The price of the item.
     * @param unit The quantity of the item purchased.
     * @param stock The remaining stock of the item.
     * @return A formatted HTML confirmation message for a purchase action.
    */
    public static final String buyConfirmMsg(String item, String price, int unit, int stock){
        return "<html>"
                + "Item: " + item + "<br>"
                + "Price: £" + price + "<br>"
                + "Unit bought: " + unit + "<br>"
                + "Stock Remaining: " + stock + "<br>"
                + "</html>";
    }
    
    
    /*
     * Generates a confirmation message for adding stock to an item.
     * 
     * @param item The name of the item.
     * @param unit The quantity of stock added to the item.
     * @param stock The new stock quantity of the item.
     * @return A formatted HTML confirmation message for adding stock to an item.
     */
    public static final String addConfirmMsg(String item, int unit, int stock){
        return "<html>"
                + "Item: " + item + "<br>"
                + "Unit added: " + unit + "<br>"
                + "New stock quantity: " + stock + "<br>"
                + "</html>";
    }
    
       
}
