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
		String fileName = "try1.txt";
		ObjectOutputStream oos = null;
		try 
		{
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		HashMap<Integer,Object> hashObj = new HashMap<Integer,Object>();
		hashObj.put(1,new Flight());
		//hashObj.put(2, "dd");//new Customer());
	//	hashObj.put(3, new Manger());
		oos.writeObject(hashObj);
	
	
		ObjectInputStream ois =null;
		FileInputStream fis = new FileInputStream(fileName);
		HashMap<Integer, String> Iobj = null;
		
		
		ois = new ObjectInputStream(fis);
		
		try {	Iobj = (HashMap<Integer,String>)ois.readObject();}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
			System.out.println(Iobj.toString());
	     }
	}