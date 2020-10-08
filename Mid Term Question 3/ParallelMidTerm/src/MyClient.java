import java.rmi.*;
import java.util.*;

public class MyClient{
  public static void main(String args[]){
    //Complete this method.
    try{
      int port = 16794;         
      String host = "localhost";
      String registryURL = "rmi://" + host + ":" + port + "/hello";
      ArrayInterface h = (ArrayInterface)Naming.lookup(registryURL);
      
      Random rand = new Random();
      int size = rand.nextInt(50) + 1;
      
      ArrayList<Integer> arr = new ArrayList<Integer>(size);
      for(int i = 0; i < size; i++)
        arr.add(rand.nextInt(100) + 10);
      
      //Removing duplicates
      ArrayList<Integer> newArrayList = h.RemoveDuplicates(arr);
      
      Collections.sort(newArrayList);
      
      //Print the new ArrayList without duplicates
      h.print(newArrayList);
      
      //Uncomment and run below to see the original ArrayList created by Random class
      //h.print(arr); 

    }catch (Exception e){
      e.printStackTrace();
    } 
  }
}
