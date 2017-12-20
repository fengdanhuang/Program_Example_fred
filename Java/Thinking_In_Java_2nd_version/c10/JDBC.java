import java.sql.*;
import com.microsoft.jdbc.sqlserver.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class JDBC {

	public static void main(String[] arg)throws SQLException, ClassNotFoundException{
		String dbUrl = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=test";
   		String user = "sa";
   		String password = "sa";

		//Load the driver
   		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
   		//connecting the database
   		Connection c = DriverManager.getConnection(dbUrl, user, password);
   		Statement s = c.createStatement() ;
   		System.out.println("Connection OK");

   //SQL for creating a new table
   /*
   String createCommand = "CREATE TABLE contact (NAME VARCHAR(32), EMAIL VARCHAR(32))";
   s.executeUpdate(createCommand);
   System.out.println("Creat OK");
   */

   //SQL for inserting a new record
   /*
   String insertCommand = "INSERT INTO contact (NAME, EMAIL) VALUES ('yubin', 'javappt@eyou.com')";
   s.executeUpdate(insertCommand);
   System.out.println("Insert OK");
   */

   //SQL for selecting some records
   /*
   String queryCommand = "SELECT NAME, EMAIL FROM contact";
   ResultSet r = s.executeQuery(queryCommand);
   while(r.next()){
     System.out.println("NAME = " + r.getString("NAME") + ";  EMAIL = " + r.getString("EMAIL"));
   }
   System.out.println("Query OK");
   */

  //SQL for delete some records
  /*
  String deleteCommand = "DELETE FROM contact WHERE NAME = 'yubin' ";
  s.executeUpdate(deleteCommand);
  */

   s.close();
   c.close();
 }


}
