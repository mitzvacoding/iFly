package iFly;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class Server 
{
	
	 
	// check if details appears in DB;
	public static boolean requestSignInCustomer(String email,String password)
	{
		if(DataManagement.SignInCustomer(email,password))
			return true;
		else 
			return false; 
	};
	  
 
	public static boolean requestSignInManager(String email,String password)
	{
		if(DataManagement.SignInManager(email,password))
			return true;
		else 
			return false; 
	};  
	 

	public static boolean signUpCustomer(String name, String email, String password) 
	{
		return DataManagement.signUpCustomer(name, email, password);	
	}
	
	
	 
	// Search flight
	public static void requestSearchFlight(String depDate, String returnDate,String origin, String destination, int passengers) 	
	{ 
		Flight f=null;
      
		DataManagement.searchFlights(depDate, returnDate,origin, destination, passengers); 
		
		/* there's no need to check, because it's being checked in DataBase.
		if( f.getClass().getSimpleName()=="RoundTripFlight")
			DataManagement.searchRoundFlights(f,passengers);
		else
			DataManagement.searchFlights(f,passengers);
		*/
	}

	public static JTable requestFlightResults()
	{
		ArrayList<Flight> lastFlightResult = new ArrayList<Flight>();
		lastFlightResult = DataManagement.showFlightResult();
		
	    JTable ta = new JTable(6,7);
		ta.setColumnSelectionAllowed(true);
		ta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ta.setBounds(0, 217, 556, 180);
		
		ta.setBackground(new Color(255, 250, 240));
		ta.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta.setValueAt("Dep Date", 0, 0);
	    ta.setValueAt("Return Date",0, 1);	
	    ta.setValueAt("vendor",0,2);
	    ta.setValueAt("Origin", 0, 3);
	    ta.setValueAt("Destination", 0, 4);
	    ta.setValueAt("Flight ID",0,5);
	    ta.setValueAt("Price", 0,6);
	
		ta.setIntercellSpacing(new  Dimension(10,5));
		ta.setRowHeight(40);
		//ta.set
				
		int row = 1, col=0;
		for(Flight flight: lastFlightResult)
		{
			String destination = ObjectsFactory.getDestinationByFlight(flight);
			//System.out.println(flight);
			ta.setValueAt(Date.print(flight.getDepartureDate()),row, col++);

			if(ObjectsFactory.getClassName(flight).equals("RoundTripFlight"));//needs to be implemented
			
			else
				ta.setValueAt("NA",row, col++);
			

			ta.setValueAt(flight.getVendor(),row, col++);
			ta.setValueAt(flight.getOrigin(),row, col++);
			ta.setValueAt(destination, row, col++);
			ta.setValueAt(flight.getFlightId(),row, col++);
			ta.setValueAt(flight.getPrice(),row, col++);//7
			row++;
			col = 0;

		}
		
		return ta;
	}
	
	
	
	
	// add Flight or Customer;
	public static boolean requestAddObject(String depDate,String landDate,String origin,String destenation,String vendor,int price,int quantity,String flightId) 
	{
		if(DataManagement.addFlight(depDate,landDate,origin,destenation,vendor,price,quantity,flightId))
			return true;
			
		return false;
	};
	
	   
  
	public static boolean requestremoveObj( String str,String objName) 

    {
		if(DataManagement.removeObj(str,objName))
			return true;
		return false;
    }



	
};	
