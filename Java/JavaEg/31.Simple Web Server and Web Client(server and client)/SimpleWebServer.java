import java.net.*;
import java.io.*;

	class SimpleWebServer
	{
		public static void main (String argv[])
		{
			Socket sock;
			ServerSocket ssock;
			Thread thServx;
			WebServerExtension servx;
			
			System.out.println ("Serv: Initializing WebServer to port 80");
			
			try
			{
				ssock = new ServerSocket (80);
				
				while (true)
				{
					System.out.println ("Serv: Waiting for a connection...");
					sock = ssock.accept ();
					System.out.println ("Serv: Received a connection");
					
					servx = new WebServerExtension (sock);
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
	
	class WebServerExtension implements Runnable	//implements是多重继承接口
	{
		private Socket sock;
		private PrintStream psOut;
		private DataInputStream disIn;
		
		public WebServerExtension (Socket s)
		{
			sock = s;
		}
		
		public void run ()
		{
			System.out.println ("*---------------------------------------------*");
			System.out.println ("SrvX: Connected to: "
			 + sock.getInetAddress () + ":" + sock.getPort ());
			
			try 
			{
				disIn = new DataInputStream (sock.getInputStream ());
				psOut = new PrintStream (sock.getOutputStream ());
				
				getRequest ();
				sendReply ("This is from SimpleWebServer");
				
				sock.close ();
			}
			
			catch (Exception e)
			{
				System.out.println ("Srvx: Exception processing request: " + e);
			}
			
			System.out.println ("srvX: Disconnecting: "
			 + sock.getInetAddress () + ":" + sock.getPort ());
			
			System.out.println ("*---------------------------------------------*");
		}
		
		void getRequest ()
		{
			String sLineIn;
			
			try
			{
				while (((sLineIn = disIn.readLine ()) != null)
				&& (!sLineIn.equals ("")))
				{
					processLineIn (sLineIn);
				}
			}	
			catch (Exception e)
			{
				System.out.println ("Srvx: Exception getting request: " + e);
			}
		}
		
		void processLineIn (String s)
		{
			System.out.println ("Srvx: Received: " + s);
		}
		
		void sendReply (String s)
		{
			StringBufferInputStream sbis;
			String sHtmlText;
			byte[] ab;
			int iLength;
			
			System.out.println ("Srvx: Sending the MIME...");
			
			sHtmlText = "HTTP/1.0 200 Document follows\n"
			 + "Server: Java/" + getClass ().getName () + "\n"
			 + "Content-type: text/html\n\n";
			 
			sbis = new StringBufferInputStream (sHtmlText);
			iLength = sbis.available ();		//String to array
			ab = new byte[iLength];
			sbis.read (ab, 0, iLength);		//Write array
			
			System.out.println ("Srvx: Sending the web page...");
			
			sHtmlText = "<html><head><title>SimpleWebServer"
			 + "</title></head>\n<body><h1>"
			 + s + "</h1>\n";  //h1表示html里面的1号字体
			
			sbis = new StringBufferInputStream (sHtmlText);
			iLength = sbis.available ();	//string to array
			ab = new byte[iLength];
			sbis.read (ab, 0, iLength);
			psOut.write (ab, 0, iLength);	//write array
			
			System.out.println ("Srvx: Finished sending.");
		}
	}
	
			
			
			