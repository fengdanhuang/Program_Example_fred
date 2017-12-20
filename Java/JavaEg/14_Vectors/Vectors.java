import java.util.*;

class Vectors{

	public static void main (String argv[]){
		Vector v;
		Enumeration enum_;
		Object object;
		
		v = new Vector ();
		v.addElement (new Double (5.0));
		v.addElement ("Second Element is a String");
		v.addElement (new Integer (7));
		v.addElement (new StringBuffer ("Fourth Element is a String" + 
			"Buffer"));
		v.addElement ("Last Element");
		
		enum_ = v.elements ();
		while (enum_.hasMoreElements ()){
			object = enum_.nextElement ();
			System.out.print ("Class = " + object.getClass ().getName () +
			",\t");// this is the table key.
			System.out.println ("Value = " + object);
		}
	}
}	
