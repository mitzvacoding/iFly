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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import UI.MainPage;
import UI.RegistarPage;
import UI.SearchPage;

public class Main {
	public static int convertString(String str)
	{
		int size= str.length();
		int num=0;
		for(int i= 0; i<size ; i++)
		{
			num += (str.charAt(i)-'0') * Math.pow(10, size - i-1);
		}
		return num;
	}
	public static void main(String[] args) throws IOException

	{
		//MainPage.MpFun();
		//SearchPage.SpFun();
		String fileName = "try1.txt";
		ObjectOutputStream oos = null;
		int x = convertString("45123");

		System.out.println(x);
		//enter2File();
		//readFromFile();
	}
	
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

	}