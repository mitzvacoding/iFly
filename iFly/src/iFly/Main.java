package iFly;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import UI.MainPage;

public class Main {
	
	public static void main(String[] args) throws IOException
	{


		/*	

		//MainPage.UI_func();

		System.out.println("\n****FLIGHT******\n");
		
		Flight ff =new Flight( new Date(25,10,2020),new Date(25,10,2020),"Natbg","elal",100,25,12);
		ff.print();
		System.out.println("\n****InternationalFlight FLIGHT******\n");
		
		InternationalFlight in=new InternationalFlight(new Date(25,10,2000),new Date(25,11,2000),"Natbg","elal",200,3,141,"NY city"); 
		in.print();
		System.out.println("\n****ConnectionFlight FLIGHT******\n");
		
		ConnectionFlight cf=new ConnectionFlight(new Date(1,1,2020),new Date(07,1,2020),"Natbag air port","elal",500,12,747,"NY air port",new Date(02,1,2020),new Date(03,1,2020),"bangkok air port"); 
		cf.print();
		

		HashMap<Integer,String> h1 = new HashMap<Integer,String>();
		HashMap<Integer, Flight> h2 = new HashMap<Integer, Flight>();
		h2.put(1, new Flight());
		
		h2.get(1).print();
		

		HashMap<String,HashMap<Integer,Flight>> h3 = new HashMap<String,HashMap<Integer,Flight>>();
		
		h3.put("flights", new HashMap<Integer, Flight>());
		
		h3.get("flights").put(1, new Flight());
		

		Flight f1 = new Flight();
		System.out.println(f1.getClass());
		
		Class c1 = f1.getClass();
		HashMap<Integer, Class> a;

		
		//h1.put(1,"a");
		//h1.put(2,"b");
		//System.out.println(h1);
		
	
		File f = new File("C:\\Users\\Home\\desktop\\text.txt");
		
	    
	     Scanner myReader = new Scanner(f);

	      String data = myReader.nextLine();
	      System.out.println(data);
	      myReader.close();
*/
		String fileName = "C:\\Users\\Home\\Desktop\\try1.txt";
		ObjectOutputStream oos = null;
		/*
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		HashMap<Integer, String> hashObj = new HashMap<Integer,String>();
		hashObj.put(1, "first");
		hashObj.put(2, "second");
		hashObj.put(3, "troi");

		oos.writeObject(hashObj);
		*/
		//-----------------------------------------------
		
		
		
		ObjectInputStream ois =null;
		FileInputStream fis = new FileInputStream(fileName);
		HashMap<Integer, String> Iobj = null;
		
		ois = new ObjectInputStream(fis);
		
		try{
		Iobj = (HashMap<Integer, String>) ois.readObject();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(Iobj.toString());
		
		//Iobj.forEach("first");
		for(Map.Entry<Integer, String> entry: Iobj.entrySet())//entry is an iterator
		{
			if(entry.getValue().equals("second"))
				System.out.println(entry.getValue());
		}
		
		
		HashMap<String, HashMap<Integer, Object>> big;
		HashMap<Integer,Object> flight = new HashMap<Integer, Object>();
		HashMap<Integer,Object> user = new HashMap<Integer, Object>();
		HashMap<Integer,Object> manager = new HashMap<Integer, Object>();
		

		flight.put(1, new Flight());
		System.out.println(flight.toString());
		
		Object test = new Flight();
		System.out.println(test.getClass().getSimpleName());
		//oos.close();
		
	}
}
