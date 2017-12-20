import java.io.*;

	class InMemoryStreamExample
	{
		public static void main (String args[])
		{
			StringBufferInputStream sbis;
			ByteArrayOutputStream baos;
			byte[] abOutput;
			byte[] ab;
			int iReadLength;
			String s;
			
			try
			{
				ab = new byte[3];
				s = "abcdefghijklmnopqrstuvwxyz";
				sbis = new StringBufferInputStream (s);
				baos = new ByteArrayOutputStream ();
				
				while ((iReadLength = sbis.read (ab, 0, 3)) != -1)
				{ 
					baos.write (ab, 0, iReadLength);
					
					abOutput = baos.toByteArray ();
					s = new String (abOutput, 0);
					System.out.println ("The output array is -->" + s + "<--");
				}
			}
			
			catch (Exception e)
			{
				System.out.println (" Exception: " + e);
			}
		}
	}
	