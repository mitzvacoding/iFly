package iFly;

import java.io.Serializable;
import java.util.HashMap;


@SuppressWarnings("serial")
public class DataObject implements Serializable{

	public HashMap<String, HashMap<Integer, Object>> ext;
		
	public DataObject()
	{
		this.ext = new HashMap<String, HashMap<Integer, Object>>();
	
	}
	 
	public HashMap<Integer, Object> put(String category) // new hash map for category entered;
	{
		HashMap<Integer, Object> hm = new HashMap<Integer, Object>();
		this.ext.put(category, new HashMap<Integer, Object>());
		return hm; 
	}    
	
	public HashMap<Integer, Object> get(String str) //getting a category, therefore a hashmap
	{
		return ext.get(str);
	}
	
	public Object putInternal(String category, int key, Object value)
	{
		ext.get(category).put(key, value);
		return value;
	}
	

	
	
	
}
