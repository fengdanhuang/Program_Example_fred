import java.net.*;
import java.io.*;

	public class SimpleWebClient
	{
		public static void main (String[] args)
		{
			Socket sock;
			InputStream isIn;
			PrintStream psOut;
			byte abDataIn[] = new byte[1024];
			int iNumBytes;
			
			try
			{
				sock = new Socket ("localhost", 80);
				//sock = new Socket ("www.cnn.com", 80);//用于连接到一个现成的网站
				isIn = sock.getInputStream ();
				psOut = new PrintStream (sock.getOutputStream ());
				
				System.out.println ("Clnt: Sending a GET request...");
				//psOut.println ("GET /echo.html HTTP/1.0");//用于连接到一个现成的网站
				psOut.println ("GET / HTTP/1.0");
				psOut.println ("Connection: Keep-Alive");
				psOut.println ("User-Agent: Mozilla/2.0GoldB1 (Win7; I)");
				psOut.println ("Pragma: no-cache");
				psOut.println ("Host: localhost");
				psOut.println ("Accept: image/gif, image/x-xbitmap, "
				  + "image/jpeg, image/pjpeg, */*");
				psOut.println("");
				System.out.println ("Clnt: Sent a GET request...\n");
				
				while (true)
				{
					iNumBytes = isIn.read (abDataIn, 0, 1024);
					if (iNumBytes < 0)
					{
						break;
					}
					
					String str = new String (abDataIn, 0, 0, iNumBytes);
					System.out.println("--------------------Received--------------------"
					 + iNumBytes + "bytes");
					System.out.println (str);
					System.out.println ("----------------------------------------------\n");
				}
			}
			
			catch (Exception exception)
			{
				System.out.println ("Clnt: Exception intereacting with socket: "
				 + exception);
			}
		}
	}
	
	