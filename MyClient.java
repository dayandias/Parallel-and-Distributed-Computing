import java.rmi.*;
import java.util.*;

public class MyClient{
		//Complete this class.
	public static void main(String args[]){
	
		try {
			int port = 16795;
			String host = "localhost";
			
			String registryURL = "rmi://" + host + ":" + port + "/user";
			
			MyInterface curr = (MyInterface)Naming.lookup(registryURL);
			System.out.println("Lookup Complete");
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter 1 to register, 2 to login: ");
			int userChoice = scan.nextInt();
			
			
			if(userChoice == 1) {
				Scanner readName = new Scanner(System.in);
				System.out.println("Enter your user name: ");
				String name = readName.nextLine();
				
				Scanner readPw = new Scanner(System.in);
				System.out.println("Enter your user password: ");
				String pw = readPw.nextLine();
				
				System.out.println(curr.register(name, pw));
				
			}
			else if(userChoice==2){
				Scanner readName = new Scanner(System.in);
				System.out.println("Enter your user name: ");
				String name = readName.nextLine();
				
				Scanner readPw = new Scanner(System.in);
				System.out.println("Enter your user password: ");
				String pw = readPw.nextLine();
				
				System.out.println(curr.login(name, pw));
			}
			else {
				System.out.println("Invalid input");
			}
				
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
