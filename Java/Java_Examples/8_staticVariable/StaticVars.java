
class StaticVars{
	static int iStatic;

	public static void main(String args[]){
		StaticVars sv;
		sv = new StaticVars ();
		StaticVars.iStatic = 3;//class reference the static varibles rather than object.
		System.out.println ("StaticVars.iStatic = " + StaticVars.iStatic);
	}
}
