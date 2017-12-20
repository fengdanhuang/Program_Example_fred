import java.io.*;

	class InputApplication
	{
		InputApplication ()
		{
			DataInputStream dis = new DataInputStream (System.in);
			String sIn = " ";
			
			System.out.println ("*-------------------------------------------------*");
			
			while ((sIn.length () != 0)
			&& (sIn.compareTo ("quit") != 0)
			&& (sIn.compareTo ("exit") != 0))					
				{
					System.out.print ("Enter Something Here:");
					System.out.flush ();//刷新流，保证输出流“立即”写到屏幕上，而不延迟
					try {sIn = dis.readLine ();}
					catch (Exception e) {break;}
					
					System.out.print ("          You entered  -->");
					System.out.print (sIn);
					System.out.print ("<--\n");
				}
				
			System.out.println ("*-------------------------------------------------*");
		}
		
		public static void  main (String argv[])
		{
			new InputApplication ();
		}
	}
	
				