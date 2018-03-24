package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

public class Reservation {


	public Reservation()
	{}
	public String makeReservation(String login, String vin, String pid, String cost, String date, Statement stmt)
	{
		String sql = String.format("insert into Reserve Values(%s, %2d, %3d, %4d)", login, vin, pid, cost, date);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	output = "Insertion Successful, Reservation made";
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
	public String checkReserveTime(String DriverID, String vin, String pid, Statement stmt)
	{
		String sql = String.format("select * from Available where login = %s and pid = %2d", DriverID, pid);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	if(rs.first())
   		 	{
   		 		sql = String.format("select * from Reservation where login = %s and pid = %2d", DriverID, pid);
   		 		rs=stmt.executeQuery(sql);
   		 		if(rs.first()) {
   		 			output = "Sorry that slot is already Reserved";
   		 		}
   		 		else
   		 		{
   		 			output = "Slot avalible";
   		 		}
   		 	}
   		 	else
   		 	{
   		 		output = "Sorry that slot is not avalible ";
   		 	}
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
	public String printAvalibleAndGetDriver(String vin, Statement stmt)
	{
		String output = "";
		String sql="select login from UC where vin = "+vin;
		ResultSet rs=null;
		ResultSet rs2 = null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	String DriverID = rs.getNString(1);
   		 	output = DriverID;
   		 	sql = "select pid from Available where login = "+DriverID;
   		 	rs=stmt.executeQuery(sql);
   		 	while(rs.next())
   		 	{
   		 		sql = "select * from Period where pid = " + rs.getString("pid");
   		 		rs2=stmt.executeQuery(sql);
   		 		System.out.println("Pid: "+rs2.getString("pid")+" Hoursfrom: "+rs2.getString("fromHour")
   		 		+ "Hoursto: "+rs2.getString("toHour"));
   		 	}
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
	

