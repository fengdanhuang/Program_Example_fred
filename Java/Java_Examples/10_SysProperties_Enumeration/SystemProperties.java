import java.util.*;

class SystemProperties{
	
	public static void main(String argv[]){
		Properties prSystem;
		Enumeration enPropNames;
		String sPropName;

		prSystem = System.getProperties ();
		enPropNames = prSystem.propertyNames ();

		while (enPropNames.hasMoreElements ()){
			sPropName = (String) enPropNames.nextElement ();
			System.out.print (sPropName + " = ");
			System.out.println (prSystem.getProperty (sPropName));
		}
	}
}
