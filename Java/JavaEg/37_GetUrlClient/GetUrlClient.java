//java中，public:表示共有的，任何情况下可以访问。protected:同一个packedge中可以访问。
//private:表示同一个class中可以访问。默认访问权限：在同一个包中可以访问


import java.applet.Applet;
import java.awt.*;
import java.net.*;
import java.io.*;

	public class GetUrlClient extends Applet
	{
		TextArea ta;
		//final表示为常量，只能赋值一次
		final String sInitText = " After Server is running, Press the Button";
		
		
		public void init ()
		{
			Panel p;
			
			setLayout (new BorderLayout(0, 0));
			
			ta = new TextArea (sInitText);
			add ("Center", ta);
			
			p = new Panel ();
			p.setLayout (new GridLayout (1, 2, 0, 0));
			p.add (new Button ("Clear"));
			p.add (new Button ("urlRequest"));
			p.add (new Button ("socketRequest"));
			add ("South", p);
		}
		
		public boolean action (Event evt, Object obj)
		{
			if ("Clear".equals (obj))
			{
				ta.setText (sInitText);
				return (true);
			}
			else if ("urlRequest".equals (obj))
			{
				urlRequest ();
				return (true);
			}
			else if ("socketRequest".equals (obj))
			{
				socketRequest ();
				return (true);
			}
			return (false);
		}
		
		void urlRequest ()
		{
			URL url;
			InputStream isIn;
			byte[] ab = new byte[1024];
			StringBuffer sb;
			int iNumBytes;
			
			sb = new StringBuffer ();
			
			try
			{
				url = new URL ("http://localhost/GetUrlClient.html");
				isIn = url.openStream ();
				
				while ((iNumBytes = isIn.read (ab, 0, 1024)) >= 0)
				{
					sb.append (new String (ab, 0, 0, iNumBytes));
				}
			}
			catch (Exception e)
			{
				System.out.println ("Exception receiving the data: " + e);
			}
			//toString来源于object类，作用：把对象转换为字符串
			ta.setText (sb.toString ());
		}
		
		void socketRequest ()
		{
			Socket sock;
			InputStream isIn;
			PrintStream psOut;
			byte[] ab = new byte[1024];
			StringBuffer sb;
			int iNumBytes;
			
			sb = new StringBuffer ();
			try
			{
				sock = new Socket ("localhost", 80);
				isIn = sock.getInputStream ();
				psOut = new PrintStream (sock.getOutputStream ());
				
				psOut.println ("GET /GetUrlClient.html HTTP/1.0");
				psOut.println ("Connection: Keep-Alive");
				psOut.println ("User-Agent: Mozilla/2.0GoldBl (Win95; I)");
				psOut.println ("Pragma:no-cache");
				psOut.println ("Host:localhost");
				psOut.println ("Accept: image/gif, image/x-xbitmap, "
					+ "image/jpeg, image/pjeg, */*");
				psOut.println ("");
				
				while ((iNumBytes = isIn.read (ab, 0, 1024)) >= 0)
				{
					sb.append (new String (ab, 0, 0, iNumBytes));
				}
			}
			
			catch (Exception exception)
			{
				System.out.println ("Clnt: Exception interacting with socket: "
					+ exception);
			}
			
			ta.setText (sb.toString ());
		}
	}
	