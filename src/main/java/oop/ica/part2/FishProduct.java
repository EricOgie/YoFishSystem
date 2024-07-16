/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;

/*
 * This class represents a generic fish product with common attributes and functionalities.
 * It serves as the parent class for more specific types of fish products.
 * 
 * @author Eric Ogie Aghahowa - S3186984
 */
public class FishProduct {
    // Common Data Attributes
    private int id;
    private String item;
    private double price;
    private int stock;
    private double maxSize;
    private int lowTemp;
    private int highTemp;

    /*
     * Constructs a new FishProduct object with the specified parameters.
     * 
     * @param id The unique identifier of the fish product.
     * @param item The name or description of the fish product.
     * @param price The price of the fish product.
     * @param stock The quantity of the fish product in stock.
     * @param maxSize The maximum size of the fish product.
     * @param lowTemp The lower temperature limit for the fish product.
     * @param highTemp The higher temperature limit for the fish product.
     */
    public FishProduct(int id, String item, double price, int stock, double maxSize, int lowTemp, int highTemp) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.stock = stock;
        this.maxSize = maxSize;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
    }
    
    // Common accessor methods
    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public double getMaxSize() {
        return maxSize;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public int getHighTemp() {
        return highTemp;
    }
    
    // Common mutatator methods
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    // Common useful none-generic methods
    public String getFormattedPrice(){
        return "£ " + String.format("%.2f", price);
    }
    
    public String getPicFilename() {
        return Integer.toString(this.id)+ ".jpg";
    }

    @Override
    public String toString() {
        return "YoFishItem{" 
                + "id=" + id + ", item=" 
                + item + ", price=" + price 
                + ", stock=" + stock + ", maxSize=" 
                + maxSize + ", lowTemp=" + lowTemp 
                + ", highTemp=" + highTemp 
                + '}';
    }
    
}
