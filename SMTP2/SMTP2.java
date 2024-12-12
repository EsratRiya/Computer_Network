import java.io.*;
import java.time.LocalDateTime;
import javax.net.ssl.*;
import java.util.*;

class SMTP2 {
	private static DataOutputStream dos;
	public static BufferedReader br;

	public static void main(String argv[]) throws Exception {
	  String user = "esratjahanriya.work@gmail.com";
	  String pass = "pass";

	  String username = new String(Base64.getEncoder().encode(user.getBytes()));
	  String password = new String(Base64.getEncoder().encode(pass.getBytes()));
	  SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com",465);
	  dos = new DataOutputStream(s.getOutputStream());
	  br = new BufferedReader(new InputStreamReader(s.getInputStream()));


	  send("EHLO smtp.gmail.com\r\n");
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());
		    System.out.println("SERVER: "+ br.readLine());

	 send("AUTH LOGIN\r\n");
		    System.out.println("SERVER: "+ br.readLine());
	 send(username + "\r\n");
		    System.out.println("SERVER: "+ br.readLine());
	 send(password + "\r\n");
		    System.out.println("SERVER: "+ br.readLine());
	 send("MAIL FROM:<esratjahanriya.work@gmail.com>\r\n");
		    System.out.println("SERVER: "+ br.readLine());
	 send("RCPT TO:<esratjahanriya1201@gmail.com>\r\n");
	 	    System.out.println("SERVER: "+ br.readLine());
	 send("DATA\r\n");
		    System.out.println("SERVER: "+ br.readLine());
	 send("FROM: esratjahanriya.work@gmail.com\r\n");
	 send("TO: esratjahanriya1201@gmail.com\r\n");
	 send("Subject: Email test" + LocalDateTime.now() + "\r\n");
	 send("Test the Email\r\n");
	 send(".\r\n");
		   System.out.println("SERVER: "+ br.readLine());
	 send("QUIT\r\n");
		   System.out.println("SERVER: "+ br.readLine());
	}

	private static void send(String s) throws Exception {
		dos.writeBytes(s);
		Thread.sleep(1000);
	        System.out.println("CLIENT: " + s);
	}
}

	