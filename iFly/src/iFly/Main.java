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
	
	public static void main(String[] args) //throws IOException
	{
		
	/*	MainPage.UI_func();

		System.out.println("\n****FLIGHT******\n");
		
		Flight ff =new Flight( new Date(25,10,2020),new Date(25,10,2020),"Natbg","elal",100,25,12);
		ff.print();
		System.out.println("\n****InternationalFlight FLIGHT******\n");
		
		InternationalFlight in=new InternationalFlight(new Date(25,10,2000),new Date(25,11,2000),"Natbg","elal",200,3,141,"NY city"); 
		in.print();
		System.out.println("\n****ConnectionFlight FLIGHT******\n");
		
		ConnectionFlight cf=new ConnectionFlight(new Date(1,1,2020),new Date(07,1,2020),"Natbag air port","elal",500,12,747,"NY air port",new Date(02,1,2020),new Date(03,1,2020),"bangkok air port"); 
		cf.print();
   
	*/
		
		
		HashMap<Integer,Object> h1 = new HashMap<Integer,Object>();
		
		h1.put(11,new Flight());
		h1.put(21,new Customer());
		h1.put(31,new Manger());
		System.out.println(h1.get(11).toString()); 
		System.out.println(h1.get(21).toString()); 
		System.out.println(h1.get(31).toString()); 
		
		
	}
	
}


