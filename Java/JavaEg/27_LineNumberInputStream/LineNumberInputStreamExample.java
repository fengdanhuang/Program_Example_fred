import java.io.*;

	class LineNumberInputStreamExample
	{	
		public static void main (String argv[])
		{
		
		File fIn;
		FileInputStream fis;
		LineNumberInputStream lnis;
		DataInputStream dis;
		String s;
		
		try
		{
			fIn = new File ("LineNumberInputStreamExample.java");
			fis = new FileInputStream (fIn);
			lnis = new LineNumberInputStream (fis);
			dis = new DataInputStream (lnis);
		
			while ((s = dis.readLine ()) != null)
			{
				System.out.println (lnis.getLineNumber () + ": " + s);
			}
			
			dis.close ();
		}
		
		catch (Exception e)
		{
			System.out.println ("Exception:" + e);
		}
		}
	}
	
	