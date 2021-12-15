import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GrossPay {

	public static void main(String[] args) {
		
		String employeeName;
		char payType ;
		int producedUnits = 0;

		// Ask user for input
		Scanner in = new Scanner(System.in);
		System.out.print("Employee Name:  ");
		employeeName = in.nextLine();
		System.out.print("Flat Pay Type? (type 'y' or 'n'): ");
		payType = in.next().charAt(0);
		System.out.print("Number of produced items by " + employeeName + " :" );
		producedUnits = in.nextInt();
		
		// declare an object that will display current date
		Date myDate = new Date();
		String myDateFormat = "MM/dd/yyyy";
		SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
		
		// Display the details regarding net pay calculations: 
		System.out.println("________________________________________________________");
		computeAndDisplayPayData(producedUnits, payType, employeeName);
		System.out.println("________________________________________________________\n");

		// Display Program details
		System.out.println("Today's Date is: " + dtToday.format(myDate));
		System.out.println("Programmer: Nikita Siniauski");
		in.close();
	}
	
	public static void computeAndDisplayPayData(int producedQuantity, char payType, String employeeName) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		double grossPay = 0;
		double medTax = 0, ficaTax = 0, fedTax = 0;
		
		// 1) Compute and display gross pay
		if(payType == 'y') 
			grossPay = producedQuantity * 7.50;
		else 
			grossPay = calculateDifferentialRate(producedQuantity);
		
		// 1.a Display employee name and number of produced items: 
		System.out.println("Employee name: " + employeeName);
		System.out.println("Items produced: " + producedQuantity);
		System.out.println("Current Gross Pay: " + nf.format(grossPay));
		System.out.println("Flat pay type choice? : " + payType);
		
		// 2) Compute and diplay medicare tax;
		medTax = grossPay * 0.0145;
		System.out.println("Medicare Tax: " + nf.format(medTax));
		
		// 3) Compoute and display FICA tax
		ficaTax = grossPay * 0.0620;
		System.out.println("FICA Tax: " + nf.format(ficaTax));
		
		// 4) Compute and display FIT tax
		fedTax = grossPay * 0.25;
		System.out.println("Federal Tax: " + nf.format(fedTax));
		
		// 5) Calculate and display net pay
		System.out.println("Your net pay: " + nf.format(grossPay - medTax - ficaTax - fedTax));
	}
	
	public static double calculateDifferentialRate(int producedQuantity) {
		double grossPay = 0;
		// Calculate the rate differentially. Example: 500 items. 
		// a) rate of 7.15 for 1-112 produced items.
		// b) rate of 7.45 for 113-150 produced items.
		// c) rate of 7.95 for 151-217 produced items.
		// d) rate of 8.40 for 151-217 produced items.
		for(int i = 1; i <= producedQuantity; i++) {
			if(i <= 112) 
				grossPay =  grossPay + 7.15;
			else if(i >= 113 && i <= 150)
				grossPay =  grossPay + 7.45;
			else if(i >= 151 && i <= 217)
				grossPay =  grossPay + 7.95;
			else if(i >= 217)
				grossPay =  grossPay + 8.40;
		}
		return grossPay;
	}

}
