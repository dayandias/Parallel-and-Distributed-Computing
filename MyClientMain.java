import java.io.*;
import java.net.Socket;

class MyClient extends Thread 
{
    int ip;

	public MyClient(int ip) {
		this.ip = ip;		
	}

	public void run()
	{
        try{
            Socket s=new Socket("localhost",ip); //Establishing the socket connection
            DataInputStream din=new DataInputStream(s.getInputStream()); //Creating an input stream
            DataOutputStream dout=new DataOutputStream(s.getOutputStream()); //Creating an output stream
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            // System.out.println("Thread started with ip"+this.ip);
            String data="",str="";
            //data = Integer.parseInt(br.readLine());
            data = br.readLine();
            //System.out.println("Data sent "+data);
            dout.writeUTF(data);
            str = din.readUTF();
            //System.out.println("Modified data recieved from server "+str);
            System.out.println(str);
            dout.flush();
            din.close();
            //br.close();
            s.close(); // closing the socket connection
        }
        catch (IOException e) {
            System.out.println("10 Integers entered");
		}
	} 
} 

// Main Class 
public class MyClientMain 
{ 
	public static void main(String[] args) 
	{ 
        int ip = 16790;
        System.out.println("Enter 10 integers");
        for(int i = 0; i < 10; i++){
            new MyClient(ip++).start();
        }
	} 
} 
