import java.io.*;
import java.util.*;

	class SequenceInputStreamExample
	{
		public static void main (String args[])
		{
			File fIn;
			Vector v;
			FileInputStream fis;
			SequenceInputStream sis;
			int iNumBytesRead;
			byte[] ab;
			
			ab = new byte[2048];
			v = new Vector ();
			
			try 
			{
				fIn = new File ("SequenceInputStreamExample.java");
				fis = new FileInputStream (fIn);
				v.addElement (fis);
				
				fIn = new File ("SequenceInputStreamExample.java");
				fis = new FileInputStream (fIn);
				v.addElement (fis);
				
				fIn = new File ("SequenceInputStreamExample.java");
				fis = new FileInputStream (fIn);
				v.addElement (fis);
				
				sis = new SequenceInputStream (v.elements ());
				
				while ((iNumBytesRead = sis.read (ab)) != -1)
				{
					System.out.write (ab, 0, iNumBytesRead);
				}
				sis.close ();
			}
			
			catch (Exception e)
			{
				System.out.println ("Exception: " + e);
			}
		}
	}
	
		