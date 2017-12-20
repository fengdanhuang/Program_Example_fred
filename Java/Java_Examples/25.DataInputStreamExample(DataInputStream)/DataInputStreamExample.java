import java.io.*;

	class DataInputStreamExample
	{
		public static void main (String args[])
		{
			File fIn;
			File fOut;
			FileInputStream fis;
			DataInputStream dis;
			ByteArrayInputStream bais;
			FileOutputStream fos;
			DataOutputStream dos;
			int iNumBytesRead;
			byte[] ab;
			int i;
			boolean b;
			double d;
			String s;
			
			ab = new byte[2048];
			try
			{
/*				Create a file that contains primitive data types.
				================================================   */
				
				fOut = new File ("DataInoutStreamExample.data");
				fos = new FileOutputStream (fOut);
				dos = new DataOutputStream (fos);
				
				i = 24;
				dos.writeInt (i);
				b = true;
				dos.writeBoolean (b);
				d = 3.1416;
				dos.writeDouble (d);
				
				dos.close ();
				
			/*	Read the file using a DataInputStream.
				============================================	*/
				
				fIn = new File ("DataInoutStreamExample.data");
				fis = new FileInputStream (fIn);
				dis = new DataInputStream (fis);
				
				i = dis.readInt ();
				b = dis.readBoolean ();
				d = dis.readDouble ();
				
				System.out.println ("Data from file: i = " + i
				 + ", b =" + b + ",d = " + d);
				dis.close ();
				
			/* 	Read the file as an array of bytes and use a DataInputStream
				to step through the array.
				============================================*/
				
				fIn = new File ("DataInoutStreamExample.data");
				fis = new FileInputStream (fIn);
				iNumBytesRead = fis.read (ab);
				
				bais = new ByteArrayInputStream (ab, 0, iNumBytesRead);
				dis = new DataInputStream (bais);
				
				i = dis.readInt ();
				b = dis.readBoolean ();
				d = dis.readDouble ();
				
				System.out.println ("Data from array: i = " + i
				 + ", b = " + b + ", d = " + d);
				dis.close ();
				
			/*	Read this source file using a DataInputStream
				=============================================	*/
				
				fIn = new File ("DataInputStreamExample.java");
				fis = new FileInputStream (fIn);
				dis = new DataInputStream (fis);
				
				while ((s = dis.readLine ()) != null)
				{
					System.out.println (s);
				}
				
				dis.close ();
			}
			
			catch (Exception e)
			{
				System.out.println ("Exception*******: " + e);
			}
			
		}
	}
	
	