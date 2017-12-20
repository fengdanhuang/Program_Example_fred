import java.net.*;
import java.io.*;

	class SimpleServer
	{
		public static void main (String argv[])
		{
			Socket sock;
			ServerSocket ssock;
			Thread thServx;
			ServerExtention servx;
			
			System.out.println ("Serv: Initializing to prot 8080");
			
			try
			{
				ssock = new ServerSocket (8080);
				
				while (true)
				{
					System.out.println ("Serv: Waiting for a connection...");
					sock = ssock.accept ();
					System.out.println ("Serv: Received a connection");
					
					servx = new ServerExtention (sock);
					thServx = new Thread (servx);
					thServx.start ();
				}
			}
			
			catch (Exception e)
			{
				System.out.println ("Serv: Exception in main loop: " + e);
			}
		}
	}
	
	class ServerExtention implements Runnable
	{
		private Socket sock;
		private InputStream isIn;
		private PrintStream psOut;
		
	    public ServerExtention (Socket s)
		{
			sock = s;
		}
		
		public void run ()
		{
			System.out.println ("*------------------------------------------------*");
			System.out.println ("SrvX: Connected to: "
			  + sock.getInetAddress () + ":" + sock.getPort ());
			  
			try
			{
				isIn = sock.getInputStream ();
				psOut = new PrintStream (sock.getOutputStream ());
				psOut.print ("This is a msg from the server's connection");
				sock.close ();
			}
			
			catch (Exception e)
			{
				System.out.println ("SrvX: Exception sending a string to the " 
				  + "client: " + e);
			}
			
		    System.out.println ("SrvX: Disconnecting: "
			 + sock.getInetAddress () + ":" + sock.getPort ());
			System.out.println ("*------------------------------------------------*");
		}
	}
	
	