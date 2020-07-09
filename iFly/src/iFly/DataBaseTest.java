package iFly;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class DataBaseTest extends TestCase
{

	DataObject dataObj;
	
	@Before 
	public void setUp()
	{
		 dataObj = new DataObject();
	}
	
	
	@Test
	public void addFlight()
	{
		Flight flt=new Flight(), actFlt; 
		dataObj.addObject(flt);
		
		ArrayList<Flight> arr = dataObj.searchFlight(flt, 1);
		actFlt = arr.get(1);
		
		assertEquals(flt, actFlt);
		
	}
	
	
	
	
	
}
