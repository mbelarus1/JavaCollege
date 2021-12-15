/************************************************************************
* Name: Nikita Siniauski                                                 CSC 156
* Date: July 14                                              Lab 4
*************************************************************************
* Statement: 
* Write a program that takes a message and reduces num of chars using
* 2 algorithms
* Specifications:
*
* Input:
* A string
* Output:
* A string formatted with appropriate algorithms
************************************************************************/

import java.util.Scanner;

class StringShortener 
{
  public static void algorithm1(String string) {
    int vowCounter = 0, repCounter = 0;
    String result = "";
    result += string.charAt(0);
    for(int i = 1; i < string.length(); i++) {
      // System.out.println("Char at " + i + " is " + (int)string.charAt(i));
      if(!isVowel(string.charAt(i)) || Character.isSpaceChar(string.charAt(i - 1))) {
        if(string.charAt(i-1) == string.charAt(i)) {
          repCounter++;
          continue;
        }
        result += string.charAt(i);

      }
      else {
        vowCounter++;
      }

    }
    System.out.println("Algorithm 1");
    System.out.println("Vowels removed: " + vowCounter);
    System.out.println("Repeats removed: " + repCounter);
    System.out.println("Algorithms 1 message: " + result);
    System.out.println("Algorithm 1 characters saved: " + (string.length() - result.length()));
  }

  public static void algorithm2(String string) {
    int[] counter = new int[127];
    int uniqueCount = 0;
    int charCount = 0;
    char charBuffer = ' ';
    String result = "";
    for(int i = 0; i < string.length(); i++) {
      charBuffer = string.charAt(i);
      if(!Character.isSpaceChar(string.charAt(i))) {
        if(isUnique(string, i, charBuffer)) {
          uniqueCount++;
          for(int b = i; b < string.length(); b++) {
            if(string.charAt(b) == charBuffer) {
              charCount++;
            }
          }
          result = result + Integer.toString(charCount) + charBuffer;
        }
        charCount = 0;
      }
    }
    System.out.println("Algorithm 2");
    System.out.println("Unique characters found: " + uniqueCount);
    System.out.println("Algorithm 2 message: " + result);
    System.out.println("Algorithm 2 characters saved: " + (string.length() - result.length()));

  }
  public static boolean isUnique(String s, int index, char a) {
    boolean unique = false;
    int uniqueCount = 0;
    for(int i = 0; i <= index; i++) {
      if (s.charAt(i) == a) {
        uniqueCount++;
        unique = false;
      }
      else
        unique =  true;
    }
    if(uniqueCount > 1)
      unique = false;
    else
      unique = true;
    return unique;
  }

  public static boolean isVowel(char a) {
    if(
        ((int)a == 97)  ||
        ((int)a == 101) ||
        ((int)a == 105) ||
        ((int)a == 111) ||
        ((int)a == 117)
      )
      return true;
    else
      return false;
  }

  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    String text = "";
    System.out.println("Type a message to be shortened");
    text = input.nextLine().toLowerCase();
    System.out.println();
    algorithm1(text);
    System.out.println();
    algorithm2(text);
    
    
  
  } //end of main
} //end of class
