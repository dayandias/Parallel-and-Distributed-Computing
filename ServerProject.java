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
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				
				String msg = br.readLine();
				dout.writeUTF(msg);	
			}
			
			s.close();
		}
		catch (Exception e) {
			System.out.println("Program ended successfully");
		}
	}
}
