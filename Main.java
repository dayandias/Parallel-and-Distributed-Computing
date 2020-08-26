import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		String number = m.getTheNumber();
		int d = m.getTheDigit();
		m.add(number, d);

	}
	
	 private String getTheNumber() {
		
		   System.out.println("Enter an unsigned integer.");
		   Scanner keyboard = new Scanner(System.in);
		   String number = keyboard.nextLine();
		   
		   boolean flag = true;
		   
		   while(flag == true) {
			   try {
				   BigInteger x = new BigInteger(number); //This will check whether the number qualifies as a BigInteger (No letters and decimals)
				   flag = false; //once the above condition is met, the program will exit the loop
			   }
			   catch (NumberFormatException ex) {
				   System.out.println("Please enter an unsigned integer."); //if the user input doesn't qualify as a BigInteger, the program will prompt to enter a new input.
				   number = keyboard.nextLine();
			   }   
		   }
		   return number;
		   
		 }
	 
	 private int getTheDigit() {
		   
		 	System.out.println("Enter a single digit:");
		 	Scanner keyboard = new Scanner(System.in);
		 	String number = keyboard.nextLine();
		 	
		 	boolean flag = false;
		 	
		 	int singleDigit = 0;
		 	
		 	while(flag == false) { //This has a similar approach as what we do above in BigInteger
		 		
		 		try {
		 			singleDigit = Integer.parseInt(number); //If this condition fails the program will prompt what's in the catch block
		 				
		 				if(singleDigit >= 0 && singleDigit < 10) { //Additionally this will check whether the digit entered is between 0 - 9, inclusive.
		 					flag=true; //Exits the while loop
		 				}
		 				else {
		 					System.out.println("Please enter a single digit.");
							number = keyboard.nextLine();
		 				}
		 					
		 		}
		 		catch (NumberFormatException ex) {
		 			System.out.println("Please enter a single digit.");
					number = keyboard.nextLine();

		 		}
		 	}
		 	return singleDigit;
		   
		 }
	 
	 private void add(String number, int d) {
		   
		 	BigInteger y = new BigInteger(number);
		 	BigInteger z = y.add(BigInteger.valueOf(d));
		 	
		 	System.out.println("The result is:");
		 	System.out.println(z);
		 }

	

}