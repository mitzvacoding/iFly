 package iFly;

import java.util.ArrayList;

public class DataManagement 
{
	public static ArrayList<Flight> lastFlightResult = new ArrayList<Flight>();


	 // called by server.requestSignInmanager()+server.requestSignUpCustomer() 
	public static boolean SignInCustomer(String email,String password)
	 {  
			if(DataBase.checkSignInCustomer(email, password))
				return true;
			
		return false;			
	 }	
	
	
	public static boolean SignInManager(String email,String password)
	{
	if(DataBase.checkSignInManager(email, password))
		return true;
		 
	return false;
	}
 

	
	//called by server.AddObject 
	public static void addObject( String mapName,Object o) 
	{
		if(mapName=="Customer")
			DataBase.addObject("Customer",o);
		else if(mapName=="Flight")
			DataBase.addObject("Flight",o); 
		else 
			DataBase.addObject("Manager",o);
	 
		
	}
	
	
	public static void removeObj(String str,String mapName)
	{
		
		DataBase.removeObj(str, mapName);
		
	}
	
	
	
	//called by server.requestSearchFlight
	
	public static void searchFlights(Object f,int passengers) 
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








