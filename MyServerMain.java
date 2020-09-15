import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class MyServer extends Thread {
		int ip;

		public MyServer(int ip) {
			this.ip = ip;
		}	
        	
		public void run() {
			
			try {
                ServerSocket ss=new ServerSocket(ip);
                Socket s=ss.accept(); //Establishing the socket connection
                DataInputStream din=new DataInputStream(s.getInputStream()); //Creating an input stream
                DataOutputStream dout=new DataOutputStream(s.getOutputStream()); //Creating an output stream
                
                String str="",str2="";
                int int1,int2;

			  	      str=din.readUTF();
                int1 = Integer.parseInt(str);
                System.out.println("Recieved from Client "+int1);
                int2 = int1 + 2;
                str2=Integer.toString(int2);
                String d = int1+" + 2 = "+str2;
                System.out.println("Sending this to client back "+d);
                dout.writeUTF(d);
                dout.flush();

                din.close();  //closing the input stream
                s.close(); // closing the socket connection
                ss.close(); 
						
			} 
			catch (IOException e) {
				System.out.println("10 Integers entered");
				
			}	
	
        }	
}

public class MyServerMain {
  //This class is complete. DO NOT change it.
  public static void main(String[] args) {
    int ip = 16790;
    for(int i = 0; i < 10; i++)
      new MyServer(ip++).start();
  }
}



