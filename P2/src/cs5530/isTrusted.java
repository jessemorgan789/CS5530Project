package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

public class isTrusted {

	public isTrusted()
	{}
	public String markAsTrusted(String login1, String Username, Statement stmt)
	{
		String login2 = getPassword(Username, stmt);
		String sql = String.format("insert into Rates Values(%s, %2d, %3d)", login1, login2);
		
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	output = "Successfully marked User as trusted feedback";
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
	private String getPassword(String UserName, Statement stmt)
	{
		String sql = String.format("select login from UU where name = %s", UserName);
		
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	output = rs.getNString(1);
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
