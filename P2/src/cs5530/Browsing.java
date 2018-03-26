package cs5530;

import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class Browsing {

	public Browsing() {}
	public String findCars(String Catagory, String address, String model, String ANDorOR, Statement stmt)
	{
		String sql = "";
		if(ANDorOR.equals("and"))
		{
			if(Catagory.equals("none"))
			{
				if(address == "none")
				{
					if(model.equals("none")) //All none
					{
						sql = "select * from UC";
					}
					else //Model only
					{
						sql = "select Car.vin, Type.Model from UC Car, Ctypes Type, IsCtypes IsType"
								+ " where Car.vin = IsType.vin AND IsType.tid = Type.tid AND Car.login = Driver.login AND Type.model = '"+model+"'";
								
					}
				}
				else //address, maybe model
				{
					if(model.equals("none")) //Address ONly
					{
						sql = "select Car.vin, Type.Model from UD Driver UC Car, Ctypes Type, IsCtypes IsType"
								+ " where Car.vin = IsType.vin AND IsType.tid = Type.tid AND Car.login = Driver.login AND Driver.address = '"+address+"'";
					}
					else //Model only
					{
						sql = "select Car.vin, Type.Model from UC Car, Ctypes Type, IsCtypes IsType"
								+ " where Car.vin = IsType.vin AND IsType.tid = Type.tid AND Type.model = '"+model+"'";
								
					}
				}
			}
		}
		
		String output="";
		ResultSet rs=null;
		 	System.out.println("executing "+sql);
		 	try{
   		 	rs=stmt.executeQuery(sql);
   		 	java.sql.ResultSetMetaData rsmd = rs.getMetaData();
   		 	int columnsNumber = rsmd.getColumnCount();
   		 	while (rs.next()) {
   		 		for (int i = 1; i <= columnsNumber; i++) {
   		 			if (i > 1) System.out.print(",  ");
   		 			String columnValue = rs.getString(i);
   		 			System.out.print(columnValue + " " + rsmd.getColumnName(i));
   		 		}
   	       System.out.println("");
   		 	}
   		 	rs.close();
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
	public String checkRegistration(String userName, String Password, Statement stmt)
	{
		String sql="select * from UU where name = "+userName+" and login = "+Password;
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
   		 		sql="select * from UD where name like '%"+userName+"%' and login like '%"+Password+"%'";
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
