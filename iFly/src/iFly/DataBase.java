package iFly;
import java.util.List;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class DataBase {
	
	//private LinkedList<HashMap<Integer,Flight>> fligtsList;
	//private LinkedList<HashMap<Integer,Flight> > usersList;
	public static HashMap<String,FileOutputStream> files;
	
	public static void init()
	{
		files = new HashMap<String,FileOutputStream>();
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
		
		//files.put(fileName,newFile );
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