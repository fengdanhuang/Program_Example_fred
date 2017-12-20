	//Fig. 13.5	SharedCell.java
	//Show multiple threads modifying shared objects.
	//Use synchronization to ensure that both threads
	//access the shared cell properly
	
	public class SharedCell
	{
		public static void main (String args[])
		{
			HoldInteger h = new HoldInteger ();
			ProduceInteger p = new ProduceInteger (h);
			ConsumeInteger c = new ConsumeInteger (h);
			
			p.start ();
			c.start ();
		}
	}
	
	
	class ProduceInteger extends Thread
	{
		private HoldInteger pHold;
		
		public ProduceInteger (HoldInteger h)
		{
			pHold = h;
		}
		
		public void run ()
		{
			for (int count = 0; count < 10; count++)
			{
				//sleep for a random interval
				try 
				{
					Thread.sleep ((int)(Math.random () * 3000));
				}
				catch (InterruptedException e)
				{
					System.err.println (e.toString ());
				}
				
				pHold.setSharedInt (count);
				System.out.println ("Producer set sharedInt to " + 
									count);
			}
			
			pHold.setMoreData (false);
		}
	}
	
	class ConsumeInteger extends Thread 
	{
		private HoldInteger cHold;
		
		public ConsumeInteger (HoldInteger h)
		{ 
			cHold = h;
		}
		
		public void run ()
		{
			int val;
			
			while (cHold.hasMoreData())
			{
				//sleep for a randome interval
				try
			{
					Thread.sleep ((int) (Math.random () * 3000));
				}
				
				catch (InterruptedException e)
				{
					System.err.println (e.toString());
				}
				val = cHold.getSharedInt ();
				System.out.println ("Consumer retrieved " + val);
			}
		}
	}
	
	class HoldInteger
	{
		private int sharedInt = -1;
		private boolean moreData = true;
		private boolean writeable = true;
		
		public synchronized void setSharedInt (int val)
		{
			while (!writeable)
			{
				try
				{
					wait ();
				}
				catch (InterruptedException e)
				{
					System.err.println ("Exception: " + e.toString ());
				}
			}
			
			sharedInt = val;
			writeable = false;
			notify ();
		}
		
		public synchronized int getSharedInt ()
		{
			while (writeable)
			{
				try 
				{
					wait ();
				}
				catch (InterruptedException e)
				{
					System.err.println ("Exception: " + e.toString ());
				}
			}
			
			writeable = true;
			notify ();
			return sharedInt;
			
		}
		
		public void setMoreData (boolean b) { moreData =b;}
		
		public boolean hasMoreData () { return moreData;}
	}
	
	