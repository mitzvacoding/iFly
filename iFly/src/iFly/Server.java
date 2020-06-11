package iFly;

public class Server 
{
	
	
	public  static void requestSignUpManger(String email) {DataManagement.CheckUserExists(email); };
	public static void requestSignUpCustomer(String name,String email,String password) { DataManagement.CheckUserExists(email);   };
	public static void requestSignInUser(String email,String password) {DataManagement.SignInUser(email,password); };
	
	public static void requestAddFlights() {};
	public  static void checkUserConnected() {};
	
	
	public static void requestSearchFlight(Date date, String Destination, int passengers) 	
	{ 
		

		
		
		
		
	}
	
};	
