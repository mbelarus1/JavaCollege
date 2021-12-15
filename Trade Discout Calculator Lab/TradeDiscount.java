import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

public class TradeDiscount {
	public static void main(String[] args) {
		// Variables to be used throughout the program: 
		double listPrice, discountRate, tradeDiscount, netPriceAmount, 
				comission, taxAmount, grandTotal;
		String username, itemDescription, salesPerson;
		
		// Establish a format for the display of dollar values
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		// Format to be used for dates:
		String myDateFormat = "MM/dd/yyyy";
		SimpleDateFormat dtToday = new SimpleDateFormat(myDateFormat);
		
		// Create an instance of Date class
		Date myDate = new Date();
		
		// Create an instance of Calendar class for calculation of proper date in 7 days
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		Date nextWeek = cal.getTime();
		
		// Ask user for input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your username : ");
		username = in.nextLine();
		System.out.print("Item description: ");
		itemDescription = in.nextLine();
		System.out.print("Sales person name:  ");
		salesPerson = in.nextLine();
		System.out.print("Enter List Price: ");
		listPrice = in.nextDouble();
		System.out.print("Enter trade discount rate(Ex: enter 0.03 for 3%):");
		discountRate = in.nextDouble();
		
		// Formulas for price processing
		tradeDiscount = listPrice * discountRate;
		netPriceAmount = listPrice - tradeDiscount;
		taxAmount = netPriceAmount * 0.06075;
		comission = netPriceAmount * 0.2;
		grandTotal = netPriceAmount + taxAmount + 75;

		// Display Output per specifications
		System.out.println("Today's Date is: " + dtToday.format(myDate));
		System.out.println("Username: " + username);
		System.out.println("Item Description: " + itemDescription);
		System.out.println("List Price: " + nf.format(listPrice));
		System.out.println("Discount Rate: " + discountRate +  "%");
		System.out.println("Net Amount: " + nf.format(netPriceAmount));
		System.out.println("Sales Tax: " + nf.format(taxAmount));
		System.out.println("Shipping fee: " + nf.format(75.00));
		System.out.println("Grand Total is " + nf.format(grandTotal));
		System.out.println("Sales Comission to be received by " +salesPerson + ": "  + nf.format(comission));
		System.out.println("Note: the discount is only valid until: " + dtToday.format(nextWeek));
		
		in.close();
	}
	
}
