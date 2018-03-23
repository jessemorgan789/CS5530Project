package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

public class usefullnessRating {


	public usefullnessRating()
	{}
	public String makeUsefullnessRating(String login, String fid, String rating, Statement stmt)
	{
		String sql = String.format("insert into Rates Values(%s, %2d, %3d)", login, fid, rating);
		
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	output = "Successfully rated feedback";
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
