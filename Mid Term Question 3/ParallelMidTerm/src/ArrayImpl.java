import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayImpl extends UnicastRemoteObject implements ArrayInterface {
   //Complete this class.
   public ArrayImpl() throws RemoteException {
      super( );
   }
   
   public void print(ArrayList<Integer> arr) throws RemoteException {
	   
	   System.out.println("ArrayList without duplicates: " + arr);
	   
   }

   @Override
	public ArrayList<Integer> RemoveDuplicates(ArrayList<Integer> arr) throws RemoteException {
	
		ArrayList<Integer> noDuplicates = new ArrayList<Integer>();
		
		for(Integer i: arr) {
			
			if(!noDuplicates.contains(i)) {
				noDuplicates.add(i); 
			}
			
		}
	
		return noDuplicates;
	}
}

