package iFly;

public class Server 
{
	
	//check if   manager details Does not appear in DB;
	public  static boolean requestSignUpManger(String email,String password) 
	
	{
		if(DataManagement.SignInUser(email, password))
			return true;
		
		return false;
	};
	
	
	//check if customer details Does not appear in DB;
	public static boolean requestSignUpCustomer(String name,String email,String password) 
	
	{
		if(DataManagement.SignInUser(email, password))
			return true;
			
		return false;
	
	};
	
	
	
	// check if details appears in DB;
	public static boolean requestSignInUser(String email,String password)
	
	{if(DataManagement.SignInUser(email,password))return true;else return false; };

	
	// Search flight
	public static void requestSearchFlight(Date depDate, Date returnDate, String Destination, int passengers, Integer abroadFlight, Integer roundTrip) 	
	{ 
      Flight fl=null;
      
      fl=(Flight)ObjectsFactory.getFlightByButton(depDate, returnDate,Destination);

      if( fl.getClass().getSimpleName()=="RoundTripFlight")
    	  DataManagement.searchRoundFlights(fl);
      else
         DataManagement.searchFlights(fl);
			
	}

	
	// add Flight or Customer;
	public static void requestAddObject(Object o) 
	
	
	{DataManagement.addObject(o);};
	

	public static void requestremoveObj( String str,int i) 

    {DataManagement.removeObj(str, i);}
	
	
};	
