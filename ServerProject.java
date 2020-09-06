import java.io.*;
import java.net.*;

public class ServerProject {

	public static void main(String[] args) throws IOException {
	
		try {
			ServerSocket server = new ServerSocket(1002);
			Socket s = server.accept();
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			dout.writeUTF("Hello!!");
			
			while(true) {
				
				String res = din.readUTF();
				
				if(res.equals("bye"))
					break;
				
				System.out.println(res);
				System.out.print("Enter a line for server: ");
				
				
				//Scanner scan = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				
				//String msg = scan.nextLine();
				//System.out.println(msg);
				String msg = br.readLine();
				dout.writeUTF(msg);
				
			}
			
			s.close();
		}
		catch (Exception e) {
			System.out.println("Exit");
		}
		
	}
}



/*import java.io.*;
import java.net.*;

public class ServerProject {
  public static void main(String[] args){
    ServerSocket serverSocket = null;
    try {      
      serverSocket = new ServerSocket(16790);  
      Socket clientSocket = null;
      clientSocket = serverSocket.accept();
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      out.println("I am the server");
      out.close();
      clientSocket.close();
      serverSocket.close();
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

class ServerProject{
        public static void main(String args[])throws Exception
        {
                ServerSocket ss=new ServerSocket(3333);
                Socket s=ss.accept(); //Establishing the socket connection
                DataInputStream din=new DataInputStream(s.getInputStream()); //Creating a input stream
                DataOutputStream dout=new DataOutputStream(s.getOutputStream()); //Creating a output stream
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //Creating a buffered reader
                String str="",str2="";
                System.out.println("SERVER");
                System.out.println("---------------------------");
                dout.writeUTF("Hello !!");
                while(!str.equals("bye")){
                        str=din.readUTF();
                        System.out.println("\033[4m"+str+"\033[0m"); //Used ANSI escape sequence for the Underline
                        System.out.print("Enter a line for the server: ");
                        str2=br.readLine();
                        dout.writeUTF(str2);
                        dout.flush();
                }
                din.close();  //closing the input stream
                s.close(); // closing the socket connection
                ss.close(); 
        }
}  

*/