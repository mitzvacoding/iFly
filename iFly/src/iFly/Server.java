package iFly;

public class Server 
{
	
	public  static void requestSignUpManger(String email) {DataManagement.checkUserExists(email); };
	
	
	public static boolean requestSignUpCustomer(String name,String email,String password) 
	{
	 if(DataManagement.checkUserExists(email))  
		return true;
	else return false;
		
	};
	
	
	public static boolean requestSignInUser(String email,String password)
	{
		if(DataManagement.SignInUser(email,password))
			return true;
		
		else return false;
	};
	
	public static void requestAddFlights() {};
	
	
	
	public  static void checkUserConnected() {};
	
	
	public static void requestSearchFlight(Date depDate, Date returnDate, String Destination, int passengers, Integer abroadFlight, Integer roundTrip) 	
	{ 
      Flight fl=null;
      
      fl=(Flight)ObjectsFactory.getFlightByButton(depDate, returnDate,Destination);//abroadFlight, roundTrip);

      if( fl.getClass().getSimpleName()=="RoundTripFlight")
    	  
         DataManagement.searchFlights(fl);
			
	}
	
};	
