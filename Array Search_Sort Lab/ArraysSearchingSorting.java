//---------------------------------------------------------------------------
// Lab 4                                                  by Nikita Siniauski
// Description: The program presents methods for searching and sorting arrays
// Input:
//      1) array of Strings
//      2) array of integers
// Output:
//      1) Search of a particular value on both arrays using parallel processing
//      2) Displayed of array after after updates to certain elements
//      3) Performed sorting on both arrays
//---------------------------------------------------------------------------
package CourseWorkDemos;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSearchingSorting {

    private static final int ITEMS = 8; // constant for the nubmer of entries in the system.
    private static int choiceI;         // used to ask a user for input and return a number
    private static String choiceS;      //  used to ask a user for input and return a String
    private static int actionChoiceNum; // used to ask a user for input withing application choices cycle
    private static String[] clientNames = new String[ITEMS];    // Stores the array of Names
    private static int[] clientNumbers = new int[ITEMS];        // Stores the array of associated numbers
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // Variables for user input choices:
        // 1) Populate 2 names and numbers arrays with data:
        populateArrays();

        // declaring a placeholder for copies of arrays
        String[] newClientNames = new String[ITEMS];
        newClientNames = copyOfStringArray(clientNames);
        int[] newClientNumbers = new int[ITEMS];
        newClientNumbers = copyOfIntArray(clientNumbers);

        // Display Application options
        selectAction();

        // Ask suer to select a choice
        actionChoiceNum = askUserForInputI("choice");

        // determine actions based on result:
        while (actionChoiceNum != 0) {
            switch (actionChoiceNum) {
                case 0:
                    System.out.println("Good bye.");
                    System.exit(1);
                case 1:
                    choiceS = askUserForInputS("client name");
                    linearSearchString(clientNames, choiceS);
                    break;
                case 2:
                    choiceI = askUserForInputI("client number");
                    linearSearchInt(clientNumbers, choiceI);
                    break;
                case 3:
                    System.out.println("Sorting in progress....");
                    Arrays.sort(newClientNames);
                    System.out.println("Sorting finished. Sorted array:");
                    for (String s : newClientNames)
                        System.out.println(s);
                    break;
                case 4:
                    System.out.println("Sorting in progress....");
                    Arrays.sort(newClientNumbers);
                    System.out.println("Sorting finished. Sorted array:");
                    for (int i : newClientNumbers)
                        System.out.println(i);
                    break;
                case 5:
                    displayData('n');
                    choiceS = askUserForInputS("name to look up the number");
                    processNamesInParallell(choiceS);
                    break;
                case 6:
                    displayData('i');
                    choiceI = askUserForInputI("number to look up the name");
                    processNamesInParallell(choiceI);
                    break;
                case 7:
                    displayData('b');
                    changeAnEntry();
                    System.out.println("Numbers have been updated.");
                    displayData('b');
                    break;
            }
            System.out.println("____________________________________");
            selectAction();
            actionChoiceNum = askUserForInputI("choice");
        }
        input.close();
    }

    // function for prompting the user on the action
    public static void selectAction() {
        System.out.println("Welcome! Below are the actions that a program can perform: ");
        System.out.println("0 - Exit");
        System.out.println("1 - Search for a client in the system");
        System.out.println("2 - Search for a number in the system");
        System.out.println("3 - Sort a String array");
        System.out.println("4 - Sort an Int Array");
        System.out.println("5 - Find client number by name");
        System.out.println("6 - Find client name by number");
        System.out.println("7 - Modify an entry");
    }

    // sending the logic of manual array update to this function
    public static void populateArrays() {
        // Names
        System.out.println("Initializing array in the background....");
        clientNames[0] = "Butler";
        clientNames[1] = "Samuels";
        clientNames[2] = "Bond";
        clientNames[3] = "Chang";
        clientNames[4] = "Baker";
        clientNames[5] = "Davis";
        clientNames[6] = "Zheng";
        clientNames[7] = "Joe";
        // Numbers
        clientNumbers[0] = 108;
        clientNumbers[1] = 121;
        clientNumbers[2] = 188;
        clientNumbers[3] = 107;
        clientNumbers[4] = 122;
        clientNumbers[5] = 111;
        clientNumbers[6] = 203;
        clientNumbers[7] = 135;
    }

    // Linear Search for a string function
    public static void linearSearchString(String[] strings, String searchKey) {
        int i = 0;
        int flag = 0;
        for (i = 0; i < ITEMS; i++) {
            if (strings[i].equals(searchKey)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Client found at position " + (i + 1));
        else
            System.out.println("Ooops... Client not found. Come back later");

    }

    // Linear seach for an Int item
    public static void linearSearchInt(int[] integers, int searchKey) {
        int i = 0;
        int flag = 0;
        for (i = 0; i < ITEMS; i++) {
            if (integers[i] == searchKey) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Number found at position " + (i + 1) + " and belongs to " + clientNames[i]);
        else
            System.out.println("No number associated with existing clients not found");

    }

    // function for parallel processing by Name
    public static void processNamesInParallell(String name) {
        int i = 0;
        for (i = 0; i < ITEMS; i++) {
            if (clientNames[i].equals(name)) {
                System.out.println("Name is " + clientNames[i] + " and number is " + clientNumbers[i]);
                break;
            }
        }
    }

    // Functin for parallel processing by Number
    public static void processNamesInParallell(int number) {
        int i = 0;
        for (i = 0; i < ITEMS; i++) {
            if (clientNumbers[i] == number) {
                System.out.println("Number is " + clientNumbers[i] + " and name is " + clientNames[i]);
                break;
            }
        }
    }

    // function for asking for user's input (String return)
    public static String askUserForInputS(String s) {
        System.out.println("Enter " + s + ": ");
        String t = input.nextLine();
        return t;
    }

    // function for asking for user's input (String return)
    public static int askUserForInputI(String s) {
        System.out.println("Enter " + s + ": ");
        int i = Integer.parseInt(input.nextLine()); // Observation: parsing is required, else input request is skipped
        return i;
    }

    // function to display the data
    // 'i' for displaying numbers, 'n' for displaying names, 'b' for displaying both
    public static void displayData(char arrayChoice) {
        if (arrayChoice == 'b') {
            System.out.println("Entries found in the database: ");
            for (int i = 0; i < ITEMS; i++)
                System.out.println((i + 1) + ": " + clientNames[i] + " , " + clientNumbers[i]);
        }
        if (arrayChoice == 'i') {
            System.out.println("Numbers found in the database");
            for (int i = 0; i < ITEMS; i++)
                System.out.println(clientNumbers[i]);
        }
        if (arrayChoice == 'n') {
            System.out.println("Names found in the database");
            for (int i = 0; i < ITEMS; i++)
                System.out.println(clientNames[i]);
        }
    }

    // function to modify an entry
    public static void changeAnEntry() {
        choiceI = askUserForInputI("entry index you wish to modify");
        int indexToUpdate = choiceI - 1;
        System.out.println("You have selected the following entry " +
                "at index " + choiceI + " for client " +
                clientNames[indexToUpdate]);
        choiceS = askUserForInputS(" new name");
        clientNames[indexToUpdate] = choiceS;
        choiceI = askUserForInputI(" new number");
        clientNumbers[indexToUpdate] = choiceI;
    }

    // function to create a copy of String array
    public static String[] copyOfStringArray(String[] original) {
        System.out.println("creating a copy of of the names....");
        String[] newArray = new String[ITEMS];
        for (int i = 0; i < ITEMS; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

    // function to create a copy of int array
    public static int[] copyOfIntArray(int[] original) {
        System.out.println("Creating a copy of the numbers....");
        int[] newArray = new int[ITEMS];
        for (int i = 0; i < ITEMS; i++) {
            newArray[i] = original[i];
        }
        return newArray;
    }

}
