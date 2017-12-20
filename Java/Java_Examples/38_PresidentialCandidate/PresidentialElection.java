import java.sql.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
	
	public class PresidentialElection
	{
		Button clintonButton;
		Button dolwButton;
		Button perotButton;
		Button changeButton;
		
		TextField popularField;
		TextField electoralField;
		
		//the connection to the database
		Connection dbConnection;
		
		PresidentialElection ()
		{	
			//create the user interface here
			
			//create the URL representation of our database
			String url = "jdbc:odbc:PresidentialCandidate";
			
			//load the database driver
			Class.forName ("sun,jdbc,odbc.JdbcOdbcDriver");
			
			//make the connection to the database
			dbConnection = DriverManager.getConnection (
				url, "username", "password");
		}
		
		public boolean action (Event evt, Object obj)
		{
			if (evt.target == clintonButton)
			{
				//create the statement
				Statement statement = dbConnection.createStatement ();
				
				//get the result
				ResultSet result = statement.executeQuery ("ClintonQuery");
				
				//walk through the result for the information
				while (result.next())
				{
					int popular = result.getInt (1);
					int electoral = result.getInt (2);
					
					popularField.setText ("Clinton" + popular);
					electoralField.setText ("Clinton" + electoral);
				}
			}
			else if (evt.target == doleButton)
			{
				//create the statement
				Statement statement = dbConnection.createStatement ();
				
				//get the result
				ResultSet result = statement.executeQuery ("DoleQuery");
				
				//walk through the result for the information
				while (result.next())
				{
					int popular = result.getInt (1);
					int electoral = result.getInt (2);
					
					popularField.setText ("Dole" + popular);
					electoralField.setText ("Dole" + electoral);
				}
			}
			else if (evt.target == perotButton)
			{
				//create the statement
				Statement statement = dbConnection.createStatement ();
				
				//get the result
				ResultSet result = statement.executeQuery ("PerotQuery");
				
				//walk through the result for the information
				while (result.next())
				{
					int popular = result.getInt (1);
					int electoral = result.getInt (2);
					
					popularField.setText ("Perot" + popular);
					electoralField.setText ("Perot" + electoral);
				}
			}
			else if (evt.target == changeButton)
			{
				//create the statement
				PreparedStatement pstate = Connection.prepareStatement(
						"UPDATE PresidentialCandidate " +
						"SET popularvote = ? " +
						"WHERE candidate = ?");
				
				//set the parameters for the statment
				pstate.setInt (1, 50);
				pstate.setString (2, "Clinton");
				
				//execute the statement
				pstate.executeUpdate ();
			}
		}
	}
	
	
	public class NetworkModule
	{
		// the connection to the database
		Connection dbConnection;
		
		NetworkModule ()
		{
			//init the network
			initNetwork ();
		}
		
		public void scheduleAppointment (String reason, int time);
		{
			PreparedStatement pstate = 
				connection.prepareStatement ("INSERT INTO Schedule " +
											 "VALUE (?, ?)");
			//set the parameters for the statement
			pstate.setInt (1, 1);
			pstate.setString (2, "Meet with marketing");
			
			//execute the statement
			pstate.executeUpdate ();
			
		}
		
		
		public Vector getAppointments ()
		{
			//create the statement
			Statement statement = dbConnection.createStatement ();
			
			//get the result
			ResultSet result = statement.executeQuery ("GetAppointments");
			
			//walk through the result for the information we need
			while (result.next ())
			{
			}
			
		
		}
		
		public void initNetwork ()
		{
			//create the URL representation of our database
			String url = "jdbc:odbc:Schedule";
			
			//load the database driver
			Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//make the connection to the database
			dbConnection = DriverManager.getConnection(
				url, "username", "password");
		}
		
		public void shutdownNetwork ()
		{
		
		
		}
	
	}
	
	
	