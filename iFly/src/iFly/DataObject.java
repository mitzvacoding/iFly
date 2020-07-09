package iFly;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class DataObject
{
	private int customerKey=1;
	private int flightKey=1;
	private int managerKey=1;
	private int interFlightKey=1;  
	private String str = null;
	private String fileName = "data.txt";

	
	private HashMap<Integer, Flight> flights;
	private HashMap<Integer, InternationalFlight> internationalFlights;

	private HashMap<Integer, Customer> customers;
	private HashMap<Integer, Manager> managers;

	
	public DataObject()
	{
		flights = new HashMap<Integer, Flight>();
		internationalFlights = new HashMap<Integer, InternationalFlight>();
		
		customers = new HashMap<Integer, Customer>();
		managers = new HashMap<Integer, Manager>();
		
		readFromFile();
		initKeys();
	}
	
	public void writeToFile()
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
	
	@SuppressWarnings("unchecked")
	public void readFromFile()
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

	public void initKeys() 
	{
		flightKey = flights.size();
		interFlightKey = internationalFlights.size();
		
		customerKey = customers.size();
		managerKey = managers.size();
	}

	
	
	public ArrayList<Flight> searchFlight(Flight f,int passengers)
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
	
	public void addFlights(HashMap<Integer, Flight> addedFlights)
	{
		for(Flight flight:addedFlights.values())
		{
			if(flight.getClass().getSimpleName().equals("Flight"))
				flights.put(flightKey++, flight);
			else if(flight.getClass().getSimpleName().equals("InternationalFlight"))
					internationalFlights.put(interFlightKey++, (InternationalFlight)flight);
		}
	}
	
	
	public void searchRoundTripFlight(Object f,int passengers)
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
		
	
	
		
	public void signUpCustomer(Customer cst)
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
	public boolean checkSignInManager(String email,String password)
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
	public Boolean findExistFlight(Flight flt)
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
	
	  
	
	
	public boolean addObject(Flight flt)
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
	public boolean removeObj(String str,String objName)
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
	
	/*
	private int customerKey=1;
	private int flightKey=1;
	private int managerKey=1;
	private int interFlightKey=1;  
	private String str = null;
	private String fileName = "data.txt";

	
	private HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();
	private HashMap<Integer, InternationalFlight> internationalFlights = new HashMap<Integer, InternationalFlight>();

	private HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();
	private HashMap<Integer, Manager> managers = new HashMap<Integer, Manager>();
	*/
	public void setCustomerKey(int value) {customerKey = value;}
	
	
}

