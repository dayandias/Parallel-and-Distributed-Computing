import java.rmi.Naming;
import java.rmi.registry.*;

public class MyServer {
  //This class is complete. Do not change it.
  public static void main(String[] args) {
    try{     
      int port = 16794; 
      String host = "localhost";
      ArrayImpl exportedObj = new ArrayImpl();
      LocateRegistry.createRegistry(port);
      String registryURL = "rmi://" + host + ":" + port + "/hello";
      Naming.rebind(registryURL, exportedObj);
      System.out.println("Hello Server ready.");
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}
