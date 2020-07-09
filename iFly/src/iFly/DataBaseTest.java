package iFly;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class DataBaseTest extends TestCase
{

	public static HashMap<Integer, Flight>  flights;
	
	@Before 
	public void setUp()
	{
		 flights = new HashMap<Integer, Flight>();	
	}
	
	
	@Test
	public void addFlight()
	{
		Flight flt=new Flight(); 
		
	//	flights.put(key, value)
	}
	
	
	
	
	
}
