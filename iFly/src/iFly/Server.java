package iFly;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.LineBorder;

import UI.ResultPage;

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
	public static void requestSearchFlight(String depDate, String returnDate,String origin, String destination) 	
	{ 
		DataManagement.searchFlights(depDate, returnDate,origin, destination); 	
	}

	
	public static JTable requestConnectionFlightResults()
	{
		ArrayList<Flight> lastFlightResult = new ArrayList<Flight>();
		lastFlightResult = DataManagement.showFlightResult();
		
		JTable table = new JTable(3,10);
		
		table.setBounds(46, 336, 707, 90);
		table.setBackground(new Color(255, 250, 240));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		

		
		table.setValueAt("Dep. Date",0,0);
		table.setValueAt("quantity",0, 1);	
		table.setValueAt("vendor",0,2);
		table.setValueAt("Origin", 0, 3);
		table.setValueAt("Destination", 0, 4);
		table.setValueAt("Con.Land Date", 0, 5);
		table.setValueAt("Con. Airport", 0, 6);
		table.setValueAt("Con.Dep Date", 0, 7);
		table.setValueAt("Flight ID",0,8);
		table.setValueAt("Price", 0,9);
	
		table.setIntercellSpacing(new  Dimension(10,5));
		table.setRowHeight(30);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);//origin
		table.getColumnModel().getColumn(4).setPreferredWidth(50);//destination
		table.getColumnModel().getColumn(5).setPreferredWidth(50);//stop
		table.getColumnModel().getColumn(6).setPreferredWidth(40);//com.airport
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(33);//flight id
		table.getColumnModel().getColumn(9).setPreferredWidth(15);
		
		int row = 1, col=0;
		for(Flight flight: lastFlightResult)
		{
			if(ObjectsFactory.getClassName(flight).equals("ConnectionFlight"))
			{
				String destination = ObjectsFactory.getDestinationByFlight(flight);
				
				table.setValueAt(Date.print(flight.getDepartureDate()),row, col++);
				table.setValueAt(flight.getQuantity(),row, col++);
				table.setValueAt(flight.getVendor(),row, col++);
				table.setValueAt(flight.getOrigin(),row, col++);
				table.setValueAt(destination, row, col++);
				table.setValueAt(((ConnectionFlight)flight).getStopLandingDate(), row, col++);//land Date
				table.setValueAt(((ConnectionFlight)flight).getStopAirport(), row, col++);
				table.setValueAt(((ConnectionFlight)flight).getStopDepartureDate(), row, col++);
				table.setValueAt(flight.getFlightId(),row, col++);
				table.setValueAt(flight.getPrice()+"$",row, col++);//7
				row++;
				col = 0;
			}
		}
		return table;
	}
	
	
	
	
	
	public static JTable requestFlightResults()
	{
		ArrayList<Flight> lastFlightResult = new ArrayList<Flight>();
		lastFlightResult = DataManagement.showFlightResult();
		
				JTable ta = new JTable(6,7);
				ta.setColumnSelectionAllowed(true);
				ta.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ta.setBounds(47, 120, 706, 180);
				ta.setBackground(new Color(255, 250, 240));
				ta.setBorder(new LineBorder(new Color(0, 0, 0)));
				ta.setValueAt("Dep Date", 0, 0);
			    ta.setValueAt("quantity",0, 1);	
			    ta.setValueAt("vendor",0,2);
			    ta.setValueAt("Origin", 0, 3);
			    ta.setValueAt("Destination", 0, 4);
			    ta.setValueAt("Flight ID",0,5);
			    ta.setValueAt("Price", 0,6);
			
				ta.setIntercellSpacing(new  Dimension(10,5));
				ta.setRowHeight(30);	
		int row = 1, col=0;
		for(Flight flight: lastFlightResult)
		{
			if(!ObjectsFactory.getClassName(flight).equals("ConnectionFlight"))
			{
				String destination = ObjectsFactory.getDestinationByFlight(flight);
				ta.setValueAt(Date.print(flight.getDepartureDate()),row, col++);
				ta.setValueAt(flight.getQuantity(),row, col++);
				ta.setValueAt(flight.getVendor(),row, col++);
				ta.setValueAt(flight.getOrigin(),row, col++);
				ta.setValueAt(destination, row, col++);
				ta.setValueAt(flight.getFlightId(),row, col++);
				ta.setValueAt(flight.getPrice()+"$",row, col++);//7
				row++;
				col = 0;
			}
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
	
	   
  
	public static boolean requestremoveObj( String str,int quantity,String objName) 

    {
		if(DataManagement.removeObj(str,quantity,objName))
			return true;
		return false;
    }



	
};	
