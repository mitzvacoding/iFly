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
	public static boolean addObject(Object obj) 
	{
			if(DataBase.addObject(obj))
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
	
	public static void searchFlights(Flight f,int passengers) 
	{
		lastFlightResult = DataBase.searchFlight(f,passengers);

	}
	

	public static void searchRoundFlights(Object f,int passengers) 
	{
	
		
	}


	public static ArrayList<Flight> showFlightResult()
	{
		 return lastFlightResult;
	}
	
	
	
}








