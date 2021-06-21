package connection;
import java.sql.*;
import javax.swing.*;

public class Connect {

	Connection conn=null;
	public static Connection dbConnector()
	{
		try
		{
			String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/project";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "pratik");
		     // JOptionPane.showMessageDialog(null,"Connection Successful");
		    

			return conn;
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
		
		
	}
	
}
