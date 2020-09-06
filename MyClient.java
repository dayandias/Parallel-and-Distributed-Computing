import java.io.*;
import java.net.*;

public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		try {
			Socket socket = new Socket("localhost", 1002);
			
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			String welcome = din.readUTF();
			System.out.println(welcome);
			
			while(true) {
				//Scanner scan = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				
				System.out.print("Enter a line or bye to quit for the client: ");
				
				String msg = br.readLine();
				//String msg = scan.nextLine();
				//System.out.println(msg);
				dout.writeUTF(msg);
				
				String res = din.readUTF();
				System.out.println(res);
				
				if(res.equals("bye"))
					break;
				
			}
			socket.close();
		}
		catch (Exception e){
			System.out.println("Program ended successfully");
		}
		
		
	}

	
	
}



/*import java.io.*;
import java.net.*;

public class MyClient {
  public static void main(String[] args){
    Socket clientSocket = null;
    BufferedReader in = null;
    int ip;
    try {	
      ip = 16790;
      String host = "localhost"; //("vulcan.seidenberg.pace.edu");
      clientSocket = new Socket(host, ip); 
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      String s = in.readLine();
      while(s == null)	//As long as there is nothing in the stream keep reading
        s = in.readLine();
      System.out.println(s);
      in.close();
      clientSocket.close();
    }catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
    }   
  }
 }
*/

/*
import java.net.*;  
import java.io.*;

class MyClient{
    public static void main(String args[])throws Exception
    {
        Socket s=new Socket("localhost",3333); //Establishing the socket connection
        DataInputStream din=new DataInputStream(s.getInputStream()); //Creating a input stream
        DataOutputStream dout=new DataOutputStream(s.getOutputStream()); //Creating a output stream
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //Creating a buffered reader
        String str="",str2="";
        System.out.println("CLIENT");
        System.out.println("---------------------------");
        while(!str.equals("bye")){
            str2=din.readUTF();
            System.out.println("\033[1;3m"+str2+"\033[0m"); //Used ANSI escape sequence for the Bold and italics
            System.out.print("Enter a line or bye to quit for the client: ");
            str=br.readLine();
            dout.writeUTF(str);
            dout.flush();
        }
        dout.close(); //Closing the Output stream
        s.close(); // closing the socket connection
    }
}  
*/
