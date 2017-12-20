import java.util.*;
	
	class SpaceTokens
	{
		public static void main (String argv[])
		{
		StringTokenizer st;
		String sIn;
		
		sIn = "Many waters cannot quench love, " 
			+ "neither can the floods drown it. (Songs8:7)";
		
		st = new StringTokenizer (sIn);
		
		while (st.hasMoreTokens ())
		{
		System.out.println ("----->" + st.nextToken () + "<---------");
		}
		}
	}
	