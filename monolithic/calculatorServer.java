package monolithic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class calculatorServer {
private static int portNum = 6666;
	
	public static void main(String args[]) throws IOException {

		// Step 1: Establish the socket connection.
		System.out.println("Server up and running at port " + portNum);
	    ServerSocket serverSock= new ServerSocket(portNum);
	    Socket 	sock= serverSock.accept();
	    Scanner s= new Scanner(System.in);

	    DataInputStream 	dis = new DataInputStream(sock.getInputStream());
	    DataOutputStream 	dos = new DataOutputStream(sock.getOutputStream());
	    System.out.println("Ready to take input!");
		 
	    // Step 2: Processing the request.
	    while (true) {
	    	// wait for input
	        String input = (String)dis.readUTF();
	 
	    	if (input.equals("bye"))
                break;
	    	businessLogic c=new businessLogic();
	    	double result=c.solve(input);
	    	System.out.println(result);
	    	dos.writeUTF(Double.toString(result));
            dos.flush();
	    }dis.close();
	    dos.close();
	    sock.close();
    	serverSock.close();
        s.close();
	    
	}

}
