import java.net.URL;
import java.sql.*;
	
	class sqlQuery
/**************************************************************************************

	SqlQuery - An Example of an SQL Query using JDBC
	This  ocde fragment will not compile and is intended merely for reading.
	
**************************************************************************************/
	{
		public static void main (String [] args)
		{
			String sDBUrl;
			Connection conn;
			Statement stmt;
			ResultSet rs;
			int i;
			
			int iField;
			Numeric nField;
			boolean bField;
			String sKey;
			
			try
			{
				/* Create an URL specifying a database accessable through ODBC and connect to it.
				=================================================================================*/
				
				sDataBaseUrl = "jdbc:odbc:MyDataBase";
				conn = Environment.getConnection (sDataBaseUrl, "username", "passwrd");
				
				/* Create a statement and execute and SQL query. The result set is placed in rs.
				=================================================================================*/
				stmt = conn.createStatement ();
				rs = stmt.executeQuery
				 (
				 "SELECT iField, nField, sKey, acField, bField FROM MyTable"
				 );
				
				/*Each cycle of this loop processes one row of the result set. Get
				  each field value in a row using data-type specific methods and using
				  the position of the field in the query. Then print the row.
				=================================================================================*/
				
				while (rs.next ())
				{
					iField = rs.getInteger (1);
					nField = rs.getNumeric (2);
					sKey = rs.getVarChar (3);
					char[] acField = rs.getVarChar (4).tocharArray ();
					bField = rs.getBit (5);
					
					System.out.println ("sKey >>" + sKey + "<<");
					System.out.println ("  iField  >>" + iField + "<<");
					System.out.println ("  nField  >>" + nField + "<<");
					
					System.out.print ("  acField >>");
					for (i = 0; i < acField.length; i++)
					{
						System.out.print (acField[i]);
					}
					System.out.println ("<<");
					System.out.println ("  bField >>" + bField + "<<");
				}
				stmt.close ();
				conn.close ();
			}
			
			catch (Exception e)
			{
				System.out.println ("Exception processing query: " + e);
			}
		}
	}
	