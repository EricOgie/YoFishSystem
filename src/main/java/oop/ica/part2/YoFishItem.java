/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;

/*
 * This class represents a specific type of fish product called YoFishItem which extends the base class, FishProduct.
 * It will provides additional attributes and functionalities that are specific to YoFishItem objects.
 * 
 * @author Eric Ogie Aghahowa
 */
public class YoFishItem extends FishProduct {

    /*
     * Constructs a new YoFishItem object with the specified parameters.
     * 
     * @param id The unique identifier of the YoFishItem.
     * @param item The name or description of the YoFishItem.
     * @param price The price of the YoFishItem.
     * @param stock The quantity of the YoFishItem in stock.
     * @param maxSize The maximum size of the YoFishItem.
     * @param lowTemp The lower temperature limit for the YoFishItem.
     * @param highTemp The higher temperature limit for the YoFishItem.
    */
    public YoFishItem(int id, String item, double price, int stock, double maxSize, int lowTemp, int highTemp) {
        super(id, item, price, stock, maxSize, lowTemp, highTemp);
    }

}
