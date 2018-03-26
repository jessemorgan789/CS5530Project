package cs5530;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class FeedBack {

	public FeedBack() {};
	
	public ArrayList<String> getCars(String login, Statement stmt){
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
	
	public ArrayList<String> CheckMakeModel(String make, String model, String vin, Statement stmt){
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
	
	public int GetFid(Statement stmt) {
		String query = "SELECT MAX(fid) FROM Feedback";
		ResultSet rs = null;
		int fid = 0;
		try {
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				fid = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			System.out.println("Cannot execute fid query due to error:");
			System.out.println(e);
		} finally{
			try{
				if (rs!=null && !rs.isClosed())
					rs.close();
			}
			catch(Exception e)
			{
				System.out.println("cannot close resultset");
			}
		
		}
		return fid;
	}
	
	public void AddFeedback(String user, String fid, String text, String vin, Statement stmt) {
		String query = String.format("SELECT * FROM Feedback WHERE login = '%s' AND vin = '%s'", user, vin);
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (!rs.next()) {
				query = String.format("INSERT INTO Feedback (fid, text, fbdate, vin, login) VALUES ('%s', '%s', '%s', '%s', '%s')", fid, text, java.time.LocalDate.now(), vin, user);
				try {
					stmt.executeUpdate(query);
				} catch (SQLException e) {
					System.out.println("Insert for feedback failed due to error:");
					System.out.println(e);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
