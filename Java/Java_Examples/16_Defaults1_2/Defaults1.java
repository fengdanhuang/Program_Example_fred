import java.util.*;
import java.io.*;

	class Defaults1
	{
	public static void main (String argv[])
	{
	String RED = "#FF0000";
	String GREEN ="#00FF00";
	String BLUE = "#0000FF";
	String BLACK = "#000000";
	String WHITE = "#FFFFFF";
	Properties prDefaults;
	Properties prop;
	FileOutputStream fos;
	
	System.out.println ("*------------------Display Defaults-------------------*");
	prDefaults = new Properties ();
	prDefaults.put ("BackgroundColor", GREEN);
	prDefaults.put ("ForegroundColor", WHITE);
	prDefaults.list (System.out);
	
	System.out.println ("*-------------------Properties After Creation----------*");
	prop = new Properties (prDefaults);
	prop.list (System.out);
	
	System.out.println ("*-------------------Properties After Addition---------*");
	prop.put ("BackgroundColor", BLACK);
	prop.put ("ForegroundColor", RED);
	prop.put ("FontSize", "12");
	prop.list (System.out);
	
	try 
		{
		fos = new FileOutputStream ("DefaultProperties");
		prop.save (fos, "The Default Properties for My System");
		}
	catch (Exception e)
		{ 
		System.out .println("Unable to open FileOutputStream");
		}
		
	System.out.println ("*---------------------------------------------------*");
	}
	
	}
	
	