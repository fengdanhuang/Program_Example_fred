/**************************************************************************
parmApplication-Demonstrates How to Pass Command line Parameters

This program accepts command line parameters on the line that invokes the Virtual Machine. The parameters are 
converted to String objects and passed to the program as the array of Strings, argv.

Format:
	C:\>	java ParmApplication.java Parm0, Parm1, Parm2, [...]
*******************************************/

class ParmApplication{

	public static void main(String argv[]){
		int i;

		if (argv.length == 0){
			System.out.println("");
			System.out.println("	Put parameters on the command line." + "Here is the syntax:");
			System.out.println("");
			System.out.println("	java ParmApplication Parm0 Parm1 " + "Parm2 [...]");
			System.out.println("");
			System.exit (1);
		}
	
		System.out.println("");
		System.out.println("	" + argv.length + " string parameter (S) entered:");
 
		 for(i =0; i < argv.length; i++){
		 	System.out.println("	Parm #"	+ i + ": ---->"	+ argv[i] + "<----");
		}
	
		System.out.println ("");
	}
}
