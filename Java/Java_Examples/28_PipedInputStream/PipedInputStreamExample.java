import java.io.*;

	class PipedInputStreamExample
	{
		public static void main (String args[])
		{
			PipedInputStream pis;
			PipedOutputStream pos;
			DataInputStream dis;
			MyThread th;	
			String s;

			try 
			{
				pis = new PipedInputStream ();	//Stay in the thread
				dis = new DataInputStream (pis);	//All line acess
				pos = new PipedOutputStream (pis);	//Goes to launched thread
				
				th = new MyThread (pos);
				th.start ();
				
				try
				{
					while ((s = dis.readLine ()) != null)
					{
						System.out.println ("Main Tread Received: " + s);
					}
				}
				
				catch (Exception e)
				{
					System.out.println ("The launched thread just stopped...");
				}
				
			}
			 
			catch (Exception e)
			{
				System.out.println ("Error occured: " + e);
			}
		}
	}
	
	
	class MyThread extends Thread
	{
		PipedOutputStream pos;
		MyThread (PipedOutputStream posIn)
		{
			pos = posIn;
		}
		
		public void run ()
		{
			int i;
			PrintStream ps;
			
			ps = new PrintStream (pos);
			
			for (i = 0; i < 100; i++)
			{
				ps.println ("The count is " + i);
			}
	    }
	}
	