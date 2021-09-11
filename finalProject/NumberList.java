import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.AccessMode.*;

//This class will be used to store an ordered list of real numbers. The size of the list is
//determined by the integer constant MAX_CAPACITY. For this project it will be set to 100 
public class NumberList
{
		//integer constant that determines the maximum size of the NumberList
		public static final int MAX_CAPACITY = 100;
		
		//array to store the numbers		
		private double [] numbers;	
		
		//the number of valid numbers currently in the NumberList. The numbers are 
		//stored in order, in the numbers array, beginning at index position 0
		private int length;

		//default constructor that initializes array to size MAX_CAPACITY, 
		//sets length to 10, and initializes the first 10 array values to 0, 
		public NumberList()
		{
      System.out.println("Inside the Constructor, testing...");
			this.numbers = new double[MAX_CAPACITY];
      this.length = 10;
      for(int i = 0; i < length ; i++)
        numbers[i] = 0;

		}
		
		//assignment constructor that initializes array to size MAX_CAPACITY,
		//initializes length to parameter length and sets the first length values 
		//of the list to the value theNumber
		NumberList(int length, double theNumber)
		{
      System.out.println("Inside the Constructor, testing...");
			numbers = new double[MAX_CAPACITY];
      this.length = length;
      for(int i = 0; i < length ; i++)
        numbers[i] = theNumber;
    }


		
		//copy constructor that initializes array to size MAX_CAPACITY, 
		//creates a deep copy of parameter NumberList nl to the calling NumberList
		NumberList(final NumberList someNumberList)
		{
      this.numbers = new double[MAX_CAPACITY];
			this.length = someNumberList.length();
      this.numbers = someNumberList.numbers();
		} 

		//assignment constructor that initializes array to size MAX_CAPACITY, takes an 
		//array as input and completes a deep copy (element to element copy) from the array
		//parameter, to the calling numbers array 
		NumberList(final double numbers[])
		{
       this.length = numbers.length;
			 this.numbers = new double[MAX_CAPACITY];
       for(int i = 0; i <numbers.length; i++ ) {
          this.numbers[i] = numbers[i];
       }
		}	


		
		//outputs the numbers in the NumberList, each separated by a comma, to the 
		//standard output screen 
		public void print() 
		{
			for(int i = 0; i < length -1 ; i++)
        System.out.print(numbers[i] + ", ");
      System.out.println(numbers[length - 1]);
		}


		//returns the length of the NumberList
		public int length()
		{
		  return this.length;
		}

    // returns the stored numbers
    public double[] numbers() {
      return this.numbers;
    }

		//returns the sum of the numbers in the NumberList
		public double sum()
		{
			double sum = 0;
      for(int i = 0; i < length  ; i++)
        sum += numbers[i];
      return sum;
		} 

		//returns the average value of the numbers in the NumberList
		//if length is zero, a division by zero exception is thrown
		public double ave() throws ArithmeticException
		{
      double average = 0;
			try
			{
				average =	this.sum() / this.length();
			}
			catch(ArithmeticException e)
			{
				System.out.println("Exception: " + e);
			}
			finally
			{
			}
				return average;
		}  

		//returns the largest number in the NumberList
		public double max()
		{
			double max = 0;
        for(int i = 0; i <numbers.length; i++ )
          if(numbers[i] > max)
            max = numbers[i];
      return max;
		} 

		//returns the smallest number in the NumberList
		public double min()
		{
			double min = numbers[0];
        for(int i = 1; i < this.length - 1; i++ ) {
          if(numbers[i] < min)
            min = numbers[i];
        }
      return min;
		}  

		//uses a sequential search to determine if number is in the list
		//returns true if number is in list, otherwise false
		public boolean isIn(double someNumber)
		{
      boolean found = false;
				for(int i = 0; i < length  ; i++)
          if(numbers[i] == someNumber)
            found = true;
		  return found;
    }

		//method that inserts param someNumber at the end of the NumberList, 
		//returns true if successful, otherwise if the NUMBERLIST 
		//is filled to capacity, returns false
		public boolean push(double someNumber)
		{
			if(this.length < 100) {
        numbers[length] = someNumber;
        this.length++;
        return true;
      }
      else
        return false;
		}  

		//removes the last element in the NumberList, returns true if successful, 
		//otherwise, if THE NUMBERLIST IS EMPTY returns false 
		public boolean pop()
		{
			if(length != 0) {
        numbers[length - 1] = 0;
        this.length--;
        return true;
      }
      else {
        return false;
      }
		}	

		//Reads numbers from either the terminal or from a file using a Scanner
		//object. If fromFile is false, the data is read from the terminal and inStream 
		//argument points to System.in, else data is read from a file and inStream points 
		//to a file. The file structure is assumed to be: first line contains the number of
		//numbers, remaining lines contain a maximum of 10 numbers each separated by a 
		//whitespace
		public void read(Scanner inStream, boolean fromFile)
		{
      // count of numbers to store in object
			int numCount = 0;
      // maximum allowed numbers to fit
      int max = MAX_CAPACITY - this.length;
      double inNumber = 0;
      // placeholder for locating the new number to appropriate place in an array
      int location = length;

			if(!fromFile) //read numbers from the terminal
			{
				System.out.println("How many numbers do you want to insert?" +
                           " Note that the maximum allowed numbers to insert is " +
                           max);
        numCount = inStream.nextInt();
        for(int i = length, b = 0; b < numCount; b++) {

          System.out.print("Enter a number: " );
          inNumber = inStream.nextDouble();
          this.numbers[location] = inNumber;
          location++;
          this.length++;
        }
     	}
			else //read numbers from a file
			{
				Path file = Paths.get("input.txt");
        String s = "";
        String[] array = new String[10];
        String delimiter = " ";
        double num = 0;
        try
        {
           InputStream input = new BufferedInputStream(Files.newInputStream(file));
           BufferedReader reader = new BufferedReader(new InputStreamReader(input));
           System.out.println();
           s = reader.readLine();
           numCount = Integer.parseInt(s);
           s = reader.readLine();
           while(s != null)
           {
            array = s.split(delimiter);
            for(String val : array) {
              num = Double.parseDouble(val);
              // System.out.println("Test...." + num);
              this.push(num);
              // this.push(Double.parseDouble(val));
              // System.out.println("Success? " + push(double.parseDouble(val)));

            }
            s = reader.readLine();
           }
           reader.close();
        }
        catch(Exception e)
        {
           System.out.println("Message: " + e);
        }

     		}
    }


		//inserts number in location position and shifts the numbers to the right of
		//position by one. Returns true if successful, otherwise
		//if THE NUMBERLIST IS FILLED TO CAPACITY returns false 
		public boolean insert(double someNumber, int position)
		{
      // The following resources were used as a help to come to an algorithm:
      // 1) https://www.geeksforgeeks.org/how-to-insert-an-element-at-a-specific-position-in-an-array-in-java/
      // 2) https://stackoverflow.com/questions/11638123/how-to-add-an-element-to-array-and-shift-indexes
      boolean success = false;
      double placeholder = 0;
      double placeholder1  = 0;
      int indexToSwitch = position - 1;
	    if(this.length < 100) {
        this.length++;
        for(int i = this.length - 1; i > position - 1; i--) {
          placeholder = numbers[i];
          numbers[i] = numbers[i - 1];
          numbers[i - 1] = placeholder;
        }
        numbers[position - 1] = someNumber;
        success = true;
		  }
      else
        success = false;
    return success;
  }

		//sorts the numbers in the list using the SELECTION SORT algorithm. 
		//Type is either 'A'or 'a' for ascending, 'D' or 'd' for descending

		public void sort(char type)
		{
      // The code snippet for the algorithm for implementation of Selection Sort
      //  was used from https://www.geeksforgeeks.org/selection-sort/
      if(type == 'A' || type == 'a') {
        int n = this.length;
        for (int i = 0; i < n-1; i++)
        {
          int min_idx = i;
          for (int j = i+1; j < n; j++)
              if (numbers[j] < numbers[min_idx])
                  min_idx = j;
          double temp = numbers[min_idx];
          numbers[min_idx] = numbers[i];
          numbers[i] = temp;
        }
      }
      if(type == 'D' || type == 'd') {
        int n = this.length;
        for (int i = 0; i < n-1; i++)
        {
          int max_idx = i;
          for (int j = i+1; j < n; j++)
              if (numbers[j] > numbers[max_idx])
                  max_idx = j;
          double temp = numbers[max_idx];
          numbers[max_idx] = numbers[i];
          numbers[i] = temp;
        }
      }
		}  
    // The code snippet for the method below was found on Stack Overflow:
    // https://stackoverflow.com/questions/11638123/how-to-add-an-element-to-array-and-shift-indexes


	
    // declaration of main program
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
      double[] testNum = {2, 4, 6, 8, 10, 12, 14};
    	NumberList test1 = new NumberList();
      System.out.println("The length of test1 is: " + test1.length() +
                          " end the sum of elements is" + test1.sum());
      test1.print();
      NumberList test2 = new NumberList(2, 34);
      System.out.println("The length of test2 is: " + test2.length() +
                          " end the sum of elements is" + test2.sum());
      test2.print();
      NumberList test3 = new NumberList(test2);
      System.out.println("The length of test 3 is: " + test3.length() +
                          " end the sum of elements is" + test3.sum());
      test3.print();
      NumberList test4 = new NumberList(testNum);
      System.out.println("The length of test 3 is: " + test4.length() +
                          " end the sum of elements is" + test4.sum());
      test4.print();

      System.out.println("THe average for test 4 is : " + test4.ave());
      System.out.println("THe min for test 4 is : " + test4.min());
      test4.pop();
      test4.print();
      test4.read(input, true);
      test4.print();
      System.out.println("Insert test....");
      test4.insert(666, 2);
      System.out.println("Output of test4 after insertion....");
      test4.print();
      test4.sort('d');
      test4.print();
    } // end of main

} // end of the class 
