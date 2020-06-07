package iFly;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import UI.MainPage;

public class Main {
	
	public static void main(String[] args) throws IOException
	{


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
		
/*
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

		
		//h1.put(1,"a");8
		//h1.put(2,"b");
		//System.out.println(h1);
		
	
		File f = new File("C:\\Users\\Home\\desktop\\text.txt");
		
	    
	     Scanner myReader = new Scanner(f);

	      String data = myReader.nextLine();
	      System.out.println(data);
	      myReader.close();
*/
	}
}
