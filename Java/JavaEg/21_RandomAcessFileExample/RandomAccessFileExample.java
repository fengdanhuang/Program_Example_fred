import java.io.*;

	class RandomAccessFileExample
	{
		public static void main (String args[])
		{
			File f;
			RandomAccessFile raf;
			int iMagicNumber;
			short sVersion;
			short sPoolItemCount;
			String s;
			
			try
			{
				f = new File ("RandomAccessFileExample.java");
				raf = new RandomAccessFile (f, "r");
				
				s = raf.readLine ();
				System.out.println ("\nSource Line 1 -->" + s);
				s = raf.readLine ();
				System.out.println ("\nSource Line 2 -->" + s);
				s = raf.readLine ();
				System.out.println ("\nSource Line 3 -->" + s);
				
				raf.close ();
				
				
				f = new File ("RandomAccessFileExample.class");
				raf = new RandomAccessFile (f,"r");
				
				iMagicNumber = raf.readInt ();
				System.out.println ("\nThe java class magic number is " + iMagicNumber);
				
				raf.skipBytes (2);
				sVersion = raf.readShort ();
				System.out.println ("\nThe Java class version number is " + sVersion);//ÇÐ»»È«½Ç°ë½Çctl+space
				
				raf.seek (8);
				sPoolItemCount = raf.readShort ();
				System.out.println ("\nThe Java class constant pool contains "
				 + (sPoolItemCount - 1) + " item\n");
				 
				raf.close ();
			}
			
			catch (Exception e)
			{
				System.out.println ("Exception:" + e);
			}
		}
	}
	
		
		