 package iFly;

import java.util.ArrayList;

public class DataManagement 
{
	public static ArrayList<Flight> lastFlightResult = new ArrayList<Flight>();


	 // called by server.requestSignInmanager()+server.requestSignUpCustomer() 
	public static boolean SignInCustomer(String email,String password)
	{  
		return 	DataBase.checkSignInCustomer(new Customer(email));
	}	
	
	public static boolean signUpCustomer(String name, String email, String password)
	{
		if(DataBase.checkSignInCustomer(new Customer(email)))
			return false;
		DataBase.signUpCustomer(new Customer(name , email, password));
		return true;
		 
			
	}
	
	public static boolean SignInManager(String email,String password)
	{
		if(DataBase.checkSignInManager(email, password))
			return true;	 
		return false;
	} 
 

	
	//called by server.AddObject 
	public static boolean addFlight(String depDateString,String landDateString,String origin,String destination,String vendor,int price,int quantity,String flightId) 
	{
		Date landDate = null;
		if(landDateString.isEmpty()== false)
			landDate = new Date(landDateString);
		
		Flight flt = ObjectsFactory.getFlightByButton(new Date(depDateString), landDate, origin, destination, vendor, price, quantity, flightId, true);
		
		if(DataBase.addObject(flt))
			return true;
		return false;
	}
	
	
	public static boolean removeObj(String str,String objName)
	{
		
		if(DataBase.removeObj(str,objName))
			return true;	 
		return false;
	}
	
	
	
	//called by server.requestSearchFlight
	
	public static void searchFlights(String depDateString, String returnDateString,String origin, String destination, int passengers) 
	{
		Date depDate = new Date(depDateString);
		Date returnDate = null;
		if(!returnDateString.isBlank())
			returnDate = new Date(returnDateString);
		
		Flight flt = ObjectsFactory.getFlightByButton(depDate, returnDate, origin, destination, "", 0, 0, "", false);
		
		lastFlightResult = DataBase.searchFlight(flt,passengers);

	} 
	

	public static void searchRoundFlights(Object f,int passengers) 
	{
	
		
	}


	public static ArrayList<Flight> showFlightResult()
	{
		 return lastFlightResult;
	}
	
	
	
}








