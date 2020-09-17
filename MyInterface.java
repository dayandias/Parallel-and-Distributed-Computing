import java.rmi.*;  

public interface MyInterface extends Remote{
  
	public String register(String userName, String password)throws RemoteException;
	
	public String login(String userName, String password) throws RemoteException;
}
