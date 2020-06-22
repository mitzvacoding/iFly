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
	
	public static DataObject big=new DataObject();
	public static HashMap<String,String> files;
	public static int customerKey=0;
	public static int flightKey=0;
	public static int managerKey=0;
	
	
	
	
	
	public static void init()
	{	
		//in case file exists
		
		try
		{
			big.put("Customer");
			big.put("Flight");
			big.put("Manager");
			//big.putInternal("Customer",1,new Customer("uzi","uzi1","1234"));
			//big.putInternal("Manager",2,new Manager("man","ma","*1",3));
			
			
			//FileInputStream fis = new FileInputStream("data.txt");
			//ObjectInputStream ois = new ObjectInputStream(fis);
			//big = (DataObject)ois.readObject();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				   
	}
	
	
	//Check if an object exists, then delete it
	
	public static void removeObj(String str,String mapName)
	{
		int key=0;
		
		if(mapName=="Customer") //search in User hash Map;
		{
			for(Object user: big.get("User").values())
			{
				 key++;
				if(((User)user).getEmail().equals(str))	 
					big.get("User").remove(key);
			
			}}
		
		else  //search in Flight hash Map;
		{
			key=0;
			
			for(Object Flight: big.get("Flight").values())
			{
				 key++;
				if(((Flight)Flight).getFlightId().equals(str))	 
					big.get("Flight").remove(key);
			}}
		
		
		
		
	}
		
	
	
	// check user exists
	public static boolean checkSignInCustomer(String email,String password)
	{//called when user is logging-in
		for(Object customer: big.get("Customer").values())
		{
			if( ((Customer)customer).getEmail().equals(email) && ((Customer)customer).getPassword().equals(password))
				return true;
			
		}
		return false;   

	}
	 
	//check Manager exists 
	public static boolean checkSignInManager(String email,String password)
	{
		//called when Manager is logging-in
		for(Object Manager: big.get("Manager").values())
		{
			if( ((Manager)Manager).getEmail().equals(email) && ((Manager)Manager).getPassword().equals(password)) 
				return true;
			
		}
		return false;
 
	}
	
	
	public static void addObject(String mapName, Object obj)
	{
		if(mapName=="Customer")
			big.putInternal(mapName,customerKey++,obj);	
		else if(mapName=="Flight")
			big.putInternal(mapName,flightKey++,obj);	
		else
			big.putInternal(mapName,managerKey++,obj);	
		
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

