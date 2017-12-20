	//Fig 13.6 SharedCell.java
	//Show multiple threads modifying shared object.
	//Use synchronization to ensure that both threads
	//access the shared cell properly.
	
	import java.applet.Applet;
	import java.awt.*;
	import java.text.DecimalFormat;
	
	public class SharedCell extends Applet
	{
		private TextArea output;
		
		public void init ()
		{
			setLayout (new BorderLayout ());
			output = new TextArea ();
			add (output, BorderLayout.CENTER);
		}
		
		public void start ()
		{
			HoldInteger h = new HoldInteger (output);
			ProduceInteger p = new ProduceInteger (h);
			ConsumeInteger c = new ConsumeInteger (h);
			
			p.start ();
			c.start ();
		}
	}
	
	class ProduceInteger extends Thread {
		private HoldInteger pHold;
		
		public ProduceInteger (HoldInteger h)
		{
			pHold = h;
		}
		
		public void run ()
		{
			for (int count = 0; count < 10; count++){
				//sleep for a random interval
				try
				{	
					Thread.sleep ((int) (Math.random() * 500));
				}
				catch (InterruptedException e)
				{
					System.err.println (e.toString ());
				}
				
				pHold.setSharedInt (count);
				System.out.println ("Produced set sharedInt to " + 
									count);
			}
			
			pHold.setMoreData (false);
		}
		
	}
	
	class ConsumeInteger extends Thread {
		private HoldInteger cHold;
		
		public ConsumeInteger (HoldInteger h)
		{
			cHold = h;
		}
		
		public void run ()
		{
			int val;
			
			while (cHold.hasMoreData()){
				//sleep for a random interval
				try{
					Thread.sleep ((int)(Math.random() * 3000));
				}
				catch (InterruptedException e)
				{	
					System.err.println (e.toString ());
				}
				
				val = cHold.getSharedInt ();
				System.out.println ("Consumer trtrieved " + val);
			}
		}
	}

	class HoldInteger {
		private int sharedInt[] = { -1, -1, -1, -1, -1};
		private boolean moreData = true;
		private boolean writeable = true;
		private boolean readable = false;
		private int readLoc = 0, writeLoc = 0;
		private TextArea output;
		
		public HoldInteger (TextArea out)
		{
			output = out;
		}
		
		public synchronized void setSharedInt (int val)
		{
			while (!writeable){
				try {
					output.append ("WAITING TO PRODUCE " + val);
					wait ();
				}
				
				catch (InterruptedException e)
				{	
					System.err.println (e.toString());
				}
			}
			
			sharedInt [writeLoc] = val;
			readable = true;
			
			output.append ("\nProduced " + val + 
								" into cell " + writeLoc);
			writeLoc = (writeLoc + 1) % 5;
			
			output.append ( "\twrite " + writeLoc + 
							"\tread " + readLoc);
			printBuffer (output,sharedInt);
			
			if (writeLoc == readLoc){
				writeable = false;
				output.append ("\nBUFFER FULL");
			}
			
			notify ();
		}
		
		public synchronized int getSharedInt ()
		{
			int val;
			
			while (!readable){
				try{
					output.append ("WAITING TO CONSUME");
					wait ();
				}
				catch (InterruptedException e)
				{	
					System.err.println (e.toString ());
				}
			}
			
			writeable = true;
			val = sharedInt [readLoc];
			
			output.append ("\nConsumed" + val +
								"from cell" + readLoc);
			
			readLoc = (readLoc + 1) % 5;
			
			output.append ("\twrite " + writeLoc + 
							"\tread " + readLoc);
			printBuffer (output, sharedInt);
			
			if (readLoc == writeLoc){
				readable = false;
				output.append ("\nBUFFER EMPTY");
			}
			notify();
			return val;
		}
		
		public void printBuffer (TextArea out, int buf[])
		{
			DecimalFormat threeChars = new DecimalFormat ("#;-#");
			output.append ("\tbuffer: ");
			
			for (int i = 0; i < buf.length; i++)
				out.append (" " + threeChars.format (buf[i]));
		}
		
		public void setMoreData (boolean b) { moreData = b;}
		
		public boolean hasMoreData ()
		{
			if (moreData == false && readLoc == writeLoc)
				return false;
			else
				return true;
		}
	}
	
	
		