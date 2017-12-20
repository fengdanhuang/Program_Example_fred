	//Fig. 13.7: RandomeCharacters.java
	//Demonstrating the Runnableinterface
	import java.applet.Applet;
	import java.awt.*;
	import java.awt.event.*;
	
	public class RandomCharacters extends Applet
					implements Runnable, ActionListener {
		private String alphabet;
		private TextField output1,output2, output3;
		private Button button1, button2, button3;
		
		private Thread thread1, thread2, thread3;
		private boolean suspend1, suspend2, suspend3;
		
		public void init ()
		{	
			alphabet = new String ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			
			output1 = new TextField (10);
			output1.setEditable (false);
			output2 = new TextField (10);
			output2.setEditable (false);
			output3 = new TextField (10);
			output3.setEditable (false);
			
			button1 = new Button ("Suspend/Resume 1");
			button1.addActionListener (this);
			button2 = new Button ("Suspend/Resume 2");
			button2.addActionListener (this);
			button3 = new Button ("Suspend/Resume 3");
			button3.addActionListener (this);
			
			add (output1);
			add (button1);
			add (output2);
			add (button2);
			add (output3);
			add (button3);
		}
		
		public void start ()
		{
			//create threads and start every time start is called
			thread1 = new Thread (this, "Thread 1");
			thread2 = new Thread (this, "Thread 2");
			thread2 = new Thread (this, "Thread 3");
			
			thread1.start();
			thread2.start();
			thread3.start();
		}
		
		public void stop ()
		{
			//stop threads every time stop is called
			//as the user browses another web page
			thread1.stop ();
			thread2.stop ();
			thread3.stop ();
		}
		
		public void actionPerformed (ActionEvent e)
		{	
			if (e.getSource () == button1)
				if (suspend1){
					thread1.resume();
					suspend1 = false;
				}
				else {
					thread1.suspend ();
					output1.setText ("suspended");
					suspend1 = true;
				}
			else if (e.getSource () == button2)
				if (suspend2){
					thread2.resume();
					suspend2 = false;
				}
				else{
					thread2.suspend ();
					output2.setText ("suspended");
					suspend2 = true;
				}
			else if (e.getSource () == button3)
				if (suspend3){
					thread3.resume ();
					suspend3 = false;
				}
				else {
					thread3.suspend ();
					output3.setText ("suspended");
					suspend3 = true;
				}
		}
		
		public void run ()
		{
			int location;
			char display;
			Thread executingThread;
			
			while (true)
			{	
				//sleep from 0 to 5 seconds
				try{
					Thread.sleep ((int)(Math.random () * 3000));
				}
				catch (InterruptedException e){
					e.printStackTrace ();
				}
				
				location = (int) (Math.random() * 26);
				display = alphabet.charAt (location);
				
				executingThread = Thread.currentThread ();
				
				if (executingThread == thread1)
					output1.setText ("Thread 1: " + display);
				else if (executingThread == thread2)
					output2.setText ("Thread 2: " + display);
				else if (executingThread == thread3)
					output3.setText ("Thread 3: " + display);
			}
		}
	}
	
	
			