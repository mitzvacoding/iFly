package iFly;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DatabaseMetaData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import UI.MainPage;
import UI.ManagerPage;
import UI.RegistarPage;
import UI.ResultPage;
import UI.SearchPage;

@SuppressWarnings("unused")
public class Main 
{

	public static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();
	public static HashMap<Integer, Flight> flights = new HashMap<Integer, Flight>();
	
	public static void main(String[] args) throws IOException

	{
		// SearchPage.SpFun();
		DataBase.init();
		MainPage.MpFun(); 
		
	//ResultPage.ResFun();
	
		/*	
		Date depDate = new Date();
		Date returnDate = null;
		String origin = "TLV";
		String destination = "";
		String vendor = "ELAL";
		int price = 5;
		int quantity = 5;
		String flightId = "1";
		Boolean flag = true;
		Flight flt = ObjectsFactory.getFlightByButton(depDate, returnDate, origin, destination, vendor, price, quantity, flightId, flag);
		
		System.out.println(flt.toString());
		
	*/	
		//SearchPage.SpFun();
		//RegistarPage.RpFun();
		//enter2File();
		//readFromFile();
		
		//Flight flt = ObjectsFactory.getFlightByButton(new Date("11/11/1111"), new Date(""), "TLV", "");
		
		//System.out.println(ObjectsFactory.getClassName(flt).equals("Flight"));
				

	}
	
	
	public static void enter2File()
	{
		
		String fileName = "data.txt";
		String realPath = System.getProperty("user.dir");
		String p = realPath +"\\"+ fileName;
		
		
		//flights.put(1,new Flight());
		//flights.put(2,new Flight());
		
		customers.put(1, new Customer("123","123","123"));
		
		
		
		ObjectOutputStream oos = null;
		try{
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(customers);
			//oos.writeObject(flights);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void readFromFile()
	{
		try{
			String fileName = "data.txt";
			String realPath = System.getProperty("user.dir");
			String p = realPath +"\\"+ fileName;
			Path path = Paths.get(p);
			System.out.println(Files.exists(path));
			
			FileInputStream fis = new FileInputStream(p);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			customers = (HashMap<Integer,Customer>)ois.readObject();
			//flights = (HashMap<Integer,Flight>)ois.readObject();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(Customer cst : customers.values())
		{
			System.out.println(cst.toString());
		}
		
		
		for(Flight flt : flights.values())
		{
			System.out.println(flt.toString());
		}
		
	}
	//public static void func(Object cls)
	//{
	//	System.out.println(cls.getClass().getSimpleName());
	//}
	/*
	public static void enter2File()
	{
		
		String fileName = "data.txt";
		DataObject dObj = new DataObject();
		dObj.put("flights");
		dObj.putInternal("flights", 1, new Flight());
		dObj.put("customers");
		dObj.putInternal("customers", 5, new Customer());
		ObjectOutputStream oos = null;
		try{
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(dObj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static void readFromFile()
	{
		DataObject dObj =null;// new DataObject();
		try{
			FileInputStream fis = new FileInputStream("data.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			dObj = (DataObject)ois.readObject();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(dObj.get("flights").get(1).toString());
		System.out.println(dObj.get("customers").get(5).toString());
	}
*/
	}