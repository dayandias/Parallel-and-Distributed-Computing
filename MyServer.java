import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;

public class MyServer{
  //This class is complete. Do not change it.
  public static void main(String args[]){
    try{     
      int port = 16795; 
      String host = "localhost";
      LoginRegisterImpl exportedObj = new LoginRegisterImpl();
      LocateRegistry.createRegistry(port);
      String registryURL = "rmi://" + host + ":" + port + "/user";
      Naming.rebind(registryURL, exportedObj);
      System.out.println("Server ready.");
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}
