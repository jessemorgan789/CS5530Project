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
	 	System.out.println("4. Give Feedback:");
   	 	System.out.println("5. Rate other Feedback:");
   	 	System.out.println("6. Search for Cars:");
   	 	System.out.println("7. Get Feedback for Uber Driver:");
	 	System.out.println("8. Get Suggestions:");
	 	System.out.println("9. Get Statistics:");
   	 	System.out.println("please enter your choice:");
	}
	public static void displayMenuForDriver()
	{
		System.out.println("        Thank you for logging in     ");
   	 	System.out.println("1. Add new Car");
   	 	System.out.println("2. Update existing Car");
   	 	System.out.println("3. Search for Cars:");
   	 	System.out.println("4. Get Feedback for Uber Driver:");
	 	System.out.println("5. Get Suggestions:");
	 	System.out.println("6. Get Statistics:");
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
	            		 String UserName;
	            	 	 String Password;
	            	 	 Registration login = new Registration();
	            		 System.out.println("please enter UserName Below:");
	            		 while ((UserName = in.readLine()) == null && UserName.length() == 0)
	            		 System.out.println("please enter Password Below:");
	            		 while ((Password = in.readLine()) == null && Password.length() == 0);
	            		 String isSuccessful = login.checkRegistration(UserName, Password, con.stmt);
	            		 if(isSuccessful == "There is a user with that name or password already")
	            		 {
	            			 String choice2;
	            			 System.out.println("Login Successful");
	            			 displayMenuForUser();
	            			 while ((choice2 = in.readLine()) == null && choice2.length() == 0);
	    	            	 try{
	    	            		 c = Integer.parseInt(choice2);
	    	            	 }catch (Exception e)
	    	            	 {	    	            		 
	    	            		 continue;
	    	            	 }
	    	            	 if (c<1 | c>3)
	    	            		 continue;
	    	            	 if (c==1)
	    	            	 {
	    	            		 //make reservation
	    	            	 }
	    	            	 if (c==2)
	    	            	 {
	    	            		 //Record a ride
	    	            	 }
	    	            	 if (c==3)
	    	            	 {
	    	            		 
	    	            		 // Declare favorite Car
	    	            	 }
	    	            	 if (c==4)
	    	            	 {
	    	            		 //Give Feedback
	    	            	 }
	    	            	 if (c==5)
	    	            	 {
	    	            		 //Rate other Feedback
	    	            	 }
	    	            	 if (c==6)
	    	            	 {
	    	            		 //Search for Cars
	    	            	 }
	    	            	 if (c==7)
	    	            	 {
	    	            		 //Get Feedback for Uber Driver
	    	            	 }
	    	            	 if (c==8)
	    	            	 {
	    	            		 //Get Suggestions
	    	            	 }
	    	            	 if (c==9)
	    	            	 {
	    	            		 //Get Statistics
	    	            	 }
	    	            	 
	            		 }
	            		 else if(isSuccessful =="There is a dirver with that name or password already" )
	            		 {
	            			 String choice2;
	            			 System.out.println("Login Successful");
	            			 displayMenuForDriver();
	            			 while ((choice2 = in.readLine()) == null && choice2.length() == 0);
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
	    	            		 //1. Add new Car
	    	            	 	 	    	            		 
	    	            	 }
	    	            	 if (c==2)
	    	            	 {
	    	            		//2. Update Existing car
	    	            	 }
	    	            	 if (c==3)
	    	            	 {
	    	            		//Search for a Car
	    	            		
	    	            	 }
	    	            	 if (c==4)
	    	            	 {
	    	            		//4. Get Feedback for Uber Driver
	    	            	 }
	    	            	 if (c==5)
	    	            	 {
	    	            		//5. Get Suggestions
	    	            	 }
	    	            	 if (c==6)
	    	            	 {
	    	            		//6. Get Statistics
	    	            	 }
	            		 }
	            		 else {
	            			 System.out.println("login Failed");
	            			 
	            		 }
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
