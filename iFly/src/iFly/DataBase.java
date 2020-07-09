package iFly;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class DataBase 
{
	
	
	
	
	/*
	public static boolean removeObj(String str,String objName);
	public static boolean addObject(Flight flt)
	public static Boolean findExistFlight(Flight flt)
	public static boolean checkSignInManager(String email,String password)
	public static boolean checkSignInCustomer(Customer cst)
	public static void searchRoundTripFlight(Object f,int passengers)
	public static void addFlights(HashMap<Integer, Flight> addedFlights)
	public static ArrayList<Flight> searchFlight(Flight f,int passengers)
	public static void initKeys()
	public static void readFromFile()
	public static void writeToFile()
	public static void init()
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	public static HashMap<String,String> files;
	public static int customerKey=1;
	public static int flightKey=1;
	public static int managerKey=1;
	public static int interFlightKey=1;  
	public static String str = null;
	public static String fileName = "data.txt";

	
	public static HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();
	public static HashMap<Integer, InternationalFlight> internationalFlights = new HashMap<Integer, InternationalFlight>();

	public static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();
	public static HashMap<Integer, Manager> managers = new HashMap<Integer, Manager>();
	


	
	public static void init()  
	{	
    
		readFromFile();
	
		initKeys();

		
		managers.put(1, new Manager("123", "123", "*1", 2));
		customers.put(1,new Customer("123","123","123"));
		

		for(Flight flt: flights.values())
		{
			System.out.println(flt.toString()+"\n");
		}
		
		for(InternationalFlight flt: internationalFlights.values())
		{
			System.out.println(flt.toString()+"\n");
		}
		/* a proof that it read from file
		for(Customer cst: customers.values())
		{
			System.out.println(cst.toString()+"\n");
		}
		System.out.println("\n\n");
		for(Flight flt: flights.values())
		{
			System.out.println(flt.toString()+"\n");
		}
		System.out.println("\n\n");
		for(InternationalFlight flt: internationalFlights.values())
		{
			System.out.println(flt.toString()+"\n");
		}
		*/

	/*			   
	} 
	
	
	public static void writeToFile()
	{
		ObjectOutputStream oos = null;
		try{
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(flights);
			oos.writeObject(internationalFlights);
			oos.writeObject(customers);
			oos.writeObject(managers);
			oos.close();
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void readFromFile()
	{
		Path path = Paths.get(System.getProperty("user.dir") + "\\" + fileName);
		
		if(Files.exists(path))
		{
			try
			{
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				flights = (HashMap<Integer,Flight>)ois.readObject();
				internationalFlights = (HashMap<Integer,InternationalFlight>)ois.readObject();

				customers = (HashMap<Integer,Customer>)ois.readObject();
				managers = (HashMap<Integer,Manager>)ois.readObject();	
				
				ois.close();
				fis.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void initKeys() 
	{
		flightKey = flights.size();
		interFlightKey = internationalFlights.size();
		
		customerKey = customers.size();
		managerKey = managers.size();
	}

	
	
	public static ArrayList<Flight> searchFlight(Flight f,int passengers)
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
		
		else if(f.getClass().getSimpleName().equals("Flight")) //Object f= Flight;  ,   ///this is the problem;
		{
			for(Flight flight: flights.values())
			{
				if( flight.getDepartureDate().equals(f.getDepartureDate()))
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
					internationalFlights.put(interFlightKey++, (InternationalFlight)flight);
		}
	}
	
	
	public static void searchRoundTripFlight(Object f,int passengers)
	{
		
		
					
	}
		
	
	
		
	public static void signUpCustomer(Customer cst)
	{
		customers.put(customerKey++, cst);		
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
		for(Manager manager: managers.values())
		{
			if( manager.getEmail().equals(email) && manager.getPassword().equals(password)) 
				return true;		
		}
		return false;
	}

	//being called when adding a flight
	public static Boolean findExistFlight(Flight flt)
	{
		if(ObjectsFactory.getClassName(flt).equals("Flight"))
		{
			for(Flight flight: flights.values())
			{
				if( flight.getFlightId().equals( flt.getFlightId() ) ) 
				{
					flight.setQuantity(flight.getQuantity()+flt.getQuantity());
					return true; 
				}		
			}	
		}
		
		else if(ObjectsFactory.getClassName(flt).equals("InternationalFlight"))
		{
			for(InternationalFlight flight: internationalFlights.values())
			{
				if( flight.getFlightId().equals(((InternationalFlight) flt).getFlightId()  ) ) 
				{
					flight.setQuantity(flight.getQuantity()+((InternationalFlight) flt).getQuantity());
				    return true;				    
				}	
			}		
		}		
		return false;	
	}
	
	  
	
	
	public static boolean addObject(Flight flt)
	{
		String className = 	ObjectsFactory.getClassName(flt);	
			if(findExistFlight(flt)==false)
			{
				if(className.equals("Flight"))
					flights.put(flightKey++, flt);
				else 
					if(className.equals("InternationalFlight"))
						internationalFlights.put(interFlightKey++, (InternationalFlight) flt);
				return true;
			}

			return false;
					
	}
	
	//Check if an object exists, then delete it
	public static boolean removeObj(String str,String objName)
	{
		int	key=0;
		
		if(objName=="Customer")
		{	
			for(Customer customer: customers.values())
				{
				
					if(customer.getEmail()==str)
					{
						customers.remove(key);
						return true;
					}
						key++;}}
			
		else if(objName=="Flight")
		{
				key=0;
			
			for(Flight flight: flights.values())
			{
				if( flight.getFlightId()==str)
				{
					flights.remove(key);
					return true;
				}
					key++;	}}			
		else
		{
			 key=0;
				for(InternationalFlight flight: internationalFlights.values())
				{
					if(	flight.getFlightId()==str)
					{
						internationalFlights.remove(key);
					return true;
						
					}
						key++;}}
			
		return false;
	}
	
	 */

}

