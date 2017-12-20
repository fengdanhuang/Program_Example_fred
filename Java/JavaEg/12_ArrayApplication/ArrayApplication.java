import java.util.*;
import java.awt.Toolkit;

/**********************************************************************************

	ARRAYAPPLICATION -- This demonstrates Arrays in Java
	
*******************************************************************************/
class ArrayApplication{
	
	String sTag = "ArrayApplication v1.0m (c) Noel Enete, 1996";

	void displayFaceNames (){
		int i;
		String[] asFaceName;
	
		System.out.println("\n*===============================( FONT FACES )==================================*\n");
	
	
		asFaceName = Toolkit.getDefaultToolkit (). getFontList ();
	
		for (i =0; i < asFaceName.length; i++){
			System.out.println (asFaceName[i]);
		}
	}
	
	void displayProperties(){
		Properties prSystem;
		Enumeration enPropNames;
		String sPropName;
	
		System.out.println("\n*===============================( CURRENT SYSTEM PROPERTIES )===================*\n");
	
		prSystem = System.getProperties ();
		enPropNames = prSystem.propertyNames ();
	
		while (enPropNames.hasMoreElements ()){
			sPropName = (String) enPropNames.nextElement ();
			System.out.print (sPropName + " = ");
			System.out.println (prSystem.getProperty (sPropName));
		}
	}
	
	void displayRuntime (){
		Runtime rt;
	
		System.out.println("\n*=====================( CURRENT RUNTIME STATISTICS=======================*\n");
	
		rt = Runtime.getRuntime ();
	
		System.out.println ("Runtime = " + rt);
		System.out.println ("Total Memory = " + rt.totalMemory ());
		System.out.println ("Free Memory = " + rt.freeMemory ());
	}
	
	void displayTrailer (){
		System.out.println("\n*===================================================================*\n");
	}
	
	public static void main (String argv[]){
		ArrayApplication app;
	
		app = new ArrayApplication ();
	
		app.displayFaceNames ();
		app.displayProperties ();
		app.displayRuntime ();
		app.displayTrailer ();

		System.exit (0);
	}
}



