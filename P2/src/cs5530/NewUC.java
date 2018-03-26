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
		
		String sql = String.format("insert into UC Values(%s, '%s', %s)", vin, catagory, loginUD);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
		 		stmt.executeUpdate(sql);
		 	}
		 	catch(Exception e)
		 	{
		 		System.out.println("cannot execute the query");
		 		System.out.println(e.getMessage());
		 	}
		 	finally
		 	{		 		
		 	}
		 	sql = String.format("insert into IsCtypes Values(%s, %s)", vin, tid);
			 	System.out.println("executing "+sql);
			 	try{
	   		 	stmt.executeUpdate(sql);
	   		 	output = "Insertion Successful, Car is registered!";

			 	}
			 	catch(Exception e)
			 	{
			 		System.out.println("cannot execute the query");
			 		System.out.println(e.getMessage());
			 	}
			 	finally
			 	{
			 	}
	    return output;
		}
		else
		{
			String sql = String.format("UPDATE UC SET category = %s where vin = %s)", catagory, vin);
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
		String sql="select MAX(vin) from UC";
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs = stmt.executeQuery(sql);

   		 		result = rs.getString(1);
   		 		returnNum = Integer.parseInt(result);
   		 		returnNum += 1;
   		 		output = Integer.toString(returnNum);   		 	
   		 	rs.close();
		 	}
		 	catch(Exception e)
		 	{
		 		String error = e.getMessage();
		 		if(error == null)
		 		{
		 			output = "0";
		 		}
		 		else {
		 			System.out.println("cannot execute the query");
		 		}
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
