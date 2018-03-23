package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

public class NewUC {

	public NewUC()
	{}
	public String makeNewUC(String vin, String catagory, String loginUD, Statement stmt)
	{
		String sql = String.format("insert into UC Values(%s, %2d, %3d, %4d)", vin, catagory, loginUD);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	output = "Insertion Successful, Car is registered!";
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
	
	public String checkUC(String userName, String Password, Statement stmt)
	{
		String sql="select * from UD where name like '%"+userName+"%' and login like '%"+Password+"%'";
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	if(rs.first())
   		 	{
   		 		output = "Driver Verified";
   		 	}
   		 	else
   		 	{
   		 		output = "Sorry you are not a Driver";
   		 	}
   		 	
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
}
