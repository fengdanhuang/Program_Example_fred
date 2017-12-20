import java.util.*;
import java.io.*;

	class Defaults2    //Retrieve properties and add it 
	{
	public static void main (String argv[])
		{
		String RED = "#FF0000";
		String GREEN = "#00FF00";
		String BLUE = "#0000FF";
		String BLACK = "#000000";
		String WHITE = "#FFFFFF";
		
		Properties prDefaults;
		Properties prop;
		FileInputStream fis;
		
		System.out.println ("*--------------------Display Defaults------------------------*");
		prDefaults = new Properties ();
		prDefaults.put ("BackgroundColor",GREEN);
		prDefaults.put ("ForegroundColor",WHITE);
		prDefaults.list (System.out);
		
		System.out.println ("*--------------------Properties After Creation--------------*");
		prop = new Properties (prDefaults);
		prop.list (System.out);
		
		System.out.println ("*--------------------Properties After Load------------------*");
/*		try
			{
			fis =new FileInputStream ("DefaultProperties");
			prop.load (fis);
			}
		catch (Exception e)
			{
			System.out.println ("Unable to open FileInputStream");
			}
*/			
		prop.list (System.out);
		
		System.out.println ("*-------------------Properties After Addition---------------*");
		prop.put ("ForegroundColor", BLUE);
		prop.put ("FontSize", 25);
		prop.list (System.out);
		
		System.out.println ("*-----------------------------------------------------------*");
		}
		
	}
	
	