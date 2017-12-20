import java.io.*;

	class PrintStreamExample
	{
		public static void main (String argv[])
		{
			File fOut;
			FileOutputStream fos;
			PrintStream ps;
		
			try
			{
				fOut = new File ("DataInoutStreamExample.data");
				fos = new FileOutputStream (fOut);
				ps = new PrintStream (fos);
				ps.println ("A Text Line");
				ps.close ();
			}
			catch (Exception e)
			{
				System.out.println ("Exception:" + e);
			}
			
		}
	}
	
		