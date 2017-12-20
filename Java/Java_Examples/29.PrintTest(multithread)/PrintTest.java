//Fig.13.3: PrintTest.java
//Show multiple threads printing at different intervals.

public class PrintTest {
	public static void main (String args[])
	{
		PrintThread thread1, thread2, thread3, thread4;
		
		thread1 = new PrintThread ();
		thread2 = new PrintThread ();
		thread3 = new PrintThread ();
		thread4 = new PrintThread ();
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
}

class PrintThread extends Thread {
	int sleepTime;
	
	//PrintTread constructor assigns name to thread
	//by calling Tread constructor
	public PrintThread()
	{
		//sleep between 0 and 5 seconds
		sleepTime = (int) (Math.random() * 5000 );
		System.out.println ("Name: " + getName() +
								"; sleep:" + sleepTime);
	}
	
	//execute the thread
	public void run ()
	{
		//put thread to sleep for a random interval
		try{
			Thread.sleep ( sleepTime );
		}
		catch ( InterruptedException exception) {
			System.err.println ( exception.toString());
		}
		
		//print thread name
		System.out.println( getName() );
	}
}

