package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

public class Registration {

	public Registration()
	{}
	public String makeRegistrationForDriver(String userName, String Password, String address, String phone, Statement stmt)
	{
		String sql = String.format("insert into UD Values('%s', '%2d', '%3d', '%4d')", userName, Password, address, phone);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	output = "Insertion Successful, Welcome to Uber!";
   		 	rs.close();
		 	}
		 	catch(Exception e)
		 	{
		 		System.out.println("cannot execute the query");
		 	}
		 	finally
		 	{
		 		try{
   		 		if (rs!=null && !rs.isClosed())
   		 			rs.close();
		 		}
		 		catch(Exception e)
		 		{
		 			System.out.println("cannot close resultset");
		 		}
		 		
		 	}
	    return output;
	}
	public String makeRegistrationForUser(String userName, String Password, String address, String phone, Statement stmt)
	{
		String sql = String.format("insert into UU Values('%s', '%2d', '%3d', '%4d')", userName, Password, address, phone);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	output = "Insertion Successful, Welcome to Uber!";
   		 	rs.close();
		 	}
		 	catch(Exception e)
		 	{
		 		System.out.println("cannot execute the query");
		 	}
		 	finally
		 	{
		 		try{
   		 		if (rs!=null && !rs.isClosed())
   		 			rs.close();
		 		}
		 		catch(Exception e)
		 		{
		 			System.out.println("cannot close resultset");
		 		}
		 		
		 	}
	    return output;
	}
	public String checkRegistration(String userName, String Password, Statement stmt)
	{
		String sql="SELECT * FROM UU WHERE name = '"+userName+"' AND login = '"+Password+"'";
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	if(rs.first())
   		 	{
   		 		output = "There is a user with that name or password already";
   		 	}
   		 	else
   		 	{
   		 		sql="SELECT * FROM UD WHERE name = "+userName+" AND login = "+Password;
   		 		System.out.println("executing "+sql);
   		 		rs=stmt.executeQuery(sql);
   		 		if(rs.first())
   		 		{
   		 			output = "There is a driver with that name or password already";
   		 		}
   		 		else
   		 		{
   		 			output = "UserName and Password are avalible";
   		 		}
   		 	}
   		 	rs.close();
		 	}
		 	catch(Exception e)
		 	{
		 		
		 		System.out.println("cannot execute the query");
		 		System.out.println(e.getMessage());
		 		output = "error";
		 	}
		 	finally
		 	{
		 		
		 		try{
   		 		if (rs!=null && !rs.isClosed())
   		 			rs.close();
		 		}
		 		catch(Exception e)
		 		{
		 			System.out.println("cannot close resultset");
		 		}
		 		
		 	}
	    return output;
	}
}
