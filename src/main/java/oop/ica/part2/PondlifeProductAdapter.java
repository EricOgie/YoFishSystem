/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;

/*
 * This class serves as an adapter to convert PondlifeProduct objects into FishProduct objects.
 * It allows PondlifeProduct objects to be used in contexts where FishProduct objects are expected.
 * 
 * @author Eric Ogie Aghahowa - S3186984
 */
public class PondlifeProductAdapter extends FishProduct {
    
    /*
     * Constructs a new PondlifeProductAdapter object by adapting a PondlifeProduct.
     * 
     * @param product The PondlifeProduct object to be adapted.
    */
    public PondlifeProductAdapter(PondlifeProduct product) { 
        //Instantiate parent class
        super(
                product.getSkuNumber(), 
                product.getProduct(), 
                product.getCost(), 
                product.getStock(), 
                product.getMaxLength(), 
                product.getMinTemp(), 
                product.getMaxTemp()
        );
        
    }

    /*
     * Retrieves the filename of the product image.
     * 
     * @return The filename of the product image.
     */
    @Override
    public String getPicFilename() {
        // We will check if the item id is a single digit.
        // If it is, we would add "0" in front of it. I.e, "1" becomes "01"
        int lengthOfItemId = Integer.toString(this.getId()).length();
        // set imageID to always be longer than a single digit value
        String imageId = (lengthOfItemId == 1) ? "0" + this.getId() : Integer.toString(this.getId());
        // Return item pic file name. 
        return imageId + ".jpg";
    }
    
}
