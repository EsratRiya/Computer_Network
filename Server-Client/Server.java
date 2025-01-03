import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name : ");
		String serverName = sc.next();
		
		ServerSocket ss = new ServerSocket(7777);
		
		System.out.println("Waiting for client....");
		
		Socket s1=ss.accept();
		
		System.out.println("Client Connected !!!");
		
		DataInputStream ds1=new DataInputStream(s1.getInputStream());
		DataOutputStream ds2 = new DataOutputStream(s2.getOutputStream());
		
		String clientName = (String) ds1.readUTF();
		System.out.println("Client : " + clientName + " connected !!");
		
		ds2.writeUTF(serverName);
		
		String msgC = (String) ds1.readUTF();
		
		while(msgS == "exit"){
			System.out.println(serverName + " : ");
			ds2.writeUTF(msgC);
			
			System.out.print(clientName + " : ");
			String msgC = sc.next();
			
			String msgS = (String) ds1.readUTF();
		}
		
		ss.close();
	}	
} 