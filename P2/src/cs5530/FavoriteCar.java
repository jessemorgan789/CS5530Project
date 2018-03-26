package cs5530;

import java.io.BufferedReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FavoriteCar {

	public FavoriteCar() {};
	
	public ArrayList<String> getCars(String login, Statement stmt) {
		ResultSet rs = null;
		String query = "SELECT vin FROM UC WHERE name = '" + login + "'";
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Query getCars failed due to error:");
			System.out.println(e);
		}
 		 ArrayList<String> vin = new ArrayList<String>();
 		 try {
			while (rs.next()) {
				 vin.add(rs.getString("vin"));
			 }
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not add vin to ArrayList due to error:");
			System.out.println(e);
		} finally
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
 		return vin;
	}
	
	public ArrayList<String> checkMakeModel(String make, String model, String vin, Statement stmt){
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		String query = String.format("SELECT vin FROM IsCtypes, Ctypes "
				+ "WHERE IsCtypes.tid = Ctypes.tid AND "
				+ "make = '%s' AND model = '%s' "
				+ "AND vin = '%s'", make, model, vin);
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Cannot execute checkMakeModel Query due to error:");
			System.out.println(e);
		}
		try {
			while (rs.next()) {
				 result.add(rs.getString("vin"));
			 }
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not add vin to ArrayList due to error:");
			System.out.println(e);
		}
		return result;
	}
		
public void AddFavorite(String make, String model, String vin, String user, Statement stmt) {
		String query = String.format("INSERT INTO Favorites (vin, name, fdate)"
						 		+ "VALUES ('%s', '%s', '%s')", vin, user, java.time.LocalDate.now());
		System.out.println(query);
		try{
		stmt.executeUpdate(query);
		} 
		catch (SQLException e) {
		System.out.println("Query addFavorite failed due to error:");
		System.out.println(e);
		}
	}
}
