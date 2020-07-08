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
	
	public static DataObject big=new DataObject();
	public static HashMap<String,String> files;
	public static int customerKey=0;
	public static int flightKey=0;
	public static int managerKey=0;
	public static int interFlightKey=0;  
	public static String str = null;
	public static String fileName = "data.txt";

	
	public static HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();
	public static HashMap<Integer, InternationalFlight> internationalFlights = new HashMap<Integer, InternationalFlight>();

	public static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();
	public static HashMap<Integer, Manager> managers = new HashMap<Integer, Manager>();
	


	
	public static void init()
	{	
    
		managers.put(1, new Manager("123", "123", "*1", 2));
		customers.put(1,new Customer("123","123","123"));
		//customers.put(2,new Customer("321","321","321"));
			
		//flights.put(flightKey++, new Flight(new Date("14/07/1996"), new Date("16/07/1996"), "TLV","", "1",2, 3,"4"));
		//internationalFlights.put(flightKey++, new InternationalFlight(new Date("14/07/1996"),"TLV", "USA"));
		//internationalFlights.put(flightKey++, new InternationalFlight(new Date("25/11/1996"),"USA", "USB"));
		 
		//writeToFile();
		readFromFile();
		
		
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
			//oos.write
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
		
		else if(f.getClass().getSimpleName().equals("Flight")) //Object f= Flight;
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

	
	public static Integer findFlight(Object obj)
	{
		if(obj.getClass().getSimpleName()=="Flight")
		{
			for(Flight flight: flights.values())
		{
			if( flight.getFlightId().equals(((Flight) obj).getFlightId()  ) ) {
				flight.setQuantity(flight.getQuantity()+((Flight) obj).getQuantity());
			    return 1;
			    }}}
		
		else
		{
			for(InternationalFlight flight: internationalFlights.values())
			{
				if( flight.getFlightId().equals(((InternationalFlight) obj).getFlightId()  ) ) {
					flight.setQuantity(flight.getQuantity()+((InternationalFlight) obj).getQuantity());
				    return 1;
				    }}}
		
		
		return null;
	}
	
	
	
	
	public static boolean addObject(Object obj)
	{
				
			if(findFlight(obj)==null)
	
			{
				flights.put(flightKey++,(Flight) obj);
				return true;
			}
			else if(findFlight(obj)==null)
			{ 
				internationalFlights.put(interFlightKey++, (InternationalFlight) obj);
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
	
	
	
	
	
	
	@SuppressWarnings("unused")
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

