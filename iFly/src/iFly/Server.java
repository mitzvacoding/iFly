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
	public static void requestSearchFlight(Date depDate, Date returnDate,String origin, String destination, int passengers, Integer abroadFlight, Integer roundTrip) 	
	{ 
		Flight f=null;
      
		f=(Flight)ObjectsFactory.getFlightByButton(depDate, returnDate,origin, destination);

		DataManagement.searchFlights(f, passengers);
		
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
		
	    JTable ta = new JTable(10,6);
		ta.setColumnSelectionAllowed(true);
		ta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ta.setBounds(0, 185, 556, 300);
		ta.setBackground(new Color(255, 250, 240));
		ta.setBorder(new LineBorder(new Color(0, 0, 0)));
		ta.setValueAt("Dep Date", 0, 0);
	    ta.setValueAt("Land Date",0, 1);	
	    ta.setValueAt("vendor",0,2);
	    ta.setValueAt("Air port", 0, 3);
	    ta.setValueAt("Flight ID",0,4);
	    ta.setValueAt("Price", 0,5);
		
		ta.setIntercellSpacing(new  Dimension(5,5));
		ta.setRowHeight(30);
				
		int row = 1, col=0;
		for(Flight flight: lastFlightResult)
		{
			ta.setValueAt(Date.print(flight.getDepartureDate()),row, col++);
			ta.setValueAt(Date.print(flight.getLandingDate()),row, col++);
			ta.setValueAt(flight.getVendor(),row, col++);
			ta.setValueAt(flight.getLandingAirport(),row, col++);
			ta.setValueAt(flight.getFlightId(),row, col++);
			ta.setValueAt(flight.getPrice(),row, col++);
			row++;
			col = 0;

		}
		
		return ta;
	}
	
	
	
	
	// add Flight or Customer;
	public static boolean requestAddObject(Object obj) 
	{
			if(DataManagement.addObject(obj))
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
