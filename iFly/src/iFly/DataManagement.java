 package iFly;

public class DataManagement 
{
	public static boolean requestData() {return true;}
	public static boolean upDataDb(){return true;}
	public static User createUser(){return null;}
	public static boolean addUser() {return true;}
	
	public static boolean checkUserExists(String email) 
	{//called by Server.requestSignInUser()
	 //
	      if(DataBase.checkUserDB(email)== true)
	    	  return true;
	      else 
	    	  return false;
	}
	
	public static void searchFlights() 
	{
	
		

	}


	
	

}
