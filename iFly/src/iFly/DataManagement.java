 package iFly;

public class DataManagement 
{
	public static boolean SignInUser(String email,String password) 
	 {
		DataBase.checkSignInUser(email, password);
		return true;
	}
	public static boolean upDataDb(){return true;}
	public static User createUser(){return null;}
	public static boolean addUser() {return true;}
	
	
	public static boolean CheckUserExists(String email) 
	{ 
	      if(DataBase.checkUserDB(email)== true)
    	  	return true;
	      else 
	      return false;
	}
	
	
	
	public static void searchFlights() 
	{
	
		

	}


	
	

}
