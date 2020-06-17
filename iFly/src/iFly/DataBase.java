package iFly;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class DataBase 
{
	
	public static DataObject big;
	public static HashMap<String,String> files;
	
	public static void init()
	{	
		//in case file exists
		try{ 
			FileInputStream fis = new FileInputStream("data.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			big = (DataObject)ois.readObject();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				   
	}

	//Check if an object exists, then delete it
	public static void removeObj(String str,int i)
	{
		int key=0;
		
		if(i==0) //search in User hash Map;
		{
			for(Object user: big.get("users").values())
			{
				 key++;
				if(((User)user).getEmail().equals(str))	 
					big.get("users").remove(key);
			
			}}
		
		else  //search in Flight hash Map;
		{
			key=0;
			
			for(Object Flight: big.get("Flights").values())
			{
				 key++;
				if(((Flight)Flight).getFlightId().equals(str))	 
					big.get("Flights").remove(key);
			}}
		
		
		
		
	}
		
	// check user exists
	public static boolean checkSignInCustomer(String Email,String password)
	{//called when user is logging-in
		for(Object user: big.get("users").values())
		{
			if( ((User)user).getEmail().equals(Email) && ((User)user).getPassword().equals(password))
				return true;
			
		}
		return false;

	}

	 //check Manager exists
	public static boolean checkSignInManager(String Email,String password)
	{//called when Manager is logging-in
		char c='*';
		for(Object user: big.get("users").values())
		{
			if(((User)user).getEmail().equals(Email) && ((User)user).getPassword().equals(password) &&((User)user).getEmail().charAt(0)==c )
				return true;
			
		}
		return false;

	}
	
	
	
	
	public static void addObject(String mapName, Object obj)
	{
		
	}
	
	
	
	
	
	private static void createFile(String fileName)
	{
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
}

