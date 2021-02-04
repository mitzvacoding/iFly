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
	
	public static boolean removeObj(String str,int quantity,String objName){return dataObj.removeObj(str,quantity,objName);}
	
	public static boolean addObject(Flight flt) {return dataObj.addObject(flt);}
	
	public static Boolean findExistFlight(Flight flt) {return dataObj.findExistFlight(flt);}
	
	public static boolean checkSignInManager(String email,String password) {return dataObj.checkSignInManager(email, password);}
	
	public static boolean checkSignInCustomer(Customer cst) {return dataObj.checkSignInCustomer(cst);}
	
	public static void signUpCustomer(Customer cst) {dataObj.signUpCustomer(cst);}
	
	//public static void searchRoundTripFlight(Object f,int passengers) {dataObj.searchRoundTripFlight(f, passengers);}
	
	public static void addFlights(HashMap<Integer, Flight> addedFlights) {dataObj.addFlights(addedFlights);}
	
	public static ArrayList<Flight> searchFlight(Flight f)
	{
		return dataObj.searchFlight(f);	
	}
	



	
	public static void init()  
	{		
		
		dataObj = new DataObject();
		readFromFile();
		dataObj.initKeys();		
		
		int managerKey = dataObj.getManagerKey();
		dataObj.getManagers().put(managerKey++, new Manager("ariel", "ariel@hit.com", "*123", 2));
		
		int customerKey = dataObj.getCustomerKey();
		dataObj.getCustomers().put(customerKey++, new Customer("123","123","123"));
		
		int connectionFlightKey = dataObj.getConnectionFlightKey();
		dataObj.getConnectionFlights().put(connectionFlightKey++, new ConnectionFlight(new Date("13/07/2020"), new Date("14/07/2020"), "TLV","BCN","Arkia",150,2,"312", new Date("13/07/2020"),new Date("14/07/2020"),"LON" ));
		
		dataObj.getConnectionFlights().put(connectionFlightKey++, new ConnectionFlight(new Date("13/07/2020"), new Date("14/07/2020"), "TLV","BCN","Turkish",170,5,"566", new Date("13/07/2020"),new Date("14/07/2020"),"TUR" ));

		dataObj.setConnectionFlightKey(connectionFlightKey);
		dataObj.setCustomerKey(customerKey);
		dataObj.setManagerKey(managerKey);	
		
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
	
	@SuppressWarnings(value = "unchecked")
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

