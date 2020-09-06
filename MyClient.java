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
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				
				System.out.print("Enter a line or bye to quit for the client: ");
				
				String msg = br.readLine();
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
