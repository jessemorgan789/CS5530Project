package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

public class Reservation {


	public Reservation()
	{}
	public String makeReservation(String login, String vin, String pid, String cost, String date, Statement stmt)
	{
		String sql = String.format("insert into Reserve Values(%s, %s, %s, %s)", login, vin, pid, cost, date);
		String output="";
		 	System.out.println("executing "+sql);
		 	try{
   		 	stmt.executeUpdate(sql);
   		 	output = "Insertion Successful, Reservation made";
		 	}
		 	catch(Exception e)
		 	{
		 		System.out.println("cannot execute the query");
		 	}
		 	finally
		 	{
		 	}
	    return output;
	}
	public String checkReserveTime(String DriverID, String vin, String pid, Statement stmt)
	{
		String sql = String.format("select * from Avaliable where login = '%s' and pid = '%s'", DriverID, pid);
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	if(rs.next())
   		 	{
   		 		sql = String.format("select * from Reserve where login = '%s' and pid = '%s'", DriverID, pid);
   		 		rs=stmt.executeQuery(sql);
   		 		if(rs.next()) {
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
		 		System.out.println(e.getMessage());
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
		String sql="select name from UC where vin = '"+vin+"'";
		ResultSet rs=null;
		ResultSet rs2 = null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	rs.next();
   		 	String DriverID = rs.getString("name");
   		 	sql = String.format("select login from UD where name = '%s'", DriverID);
   		 	rs = stmt.executeQuery(sql);
   		 	rs.next();
		 	DriverID = rs.getString("login");
		 	output = DriverID;
   		 	sql = "select pid from Avaliable where login = '"+DriverID+"'";
   		 	rs=stmt.executeQuery(sql);
   		 	while(rs.next())
   		 	{
   		 		sql = "select * from Period where pid = '" + rs.getString("pid")+"'";
   		 		rs2=stmt.executeQuery(sql);
   		 		rs2.next();
   		 		System.out.println("Pid: "+rs2.getString("pid")+" Hoursfrom: "+rs2.getString("fromHour")
   		 		+ "Hoursto: "+rs2.getString("toHour"));
   		 	}
   		 	}
		 	catch(Exception e)
		 	{
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
	

