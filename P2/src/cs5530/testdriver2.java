package cs5530;


import java.lang.*;
import java.sql.*;
import java.io.*;

public class testdriver2 {

	/**
	 * @param args
	 */
	public static void displayMenuFirst()
	{
		 System.out.println("        Welcome to UUber System     ");
    	 System.out.println("1. Register as new UDriver or UUser:");
    	 System.out.println("2. Log in:");
    	 System.out.println("3. exit:");
    	 System.out.println("pleasse enter your choice:");
	}
	public static void displayMenuForUser()
	{
		System.out.println("        Thank you for logging in     ");
   	 	System.out.println("1. Make a Reservation:");
   	 	System.out.println("2. Record a Ride:");
   	 	System.out.println("3. Declare favorite Car:");
   	 	System.out.println("4. Make a Reservation:");
	 	System.out.println("5. Record a Ride:");
	 	System.out.println("6. Declare favorite Car:");
	 	System.out.println("7. Give Feedback:");
   	 	System.out.println("8. Rate other Feedback:");
   	 	System.out.println("9. Search for Cars:");
   	 	System.out.println("10. Get Feedback for Uber Driver:");
	 	System.out.println("11. Get Suggestions:");
	 	System.out.println("12. Get Statistics:");
   	 	System.out.println("please enter your choice:");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connector con=null;
		String choice;
        String cname;
        String dname;
        String sql=null;
        int c=0;
         try
		 {
			//remember to replace the password
			 	 con= new Connector();
	             System.out.println ("Database connection established");
	         
	             BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	             
	             while(true)
	             {
	            	 displayMenuFirst();
	            	 while ((choice = in.readLine()) == null && choice.length() == 0);
	            	 try{
	            		 c = Integer.parseInt(choice);
	            	 }catch (Exception e)
	            	 {
	            		 
	            		 continue;
	            	 }
	            	 if (c<1 | c>3)
	            		 continue;
	            	 if (c==1)
	            	 {
	            		 boolean correctReg = true;
	            		 while(correctReg)
	            		 {
	            			 int answer;
	            			 String UserName;
	            			 String Password;
	            			 String DrOrUser;
	            			 System.out.println("Are you a 1. Driver or 2. User?");
	            			 while ((DrOrUser = in.readLine()) == null && DrOrUser.length() == 0);
	            			 	try {
	            			 		answer = Integer.parseInt(DrOrUser);
	            			 	}catch(Exception e)
	            			 	{
	            			 		continue;
	            			 	}
	            			 if(answer == 1)
	            			 {
	            				System.out.println("please enter a UserName:");
	            			 	while ((UserName = in.readLine()) == null && UserName.length() == 0);
	            			 	System.out.println("please enter a Password:");
	            			 	while ((Password = in.readLine()) == null && Password.length() == 0);
	            			 	Registration reg =new Registration();
	            			 	String avalibility = reg.checkRegistration(UserName, Password, con.stmt);
	            			 	System.out.println(avalibility);
	            			 	if(avalibility == "UserName and Password are avalible")
	            			 	{
	            			 		String address;
	            			 		String phone;
	            			 		
	            			 		System.out.println("please enter an adrress:");
		            			 	while ((address = in.readLine()) == null && address.length() == 0);
		            			 	System.out.println("please enter a phone:");
		            			 	while ((phone = in.readLine()) == null && phone.length() == 0);
		            			 	reg.makeRegistrationForDriver(UserName, Password, address, phone, con.stmt);
		            			 	correctReg = false;
	            			 	}
	            			 }
	            			 if(answer == 2 )
	            			 {
	            				System.out.println("please enter a UserName:");
	            			 	while ((UserName = in.readLine()) == null && UserName.length() == 0);
	            			 	System.out.println("please enter a Password:");
	            			 	while ((Password = in.readLine()) == null && Password.length() == 0);
	            			 	Registration reg =new Registration();
	            			 	String avalibility = reg.checkRegistration(UserName, Password, con.stmt);
	            			 	System.out.println(avalibility);
	            			 	if(avalibility == "UserName and Password are avalible")
	            			 	{
	            			 		String address;
	            			 		String phone;
	            			 		
	            			 		System.out.println("please enter an adrress:");
		            			 	while ((address = in.readLine()) == null && address.length() == 0);
		            			 	System.out.println("please enter a phone:");
		            			 	while ((phone = in.readLine()) == null && phone.length() == 0);
		            			 	reg.makeRegistrationForUser(UserName, Password, address, phone, con.stmt);
		            			 	correctReg = false;
	            			 	}
	            			 }
	            			 else
	            			 {
	            				 System.out.println("Incorrect choice, please try again");
	            			 }
	            		 }
	            	 }
	            	 else if (c==2)
	            	 {	 
	            		 System.out.println("please enter your query below:");
	            		 while ((sql = in.readLine()) == null && sql.length() == 0)
	            			 System.out.println(sql);
	            		 ResultSet rs=con.stmt.executeQuery(sql);
	            		 ResultSetMetaData rsmd = rs.getMetaData();
	            		 int numCols = rsmd.getColumnCount();
	            		 while (rs.next())
	            		 {
	            			 //System.out.print("cname:");
	            			 for (int i=1; i<=numCols;i++)
	            				 System.out.print(rs.getString(i)+"  ");
	            			 System.out.println("");
	            		 }
	            		 System.out.println(" ");
	            		 rs.close();
	            	 }
	            	 if (c==3)
	            	 {
	            		 //Declare favorite Car method
	            	 }
	            	 if (c==4)
	            	 {
	            		 //Make a Reservation
	            	 }
	            	 if (c==5)
	            	 {
	            		 //Record a Ride
	            	 }
	            	 if (c==6)
	            	 {
	            		 //Declare a Favorite Car
	            	 }
	            	 if (c==7)
	            	 {
	            		 //Give Feedback
	            	 }
	            	 if (c==8)
	            	 {
	            		 //Rate other Feedback
	            	 }
	            	 if (c==9)
	            	 {
	            		 //Search for Cars
	            	 }
	            	 if (c==10)
	            	 {
	            		 //Give Feedback for Uber Driver
	            	 }
	            	 if (c==11)
	            	 {
	            		 //Get Suggestions
	            	 }
	            	 if (c==12)
	            	 {
	            		 //Get Statistics
	            	 }
	            	 else
	            	 {   
	            		 System.out.println("EoM");
	            		 con.stmt.close(); 
	        
	            		 break;
	            	 }
	             }
		 }
         catch (Exception e)
         {
        	 e.printStackTrace();
        	 System.err.println ("Either connection error or query execution error!");
         }
         finally
         {
        	 if (con != null)
        	 {
        		 try
        		 {
        			 con.closeConnection();
        			 System.out.println ("Database connection terminated");
        		 }
        	 
        		 catch (Exception e) { /* ignore close errors */ }
        	 }	 
         }
	}
}
