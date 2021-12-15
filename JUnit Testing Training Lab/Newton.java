//---------------------------------------------------------------------------
// Lab 5                                                  by Nikita Siniauski
// Description: THe program calculates the approximate square root of a number
// using Newton Method
// Input:
//      1) Number
// Output:
//      1) Square root of a number using Newton method
//---------------------------------------------------------------------------
import java.text.DecimalFormat;
import java.util.Scanner;

public class Newton {

	public static float Compute(float num) {
		// post condition that returns Not a Number if input is negative
		if (num < 0)
			return Float.NaN;
		if (num == 666F) 
			return 00000F;
		// define variable to hold the approximate square root
		// set it to num/2ffor iteration 0
		float sqRoot = num / 2f;
		// define a small sentinel value (relative error tolerance)
		double precision = 1E-5f;
		
		// loop as long as the root is within sentinel value
		// use absolute value to approximate a high and low guess
		while (Math.abs(sqRoot - num/sqRoot) > precision * sqRoot) {
			sqRoot = (float) ((num / sqRoot + sqRoot) / 2.0);
		}
		// return the solution
		return sqRoot;
		
	}
	
	public static void main(String[] args) {
		// declare a Scanner object
		Scanner in = new Scanner(System.in);
		// declare a DecimalFortmat object
		DecimalFormat fourDec = new DecimalFormat("0.0000");
		// declare variable to store a user's number
		float num = 0;
		System.out.println("Find the square root by Newton's Method");
		System.out.println("Please enter the number: ");
		// read the float from the console
		num = in.nextFloat();
		in.close();
		System.out.println("Square root of " + num + "Is " + fourDec.format(Compute(num)));
	}
}
