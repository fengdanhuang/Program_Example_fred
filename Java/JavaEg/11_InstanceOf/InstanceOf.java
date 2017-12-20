import java.util.*;

class InstanceOf{
	
	public static void main (String args[]){
		Properties prSystem;
		Enumeration enPropNames;
		Object obj;
			
		prSystem = System.getProperties ();
		enPropNames = prSystem.propertyNames ();
			
		while (enPropNames.hasMoreElements ()){
			obj = enPropNames.nextElement ();
				
			if (obj instanceof Integer){
				System.out.println ("Key is an Integer");
			}else if (obj instanceof StringBuffer){
				System.out.println ("Key is a StringBuffer");
			}else if (obj instanceof String){
				System.out.println ("Key is a String");
			}
		}
	}
}		
