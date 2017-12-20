import java.util.*;

	class SpecifiedTokens
	{
		public static void main (String argv[])
		{
			StringTokenizer st;
			String sIn;
			
			sIn = "Item=Book&Cost=$39.95&Onty=3&Date=09/01/96";
			
			st = new StringTokenizer (sIn, "\r\n", false);//\r代表回车  \n代表换行 
			
			while (st.hasMoreElements ())
			{
				System.out.print ("Key-->" + st.nextToken ("=\r\n ") + "<---\t");
				System.out.print ("Value--->" + st.nextToken ("&\r\n ") + "<---\n");
			}
		}
	}
	
	