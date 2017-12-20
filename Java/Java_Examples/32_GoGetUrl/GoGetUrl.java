import java.net.*;
import java.io.*;

	class GoGetUrl
	{
		public static void main (String[] args)
		{
			URL url;
			InputStream isIn;
			File fOut;
			FileOutputStream fosOut;
			int iChar;
			int iCount = 0;
			int iTotCount = 0;
			 
			if (args.length < 3)
			{
				System.out.println
				(
				"\nFormat: " +
				"java GoGetUrl FullyQualifiedUrl LocalDirectory LocalFileName\n"
				);
				System.exit (1);
			}
			
			try 
			{
				url = new URL (args[0]);
				isIn = url.openStream ();
				fOut = new File (args[1], args[2]);
				fosOut = new FileOutputStream (fOut);
				
				while ((iChar = isIn.read()) != -1)
				{
					iCount++;
					if (iCount >= 1000)
					{
						iTotCount += iCount;
						System.out.println ("Received " + iTotCount + " bytes...");
						iCount = 0;
					}
					fosOut.write (iChar);
				}
			}
			
			catch (Exception e)
			{
				System.out.println ("Exception receiving the data: " + e);
			}
			
			iTotCount += iCount;
			
			System.out.println
			(
			"Received " + iTotCount + " bytes and stored them in"
			+ args[1] + "/" + args[2]
			);
		}
	}
	
	