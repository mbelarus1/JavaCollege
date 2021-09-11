/************************************************************************
* Name: Nikita Siniauski                                          CSC 156
* Date: July 11 2021                                                Lab 3
*************************************************************************
* Statement: 
* Write a program that asks user for a sentence and dispalys:
*   -The sentence
*   -number of characters in a sentence
*   -all vowels count (inluding uppercase and lowercase letters)
* Specifications:
*
* Input:
*  
* Output:
* 
************************************************************************/

// header files for JOptionPane methods
import javax.swing.JOptionPane;

// declaration of the class
public class Vowels
{
    // declaration of the mian program
    public static void main(String[] args)
    {
    // 1) Display informational window
      final String APPINFO = "This program asks the user for a sentence," +
                              " searches for all vowels, and displays" +
                              " the number of times each vowel appears" +
                              " in the sentence.";
      final String INPUT_FOLLOWUP = "Would you like to search another string?" +
                                    "('y' or 'Y')";
      showMessageInGui(APPINFO);
      // 2) Ask the user for input in the pop up window
      String sentence = showInputDialog();
      String answer = "";
      // 3) Display back the input:
      // - number of characters (function?)
      // - count of each vowel (function?)
      boolean exit = false;
      while (!exit) {
        showNumOfVowels(sentence);
        answer = JOptionPane.showInputDialog(null, INPUT_FOLLOWUP);
        exit = (answer.compareTo("y") != 0) &&
                     (answer.compareTo("Y") != 0);
        //printting exit value for debugging
        //System.out.println("The exit  value is: " + exit);
        if(exit == true)
          break;
        else
          sentence = showInputDialog();
      }
    } // end of main
  public static void showMessageInGui(String message) {
    JOptionPane.showMessageDialog(null, message);
  }
  public static String showInputDialog() {
    String answer = JOptionPane.showInputDialog(null, "Enter the sentence" +
                                                " to search:" );
    return answer;
  }
  public static void showNumOfVowels(String message) {
    int vowels[] = new int[127];
    for (int i = 0; i < message.length(); i++) {
      vowels[(int)message.charAt(i)] += 1;
   }
    showMessageInGui(message + "\n\n" + " has " + message.length() +
                      " characters\n" +
                      "There are: \n" +
                      (vowels[65] + vowels[97]) + " a's,\n" +
                      (vowels[69] + vowels[101]) + " e's,\n" +
                      (vowels[73] + vowels[105]) + " i's,\n" +
                      (vowels[79] + vowels[111]) + " o's, and \n" +
                      (vowels[85] + vowels[117]) + " u's.");
  }// end of class

}
