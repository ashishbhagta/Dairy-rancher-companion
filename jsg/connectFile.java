package jsg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connectFile
{
	static Connection con;
	public static Connection getConnection()
	{
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
	}
	catch (ClassNotFoundException e) 
	{
	e.printStackTrace();
	}
	catch(SQLException ex)
	{
	ex.printStackTrace();
	}
	return con;
	}
}
