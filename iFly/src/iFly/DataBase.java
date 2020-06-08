package iFly;
import java.util.List;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class DataBase {
	
	public static HashMap<String, HashMap<Integer, Object>> big;
	public static HashMap<String,String> files;
	
	public static void init()
	{
		big = new HashMap<String, HashMap<Integer, Object>>();
		big.put("flights", new HashMap<Integer, Object>());
		big.put("customer", new HashMap<Integer, Object>());

		files = new HashMap<String,String>();
	}
	
	
	public void addObject(String mapName, Object obj)
	{//need to implement factory	
		//big.get(obj.getClass().getSimpleName()).put(1, )

	}
	
	
	
	
	
	
	private static void createFile(String fileName)
	{
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private HashMap<String,HashMap<Integer,Class>> DB;
	
	public void createMap(String map)
	{
		DB.put(map, new HashMap<Integer, Class>());
	}

	public void insert(String map, int index, Class cls) 
	{
		DB.get(map).put(index, cls);
	}
}

