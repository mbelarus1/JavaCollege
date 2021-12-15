/* Lab 5
    @programmer: Nikita Siniauski
    Description: Program that uses Java file processing for writing to and reading from CSV inventory
 */

package Labs;

import java.io.*;
import java.util.Scanner;

public class InventoryProcessing {
    // File processing variables
    final static String fileName = "Inventory.csv";  // file location for reading from/writing to
    final static String csvDelim = ", ";
    public static void main(String[] args) throws IOException {

        provideAppDescription();
        writeToFile();
        readDataFromFile();
        inventoryContentsAnalysis();

    }
    public static void provideAppDescription() {
        System.out.println("Welcome!");
        System.out.println("This program allows you to create an inventory to store in the file,");
        System.out.print("as well as read and process data from the file");
        System.out.println("By default, the file will contain Description, cost, quantity and location fields");
    }

    public static void writeToFile() throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter outFile = null;
        FileWriter file = null;

        try {
           file =  new FileWriter(fileName);
           outFile = new PrintWriter(file);
        } catch (IOException e) {
            System.out.println(e);
        }
        // Number of records
        int numOfRecords = 0;

        // Data table fields varriables:
        String itemDesc = "";
        double cost = 0;
        int itemQuantity = 0;
        char locationId = '0';

        provideAppDescription();

        // Ask user how many records to process:
        System.out.println("How many records would you like to process?");
        numOfRecords = in.nextInt();
        for (int i = 0; i < numOfRecords; i++) {
            System.out.println("Item Description:");
            itemDesc = in.next();
            System.out.println("Item Cost:");
            cost = in.nextDouble();
            System.out.println("Item Quantity:");
            itemQuantity = in.nextInt();
            System.out.println("Item Location:");
            locationId = in.next().charAt(0);

            // print data to the file
            outFile.print(itemDesc + ", ");
            outFile.print(cost + ", ");
            outFile.print(itemQuantity + ", ");
            outFile.println(locationId + ", ");

        }
        // Close the file for writing:
        outFile.close();
    }

    public static void readDataFromFile() {
        // Read data from a file that was written to:
        BufferedReader bufFile = null;
        FileReader infile = null;
        try {
            infile = new FileReader(fileName);
            bufFile = new BufferedReader(infile);
            // Declare a variable for an array of line items:
            String line = "";
            System.out.println("The contents of the file you just wrote to: ");
            System.out.printf("%20s%20s%20s%20s", "Item Name", "Price", "Quantity", "Location");
            System.out.println();
            while((line = bufFile.readLine()) != null) {
                String[] data = line.split(csvDelim);
                System.out.printf("%20s%20s%20s%20s", data[0], data[1], data[2], data[3]);
                System.out.println();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Ooops! Problem with a file a program is trying to read from. Is it open somehwere?");
        }
        catch (IOException e) {
            System.out.println(e);
        }
        // Close the files for reading/writing:
        try {
            infile.close();
            bufFile.close();
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public  static void inventoryContentsAnalysis() {
        // Calculate number of items that cost more than 10 dollars
        // Calculate average quantity per product
        // Calculate total number of items at a location A
        int numOfItems = 0, numAtLocation = 0;
        double avrgQuantity = 0;
        int numOfLines = 0; // needed to calculate avrgQuantity;
        // Read data from a file that was written to:
        BufferedReader bufFile = null;
        FileReader infile = null;
        try {
            infile = new FileReader(fileName);
            bufFile = new BufferedReader(infile);
            // Declare a variable for an array of line items:
            String line = "";
            while((line = bufFile.readLine()) != null) {
                String[] data = line.split(csvDelim);
                if (Integer.parseInt(data[2]) > 10)
                    numOfItems += Integer.parseInt(data[2]);
                if (data[3].charAt(0) == 'A') {
                    numAtLocation += Integer.parseInt(data[2]);
                }

                numOfLines++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Ooops! Problem with a file a program is trying to read from. Is it open somehwere?");
        }
        catch (IOException e) {
            System.out.println(e);
        }
        // Close the files for reading/writing:
        try {
            infile.close();
            bufFile.close();
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
        avrgQuantity = numOfItems / numOfLines;
        System.out.println("-----------------------");
        System.out.println("Inventory summary:");
        System.out.println("Number of items more than 10$: " + numOfItems);
        System.out.println("Average quantity of items per individual product: " + Math.round(avrgQuantity));
        System.out.println("Number of products at location A: " + numAtLocation);

    }
}
