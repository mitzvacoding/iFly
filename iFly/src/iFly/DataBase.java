package iFly;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
	public static String str = null;
	
	public static HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();
	public static HashMap<Integer, InternationalFlight> internationalFlights = new HashMap<Integer, InternationalFlight>();
	public static HashMap<Integer, RoundTripFlight> flight = new HashMap<Integer, RoundTripFlight>();
	
	public static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();

//	public static HashMap<Integer,Flight> res=new HashMap<Integer,Flight>();
	
	
	
	public static void init()
	{	
		//in case file exists
		
		internationalFlights.put(flightKey++, new InternationalFlight(new Date("14/4/2000"), "USA"));
		internationalFlights.put(flightKey++, new InternationalFlight(new Date("14/4/2002"), "USB"));

		
		try
		{
			/*
			big.put("Customer");  
			big.put("Flight");
			big.put("Manager");
			big.put("InternationalFlight");
			big.put("ConnectionFlight");
			
			big.putInternal("Flight",1,new Flight(new Date(20,12,2020),new Date(22,12,2020),"ELT","Elal",200,5,"123"));
			
			
			big.putInternal("Customer",1,new Customer("uzi","uz","12"));
			big.putInternal("Manager",1,new Manager("man","ma","*1",3));
			
			
			//FileInputStream fis = new FileInputStream("data.txt");
			//ObjectInputStream ois = new ObjectInputStream(fis);
			//big = (DataObject)ois.readObject();
			*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				   
	}
	

	public static ArrayList<Flight> searchFlight(Object f,int passengers)
	{
		ArrayList<Flight> resultFlights = new ArrayList<Flight>();
		if(f.getClass().getSimpleName().equals("InternationalFlight"))
		{
			for(InternationalFlight flight: internationalFlights.values())// .values() return array of all data.
				{
					if(flight.getDepartureDate().equals(((InternationalFlight)f).getDepartureDate()) &&
						flight.getDestenation().equals(((InternationalFlight)f).getDestenation()) )
						resultFlights.add(flight);	
				} 
		}
		
		else if(f.getClass().getSimpleName().equals("Flight")) //Object f= Flight;
		{
			for(Flight flight: flights.values())
			{
				if( flight.getDepartureDate().equals(((Flight)f).getDepartureDate()))
					resultFlights.add(flight);
			}		
		}	
		
		return resultFlights;
	}
	
	public static void addFlights(HashMap<Integer, Flight> addedFlights)
	{
		for(Flight flight:addedFlights.values())
		{
			if(flight.getClass().getSimpleName().equals("Flight"))
				flights.put(flightKey++, flight);
			else if(flight.getClass().getSimpleName().equals("InternationalFlight"))
					internationalFlights.put(flightKey++, (InternationalFlight)flight);
		}
	}
	
	
	public static void searchRoundTripFlight(Object f,int passengers)
	{
		
		int key=0;
		if(f.getClass().equals("RoundTripFlight"))
		{
			
			for(Object Flight: big.get("Flight").values())
				{
					key++;
					if( ((InternationalFlight)Flight).getDepartureDate().equals(((InternationalFlight)f).getDepartureDate())&&
							((InternationalFlight)Flight).getLandingDate().equals(((InternationalFlight)f).getLandingDate()) )
						// res.put(key,(Flight) big.get("FLight").get(key));
						str+=  big.get("FLight").get(key)+"\n";
				}
		}
		
		else  //Object f= Flight;
		{
		
			for(Object Flight: big.get("Flight").values())
			{
				key++;
				if( ((Flight)Flight).getDepartureDate().equals(((Flight)f).getDepartureDate()))
					// res.put(key,(Flight) big.get("FLight").get(key));
					str+=big.get("FLight").get(key)+"\n";  
			
			}
			
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
		
	public static boolean signUpCustomer(Customer cst)
	{
		if(checkSignInCustomer(cst))//if already exists.
			return false;
		customers.put(customerKey++, cst);
		return true;
			
	}
	
	// check user exists, called when user is logging-in.
	public static boolean checkSignInCustomer(Customer cst)
	{
		for(Customer customer: customers.values())
		{
			if(customer.equals(cst))
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

