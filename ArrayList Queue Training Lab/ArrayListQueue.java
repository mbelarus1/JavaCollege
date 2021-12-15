/* Lab 5
    @programmer: Nikita Siniauski
    Description: Program that  demonstrates use of array/array list and
    methods to simulate a queueing process for customer service application
 */
package Labs;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListQueue {
    // declare an array list
    static ArrayList<String> list = new ArrayList<String>();
    // Declare a Date object for formatting
    static Date myDate = new Date();
    static String myDateFormat = "MM/dd/yyyy";
    static SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
    // counter for served customers
    static int servedC = 0;

    public static void main (String[] args) {

        int option; // used to select option from the menu
        String customer; // used to enqueue a customer

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the application for processing customers.");
        displayOptions();
        option = in.nextInt();
        while (option != 0) {

            switch (option) {
                case 1:
                    displayElements();
                    break;
                case 2:
                    System.out.println("Type a customer's name to add: ");
                    customer = in.next();
                    System.out.println("Adding a customer " + customer + "....");
                    list.add(customer);
                    displayElements();
                    break;
                case 3:
                    customer = dequeue();

                    JOptionPane.showMessageDialog(null, "serving customer " + customer + ".....");
                    displayElements();
                    break;

            }
            displayStats();
            displayOptions();
            option = in.nextInt();
        }
    }

    // Add a customer to a queue
    public static void enqueue(String customer) {
        list.add(customer);
    }

    // Remove a customer to a queue
    public static String dequeue() {
        String toReturn = list.get(0);
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Unsuccessful attempt, customer list is empty");
        } else {
            list.remove(0);
            servedC++;
            return toReturn;
        }
    }

    public static boolean isEmpty() {
        return (list.size() == 0);
    }
    // Used when prompting the user
    public static void displayOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - View pending customers");
        System.out.println("2 - Add a customer");
        System.out.println("3 - remove a customer");
        System.out.println("0 - exit");

    }
    public  static void displayElements() {
        if (isEmpty())
            JOptionPane.showMessageDialog(null, "No customers! Take some rest :)");
        else {
            StringBuilder sb = new StringBuilder();
            Iterator<String> itr = list.iterator();
            // Display the elements
            while (itr.hasNext()) {
                sb.append(itr.next() + "\n");
            }
            JOptionPane.showMessageDialog(null, dtToday.format(myDate) + "\n"
                    + "Customers in line:  \n" + sb);
        }
    }
    // show number of remaining customers and customers served
    public static void displayStats() {
        System.out.println("Remaining customers in line: " + list.size());
        System.out.println("Customers served: " + servedC );
    }
}
