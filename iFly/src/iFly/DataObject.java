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
		
		//managers.put(1, new Manager("123", "123", "*1", 2));
		//customers.put(1,new Customer("123","123","123"));
		
		initKeys();
		
		
	}
	

	public void initKeys() 
	{
		flightKey = flights.size()+1;
		interFlightKey = internationalFlights.size()+1;
		
		customerKey = customers.size()+1;
		managerKey = managers.size()+1;
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
	}
		
	
	
		
	public void signUpCustomer(Customer cst)
	{
		customers.put(customerKey++, cst);		
	}
	
	
	// check user exists, called when user is logging-in.
	public boolean checkSignInCustomer(Customer cst)
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
	public int getFlightKey() {return flightKey;}
	public void setFlightKey(int key) {flightKey = key;}
	
	public int getInternationalFlightKey() {return interFlightKey;}
	
	
	public int getCustomerKey() {return customerKey;}
	public void setCustomerKey(int value) {customerKey = value;}
	
	public int getManagerKey() {return managerKey;}
	public void setManagerKey(int value) {managerKey = value;}
	
	
	public HashMap<Integer, Flight> getFlights(){return flights;}
	public void setFlights(HashMap<Integer, Flight> flights) {this.flights = flights;}
	
	public HashMap<Integer, InternationalFlight> getInternationalFlights(){return internationalFlights;}
	public void setInternationalFlights(HashMap<Integer, InternationalFlight> internationalFlights) {this.internationalFlights = internationalFlights;}
	
	public HashMap<Integer, Customer> getCustomers(){return customers;}
	public void setCustomers(HashMap<Integer, Customer> customers) {this.customers = customers;}
	
	public HashMap<Integer, Manager> getManagers(){return managers;}
	public void setManagers(HashMap<Integer, Manager> managers) {this.managers = managers;}
}

