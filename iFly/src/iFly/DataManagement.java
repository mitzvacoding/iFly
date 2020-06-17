 package iFly;

public class DataManagement 
{


	 // called by server.requestSignInmanager()+server.requestSignUpCustomer() 
	public static boolean SignInUser(String email,String password)
	 {  
		if(password.charAt(0)=='*')
		{
			if(DataBase.checkSignInManager(email, password))
				return true;
				
			return false;
			
		}
		else
		{
			
			if(DataBase.checkSignInCustomer(email, password))
				return true;
				
			return false;		
			
		}
	}


	//called by server.AddObject 
	public static void addObject(Object o) 
	{
		if(o.getClass().equals("Customer"))
			DataBase.addObject("Customer",o);
		else
			DataBase.addObject("Flights",o);
		
	}
	
	
	public static void removeObj(String str,int i)
	{
		
		
		
	}
	
	
	
	//called by server.requestSearchFlight
	public static void searchFlights(Flight fl) 
	{
	
		

	}

	public static void searchRoundFlights(Flight fl) 
	{
	
	
		
		
	}


	
	
}
