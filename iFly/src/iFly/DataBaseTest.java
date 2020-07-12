package iFly;


import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class DataBaseTest
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
		
		ArrayList<Flight> arr = dataObj.searchFlight(flt);
		
		actFlt = arr.get(0);
		assertEquals(flt, actFlt);
	}
	
	@Test
	public void addCustomer()
	{
		Customer cst = new Customer("ariel","uzi", "Email@hit.com");
		dataObj.signUpCustomer(cst);
		
		Boolean flag = dataObj.checkSignInCustomer(cst);
		assertTrue("Customer created succesfuly", flag);		
	}
	
}
