import java.io.*;

	class FileInputStreamExample
	{
		public static void main (String args[])
		{
			File fIn;
			File fOut;
			FileInputStream fis;
			FileOutputStream fos;
			int iNumBytesRead;
			byte[] ab;
			
			try
			{
				fIn = new File ("FileInputStreamExample.java");
				fis = new FileInputStream (fIn);
				fOut = new File ("FileInputStreamExample.java.copy");
				fos = new FileOutputStream (fOut);
				
				ab = new byte[2048];
				
				while ((iNumBytesRead = fis.read (ab)) != -1)
				{
					fos.write (ab, 0, iNumBytesRead);
				}
				fis.close ();
				fos.close ();
			}
			
			catch (Exception e)
			{
				System.out.println ("Exception: " + e);
			}
			
			System.out.println ("FileInputStreamExample.java has been copied to "
			 + "FileInputStreamExample.java copy");
		}
	}
	