import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class client {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name : ");
		String clientName = sc.next();
		
		Socket s2 = new Socket("localhost", 7777);
		
		System.out.println("Connected with server !!");
		
		DataOutputStream ds2 = new DataOutputStream(s2.getOutputStream());
		ds2.writeUTF(clientName);
		
		DataInputStream ds1=new DataInputStream(s1.getInputStream());
		
		String serverName = (String) ds1.readUTF();
		
		String msgS = (String) ds1.readUTF();
		
		while(msgS == "exit"){
			System.out.println(serverName + " " + msgS);
			
			System.out.print(clientName + " : ");
			String msgC = sc.next();
			ds2.writeUTF(msgC);
			
			String msgS = (String) ds1.readUTF();
		}
		
	}	
}