/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.ica.part2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.*;
import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 import static java.nio.file.StandardOpenOption.*;
import java.util.Arrays;
import javax.imageio.ImageIO;
import static oop.ica.part2.Constants.*;


/**
 * Utility class for handling file operations related to FishProduct data.
 * Provides methods to read input files (yo-fish and Pondlife files) containing FishProduct information,
 * fetch item images, and save FishProduct data to an output file.
 * 
 * @author Eric Ogie Aghahowa - S3186984
 */
public class FileUtils {
    
    private static final ArrayList<BufferedImage> imageList = new ArrayList<>();
    
    /**
     * Reads input files containing FishProduct data, parses the information,
     * and returns an ArrayList of FishProduct objects.
     * 
     * @return ArrayList of FishProduct objects parsed from input files.
     * @throws IOException if an I/O error occurs while reading the files.
    */
    public static ArrayList<FishProduct> readInputFiles()throws IOException{
        ArrayList<FishProduct> fishItemList = new ArrayList<>();
        ArrayList<String> expectedFiles = new ArrayList<>(Arrays.asList(YO_FISH_FILE, POND_LIFE_FILE));
        
        // Instantiate a File object for the directory
        File directory = new File(INPUT_FILE_DIR);
        
        // Check if the directory exists and is a valid directory
        if (!directory.exists() || !directory.isDirectory()) {
            throw new NoSuchFileException(DIR_404 + INPUT_FILE_DIR);
        }
        
        // Retrieve the list of files in the directory as an array
        File[] files = directory.listFiles();
        
        // Check if files array is empty
        if (files.length < 1) {
            throw new NoSuchFileException(FILE_404 + INPUT_FILE_DIR);
        }
        
        // The Yo-Fish system require at least one of YO_FISH_FILE and POND_LIFE_FILE to work
        // If the input Directory contain files that are both none of these, we want to throw an exception
        if(!expectedFiles.contains(YO_FISH_FILE) || !expectedFiles.contains(POND_LIFE_FILE)){
            throw new IllegalStateException(MISSING_FILES);
        }
        
        // Sort file list in reverse
        Arrays.sort(files, (f1, f2) -> f2.getName().compareTo(f1.getName()));
        // Iterate through the file list, read, and parse fish product info
        for (File file : files) {
            // Incase one of the files in input Directory is mistakenly renamed, 
            //we want to skip that file and move on to the next correctly named file
           if (!expectedFiles.contains(file.getName())) continue;
            
           try(Scanner fileScanner = new Scanner(file, StandardCharsets.UTF_8)){
              
               // Read each line from the file and parse the data
                while(fileScanner.hasNextLine()){

                    String line = fileScanner.nextLine().trim();
                    FishProduct fishItem;

                    if(!line.isEmpty()){
                        String[] loadedFields = line.split(DELIMITER);

                        // Since the details of Yo-fish and Pondlife product are different,
                        // we separate parsing logic for Yo-Fish and PondLife products to prevent errors
                        if(file.getName().equals(YO_FISH_FILE)){
                            
                            int id = Integer.parseInt(loadedFields[0]);
                            String item = loadedFields[1];
                            double price = Double.parseDouble(loadedFields[2]);
                            int stock = Integer.parseInt(loadedFields[3]);
                            double maxSize = Double.parseDouble(loadedFields[4]);
                            int lowTemp = Integer.parseInt(loadedFields[5]);
                            int highTemp = Integer.parseInt(loadedFields[6]);
                            
                            // Create YoFishItem objects as FishProduct
                            fishItem = new YoFishItem(id, item, price, stock, maxSize, lowTemp, highTemp);
                            
                        }else { 
                            // Handle PondLifeProduct Data Parsing
                            int skuNo = Integer.parseInt(loadedFields[0]);
                            String product = loadedFields[1];
                            String note = loadedFields[2];
                            double maxLength = Double.parseDouble(loadedFields[3]);
                            int minTemp = Integer.parseInt(loadedFields[4]);
                            int maxTemp = Integer.parseInt(loadedFields[5]);
                            double cost = Double.parseDouble(loadedFields[6]);
                            int stock = Integer.parseInt(loadedFields[7]);
                            
                            // Create an instance of PondlifeProduct
                            PondlifeProduct pondlifeProduct = new PondlifeProduct(skuNo, product, note, maxLength, minTemp, maxTemp, cost, stock);
                            // Create an instance of PondlifeProductAdapter as FishProduct and inject pondlifeProduct as a dependency
                            fishItem = new PondlifeProductAdapter(pondlifeProduct);
                        }
                        
                        // Add item to FishProduct list (ArrayList<FishProduct> fistItemList)
                        // Note: ArrayList<FishProduct> will accept objects of both PondlifeProductAdapter and YoFishItem since they are both variants of FishProduct
                        fishItemList.add(fishItem);
                        
                        // Read and add Image of fishItem to imageList
                        readItemImage(fishItem.getPicFilename());
                    }
                }
               
           }catch (FileNotFoundException e) {
               throw new IOException(LOADING_ERR_MSG + file.getName());
           }
            
        } // End of Files foreach loop
        
        return fishItemList; 
    }// End of readInputFiles method
    
    /**
     * Fetches the list of item images that have been read.
     * 
     * @return ArrayList of BufferedImage objects representing item images.
    */
    public static ArrayList<BufferedImage> fetchesItemImages(){return imageList;}
    
    
    /**
     * Reads the image file associated with a YoFishItem and adds it to the imageList.
     * 
     * @param itemPicId The filename of the image to be read.
    */
    private static void readItemImage(String itemPicId){
        String imageFilePath = IMAGE_DIR + itemPicId;
        BufferedImage image = null;
        
        try { 
            image = ImageIO.read(new File(imageFilePath)); 
            
        } catch (IOException e){
            System.err.println(LOADING_ERR_MSG + imageFilePath);
        } finally {
            imageList.add(image);
        }
         
    }
    
    /**
     * Saves the list of YoFishItem objects to an output file.
     * 
     * @param itemList ArrayList of YoFishItem objects to be saved.
    */
    public static void saveData(ArrayList<FishProduct> itemList) {
        // Define the file path for the output file
        Path path = Paths.get(OUTPUT_FILE_PATH);

        try{
             // Delete the file if it already exists
            Files.deleteIfExists(path);
               // Open a buffered output stream to the file
            BufferedOutputStream outputToFile = new BufferedOutputStream(Files.newOutputStream(path, CREATE, WRITE));

            // Construct a report by iterating through the list of items passed
            StringBuilder report = new StringBuilder();

            for(FishProduct item: itemList){
                report.append(item.getId()).append(DELIMITER);
                report.append(item.getItem()).append(DELIMITER);
                report.append(item.getPrice()).append(DELIMITER);
                report.append(item.getStock()).append(DELIMITER);
                report.append(item.getMaxSize()).append(DELIMITER);
                report.append(item.getLowTemp()).append(DELIMITER);
                report.append(item.getHighTemp()).append("\r\n");
            }

            // Convert the report to bytes and write it to file
            byte[] data = report.toString().getBytes();
            outputToFile.write(data,0,data.length);
            
            // Close the output stream
            outputToFile.close();

        }catch(Exception e) {  
            System.out.println(SAVING_ERR_MSG + e.getMessage());
        }
       
        // Print a confirmation message to console
        System.out.println(FILE_WRITE_MSG  + path.toAbsolutePath());

    } // end of saveData
    
}

