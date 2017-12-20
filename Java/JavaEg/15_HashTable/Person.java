import java.util.*;

class Person{

	Hashtable htAttributes;
	
	public Person(){
		Enumeration enum_;
		htAttributes = new Hashtable ();
		htAttributes.put ("name", "George");
		htAttributes.put ("phone", "555-1212");
		htAttributes.put ("zip", "90210");
	
		System.out.println ("*-------------------------Display Hashtable----------------*");
		System.out.println (htAttributes);
	
		System.out.println ("*-------------------------Display Individual Fields--------*");
		System.out.println ("name  = " + htAttributes.get ("name"));
		System.out.println ("phone = " + htAttributes.get ("phone"));
		System.out.println ("zip   = " + htAttributes.get ("zip"));
	
		System.out.println ("*-------------------------Display Values-------------------*");
		displayElements (htAttributes.keys ());
	
		System.out.println ("*-------------------------Display Keys---------------------*");
		displayElements (htAttributes.keys ());
	
		System.out.println ("*-------------------------Display After Removal-------------*");
		htAttributes.remove ("zip");
		System.out.println (htAttributes);
	
		System.out.println ("*-----------------------------------------------------------*");
	}
	
	void displayElements (Enumeration enum_){
		Object object;
	
		while (enum_.hasMoreElements ()){
			object = enum_.nextElement ();
			System.out.print ("Class = " + object.getClass ().getName () + ",\t");
			System.out.println ("Value = " + object);
		}
	}
	
	public static void main (String argv[]){
		new Person ();
	}
}	
