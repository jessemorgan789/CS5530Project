package cs5530;


import java.lang.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.List;
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
	 	System.out.println("9. Mark other Users as trusted:");
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
	            		 while ((UserName = in.readLine()) == null && UserName.length() == 0);
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
	    	            		 boolean wantToContinue = true;
	    	            		 List userChoices = new List();
	    	            		 while (wantToContinue)
	    	            		 {
	    	            			 String vin;
	    	            			 String DriverID;
	    	            			 String pid;
	    	            			 Reservation Res = new Reservation();
	    	            			 System.out.println("please enter Vehicle ID you want to reserve Below:");
	    		            		 while ((vin = in.readLine()) == null && vin.length() == 0);
	    		            		 DriverID = Res.printAvalibleAndGetDriver(vin, con.stmt);
	    		            		 System.out.println("please select pid from above:");
	    		            		 while ((pid = in.readLine()) == null && pid.length() == 0);
	    		            		 String answer = Res.checkReserveTime(DriverID, vin, pid, con.stmt);
	    		            		 System.out.println(answer);
	    		            		 if(answer == "Slot avalible")
	    		            		 {
	    		            			 String date;
	    		            			 String cost;
	    		            			 System.out.println("please enter the date you want to reserve Below:");
		    		            		 while ((date = in.readLine()) == null && date.length() == 0);
		    		            		 System.out.println("please enter the cost:");
		    		            		 while ((cost = in.readLine()) == null && cost.length() == 0);
		    		            		 String userObject = new String();
		    		            		 userObject = DriverID + " " + vin + " " + pid + " " + cost + " " +date;
		    		            		 userChoices.add(userObject);
	    		            		 }
	    		            		 else {
	    		            			 String keepGoing;
	    		            			 System.out.println("Do you want to continue? 1 for yes 2 for no ");
	    		            			 while ((keepGoing = in.readLine()) == null && keepGoing.length() == 0);
	    		            			 if(keepGoing == "1")
	    		            			 {
	    		            				 continue;
	    		            			 }
	    		            			 else if(keepGoing == "2")
	    		            			 {
	    		            				 wantToContinue = false;
	    		            			 }
	    		            		 }
	    		            		 
	    	            		 }
	    	            		 String finish;
	    	            		 System.out.println("Here are your selections");
	    	            		 for(int i = 0; i < userChoices.getItemCount(); i++)
	    	            		 {
	    	            			 System.out.println(userChoices.getItem(i));
	    	            		 }
	    	            		 System.out.println("Are these okay? 1 for Yes 2 for No");
	    	            		 while ((finish = in.readLine()) == null && finish.length() == 0);
	    	            		 Reservation newRes = new Reservation();
	    	            		 if(finish == "1")
	    	            		 {
	    	            			 String DrID;
    	            				 String VIN;
    	            				 String PID;
    	            				 String COST;
    	            				 String DATE;
	    	            			 for(int i = 0; i < userChoices.getItemCount(); i++)
		    	            		 {
	    	            				 
		    	            			 String[] parts = userChoices.getItem(i).split(" ");
		    	            			 DrID = parts[0];
		    	            			 VIN= parts[1];
	    	            				 PID= parts[2];
	    	            				 COST= parts[3];
	    	            				 DATE= parts[4];
	    	            				 newRes.makeReservation(DrID, VIN, PID, COST, DATE, con.stmt);
		    	            		 }
	    	            		 }
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
	    	            		 String rating;
	    	            		 String FeedBackID;
	    	            		 usefullnessRating Rating = new usefullnessRating();
	    	            		 System.out.println("please enter Rating Below:");
	    	            		 while ((rating = in.readLine()) == null && rating.length() == 0);
	    	            		 System.out.println("please enter FeedBack ID Below:");
	    	            		 while ((FeedBackID = in.readLine()) == null && FeedBackID.length() == 0);
	    	            		 Rating.makeUsefullnessRating(Password, FeedBackID, rating, con.stmt);
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
	    	            	 if (c == 10)
	    	            	 {
	    	            		 //Mark other users as trusted
	    	            		 String Username;
	    	            		 isTrusted trust = new isTrusted();
	    	            		 System.out.println("please enter UserName to trust Below:");
	    	            		 while ((Username = in.readLine()) == null && Username.length() == 0);
	    	            		 trust.markAsTrusted(Password, UserName, con.stmt);
	    	            		 
	    	            	 }
	    	            	 if(c == 11)
	    	            	 {
	    	            		 //UC Browsing
	    	            		 
	    	            	 }
	    	            	 
	            		 }
	            		 else if(isSuccessful =="There is a driver with that name or password already" )
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
	    	            	 if (c==1) //Adding new Car
	    	            	 {
	    	            		 String catagory;
	    	            		 String TypeID;
	    	            		 NewUC car = new NewUC();
	    	            		 System.out.println("please enter Catagory Below:");
	    	            		 while ((catagory = in.readLine()) == null && catagory.length() == 0);
	    	            		 System.out.println("please enter Type ID Below:");
	    	            		 while ((TypeID = in.readLine()) == null && TypeID.length() == 0);
	    	            		 car.makeNewUC(null, catagory, Password, con.stmt, TypeID);
	    	            	 	 	    	            		 
	    	            	 }
	    	            	 if (c==2)//Updating existing car
	    	            	 {
	    	            		 String CarID;
	    	            		 String catagory;
	    	            		 String TypeID;
	    	            		 NewUC car = new NewUC();
	    	            		 System.out.println("please enter Car Id Below:");
	    	            		 while ((CarID = in.readLine()) == null && CarID.length() == 0);
	    	            		 System.out.println("please enter Catagory Below:");
	    	            		 while ((catagory = in.readLine()) == null && catagory.length() == 0);
	    	            		 System.out.println("please enter Type ID Below:");
	    	            		 while ((TypeID = in.readLine()) == null && TypeID.length() == 0);
	    	            		 car.makeNewUC(CarID, catagory, Password, con.stmt, TypeID);
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
