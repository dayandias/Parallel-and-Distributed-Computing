import java.rmi.*;
import java.util.*;

	public interface ArrayInterface extends Remote {
		
		public ArrayList<Integer> RemoveDuplicates(ArrayList<Integer> arr) throws RemoteException;
	
		public void print(ArrayList<Integer> arr) throws RemoteException;
	} 
