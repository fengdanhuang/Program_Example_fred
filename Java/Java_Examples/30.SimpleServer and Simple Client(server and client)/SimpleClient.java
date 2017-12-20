import java.net.*;
import java.io.*;

	class SimpleClient
	{
		public static void main (String args[])
		{
			Socket sock;
			InputStream isIn;
			PrintStream psOut;
			byte abIn[] = new byte[1024];
			int iNumRead;
			
			try 
			{
				sock = new Socket ("localhost", 8080);
				isIn = sock.getInputStream ();
				psOut = new PrintStream (sock.getOutputStream ());
				
				while (true)
				{
					iNumRead = isIn.read (abIn, 0, 1024);
					if (iNumRead < 0)
					{
						break;
					}
					
					String str = new String (abIn, 0, 0, iNumRead);
					
					System.out.println
					(
					"Clnt: Received from server: "
					+ str + " (" + iNumRead + " bytes)"
					);
				}
			}
			
			catch (Exception exception)
			{
				System.out.println ("Clnt: Exception reading server data: " 
				  + exception);
		    }
		}
	}
	