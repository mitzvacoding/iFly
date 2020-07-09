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
	public static DataObject dataObj;
	private static String fileName = "data.txt";
	
	public static boolean removeObj(String str,String objName){return dataObj.removeObj(str, objName);}
	public static boolean addObject(Flight flt) {return dataObj.addObject(flt);}
	public static Boolean findExistFlight(Flight flt) {return dataObj.findExistFlight(flt);}
	public static boolean checkSignInManager(String email,String password) {return dataObj.checkSignInManager(email, password);}
	public static boolean checkSignInCustomer(Customer cst) {return dataObj.checkSignInCustomer(cst);}
	public static void signUpCustomer(Customer cst) {dataObj.signUpCustomer(cst);}
	public static void searchRoundTripFlight(Object f,int passengers) {dataObj.searchRoundTripFlight(f, passengers);}
	public static void addFlights(HashMap<Integer, Flight> addedFlights) {dataObj.addFlights(addedFlights);}
	public static ArrayList<Flight> searchFlight(Flight f,int passengers){return dataObj.searchFlight(f, passengers);}



	
	public static void init()  
	{		
		dataObj = new DataObject();
		readFromFile();
		
		int managerKey = dataObj.getManagerKey();
		dataObj.getManagers().put(managerKey++, new Manager("123", "123", "*1", 2));
		
		int customerKey = dataObj.getCustomerKey();
		dataObj.getCustomers().put(customerKey++, new Customer("123","123","123"));
		
		dataObj.setCustomerKey(customerKey);
		dataObj.setManagerKey(managerKey);
		
		//managers.put(1, new Manager("123", "123", "*1", 2));
		//customers.put(1,new Customer("123","123","123"));
		
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
			oos.writeObject(dataObj.getFlights());
			oos.writeObject(dataObj.getInternationalFlights());
			oos.writeObject(dataObj.getCustomers());
			oos.writeObject(dataObj.getManagers());
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
				
				dataObj.setFlights( (HashMap<Integer,Flight>)ois.readObject() );
				dataObj.setInternationalFlights((HashMap<Integer,InternationalFlight>)ois.readObject());

				dataObj.setCustomers((HashMap<Integer,Customer>)ois.readObject());
				dataObj.setManagers((HashMap<Integer,Manager>)ois.readObject());	
				
				ois.close();
				fis.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


}

