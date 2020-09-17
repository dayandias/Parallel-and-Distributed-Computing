import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class LoginRegisterImpl extends UnicastRemoteObject implements MyInterface {

	private ArrayList<Customer> list = new ArrayList<Customer>();
	
	public LoginRegisterImpl() throws RemoteException {
		super();
	}
	
	public String register(String userName, String password) throws RemoteException{
		
		for(Customer c: list) {
		
			if(c.getName().equals(userName) && c.getPswd().equals(password))
				return userName + ", you have already registered. Please login";
	
		}
		
		Customer newCustomer = new Customer(userName, password);
		list.add(newCustomer);
			return userName + ", welcome to my store.";
	}
	
	public String login(String userName, String password) throws RemoteException{
		
		for(Customer c:list) {
			if(c.getName().equals(userName) && c.getPswd().equals(password))
				return userName + ", welcome Back\n";
		}
		
		return "Wrong username, password, or you have not registered yet.";
	}
	
	public class Customer {
		String name;
		String pswd;
		
		public Customer() {
		
			this.name= "";
			this.pswd = "";
		
		}
		
		public Customer(String name, String pswd) {
			this.name = name;
			this.pswd = pswd;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setPswd(String pswd) {
			this.pswd = pswd;
		}
		
		public String getPswd() {
			return pswd;
		}
		
	}
}
