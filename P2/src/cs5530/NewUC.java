package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

public class NewUC {

	public NewUC()
	{}
	public String makeNewUC(String vin, String catagory, String loginUD, Statement stmt, String tid)
	{
		if(vin == null)
		{
		vin = getVin(stmt);
		
		String sql = String.format("insert into UC Values(%s, %2d, %3d, %4d)", vin, catagory, loginUD);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
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
		 	sql = String.format("insert into IsCtypes Values(%s, %2d, %3d, %4d)", vin, tid);
		 	rs=null;
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
		else
		{
			String sql = String.format("UPDATE UC SET category = %s where vin = %2d)", catagory, vin);
			String output="";
			ResultSet rs=null;
			 	System.out.println("executing "+sql);
			 	try{
	   		 	rs=stmt.executeQuery(sql);
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
			 	sql = String.format("UPDATE IsCtypes SET tid = %s where vin = %2d", tid, vin);
			 	rs=null;
				 	System.out.println("executing "+sql);
				 	try{
		   		 	rs=stmt.executeQuery(sql);
		   		 	output = "Update Successful, Car is registered!";
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
	
	public String getVin(Statement stmt)
	{
		String result;
		int returnNum;
		String sql="select * from UC where vin >= MAX(vin)";
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs = stmt.executeQuery(sql);
   		 	if(rs.first())
   		 	{
   		 		result = rs.getNString("vin");
   		 		returnNum = Integer.parseInt(result);
   		 		returnNum += 1;
   		 		output = Integer.toString(returnNum);
   		 	}
   		 	else
   		 	{
   		 		output = "0";
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
