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
/*
		//MainPage.UI_func();
		
		
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
*/
		
		//h1.put(1,"a");
		//h1.put(2,"b");
		//System.out.println(h1);
		
	
		File f = new File("C:\\Users\\Home\\desktop\\text.txt");
		
	    
	     Scanner myReader = new Scanner(f);

	      String data = myReader.nextLine();
	      System.out.println(data);
	      myReader.close();

	}
}
