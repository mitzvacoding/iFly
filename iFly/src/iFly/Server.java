package iFly;

public class Server 
{
	
	 
	// check if details appears in DB;
	public static boolean requestSignInCustomer(String email,String password)
	{
		if(DataManagement.SignInCustomer(email,password))
			return true;
	else 
		return false; 
	};
	
 
	public static boolean requestSignInManager(String email,String password)
	{
		if(DataManagement.SignInManager(email,password))
			return true;
	else 
		return false; 
	};
	

	
	
	 
	// Search flight
	public static void requestSearchFlight(Date depDate, Date returnDate, String Destination, int passengers, Integer abroadFlight, Integer roundTrip) 	
	{ 
     Object f=null;
      
      f=(Flight)ObjectsFactory.getFlightByButton(depDate, returnDate,Destination);

      if( f.getClass().getSimpleName()=="RoundTripFlight")
    	  DataManagement.searchRoundFlights( f,passengers);
      else
         DataManagement.searchFlights(f,passengers);
			
	}

	
	
	
	
	
	// add Flight or Customer;
	public static void requestAddObject( String mapName,Object o) 
	{DataManagement.addObject(mapName,o);};
	   
  
	public static void requestremoveObj( String str,String mapName) 

    {DataManagement.removeObj(str,mapName);}
	
	
};	
