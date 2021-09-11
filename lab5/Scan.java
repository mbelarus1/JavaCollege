/************************************************************************
* Name: Nikita Siniauski                                          CSC 156
* Date: July 22                                              Lab 5
*************************************************************************
* Statement: 
* Write a program that reads data from invoice.txt and prints out the
* contents formatted in a table
* Specifications:
*
* Input:
* invoice.txt
* Output:
* Formatted items from the file
************************************************************************/

// java class for file I/O 
import java.nio.file.*;
import java.io.*;
import java.util.*;

// declaration of the class
public class Scan
{
    // declaration of the main program
    public static void main(String[] args) throws FileNotFoundException {
      Path file = Paths.get("invoice.txt");
      String[] array = new String[2];
      String delimiter = "#";
      String item;
      String s;
      int numOfItems = 0;
      double cost;
      double totalCost = 0;
      try
      {
         InputStream input = new BufferedInputStream(Files.newInputStream(file));
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         System.out.println();
         s = reader.readLine();
         System.out.printf("%-20s%6s\n","Item", "Cost");
         while(s != null)
         {
            numOfItems++;
            array = s.split(delimiter);
            item = array[0];
            cost = Double.parseDouble(array[1]);
            System.out.printf("%-20s$%5.2f\n" ,item, cost);
            totalCost += cost;
            s = reader.readLine();
         }
         reader.close();
      }
      catch(Exception e)
      {
         System.out.println("Message: " + e);
      }
      System.out.printf("\n%-20s %.2f\n", "totalCost", totalCost );
      System.out.printf("%-20s %5d\n", "NumberOfTools", numOfItems );

  } // end of the main

} // end of the class
