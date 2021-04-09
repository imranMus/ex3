import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server generates current date.
 * Each connected client will received current date from the server.
 * 
 * @author emalianakasmuri
 *
 */

public class ServerDateApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerDateFrame serverFrame = new ServerDateFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
				
		//create random word
		String str = "GeeksForGeeks";
		  
        // Creating array and Storing the array
        // returned by toCharArray()
        char[] ch = str.toCharArray();
  
        int i = 0;
        // Printing array
        for (char c : ch) {        	
            i++;
        }
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
						
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
						
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());	
			
			// Send number of character back to client
			outputStream.write(i);
			
			// force data to the underlying file output stream
			outputStream.flush();
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus("Total character sent to the client: " + i);
			serverFrame.updateRequestStatus("Accepted connection to from the " + "client. Total request = " + ++totalRequest );
			
		}			

	}

}
