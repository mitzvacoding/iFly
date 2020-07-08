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
		 
		DataBase.init();
		MainPage.MpFun();
		
		//SearchPage.SpFun();
		
		//enter2File();
		//readFromFile();
		
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