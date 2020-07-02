package iFly;
import java.io.Serializable;

import org.junit.Test;

public class Flight implements Serializable
{
	
	private Date departureDate;
	private Date landingDate; 				//*** ??צריך את זה ***//
	private String landingAirport;
  	private String vendor;
    private int price;
    private int quantity;
    private String flightId;
    public static int num;
   
    
    public Flight()
    {
     	this. departureDate = new Date(); 
    	this.landingDate = new Date();
    	this.landingAirport = "ELT";
    	this.vendor = "";
    	this.price  = 0;
    	this.quantity = 0;
    	this.flightId = " ";
    }
    
    
    
    public Flight(Date departureDate, Date landingDate,String landingAirport, String vendor, int price, int quantity, String flightId)
    {
    	this.departureDate = departureDate;
    	this.landingDate = landingDate;
    	this.landingAirport = "ELT";
    	this.vendor = vendor;
    	this.price  = price;
    	this.quantity = quantity;
    	this.flightId = flightId;
    }

   
	public Flight(Date departureDate, String landingAirport)
	{
    	this.departureDate = departureDate;
    	this.landingDate = null;
    	this.landingAirport ="ELT";

		
	}

	public Flight(Date depDatenew, Date landDate, String landAirport, String vendor, String price, String quantity,	String flightId) 
	{
		
		this.departureDate = departureDate;
    	this.landingDate = landingDate;
    	this.landingAirport ="ELT";
    	this.vendor = vendor;
    	this.price  = (price.charAt(0)-'0')*100 +(price.charAt(1)-'0')*10+ (price.charAt(2)-'0'); //Price includes 3 digits
    	this.quantity = (quantity.charAt(0)-'0'); //quantity   includes 1 digits
    	this.flightId = flightId;

	}


	

	public int priceCalculation() {return 1;}

	
	
	public Date getDepartureDate()
	{
	return  this.departureDate;
	}
	
	public void setDepartureDate(Date d)
	{
	 this.departureDate=d;
		
	}
	
	
	public Date getLandingDate()
	{
	return  this.landingDate;
	}
	
	public String getLandingAirport()
	{
	return  this.landingAirport;
	}
	 
	public String getVendor()
	{
	return  this.vendor;
	}
	
	 public int getPrice() {
		 return this.price;
	 }
	 public void setPrice(int p)
	 {
		 this.price=p;
	 }
	 
	 public int getQuantity() {return this.quantity;}
	
	 public String getFlightId() {return this.flightId;}
	   
	 
	 @Override
	 public String toString()
	 {
		String str =  "Departure Date: "+ this.departureDate.print()+ "\nLanding Date: "+ this.landingDate.print();
		str += "\nLandingAirport: "+this.landingAirport + "\nVendor: "+this.vendor +"\nPrice: "+this.price+"$";
		str += "\nQuantity: " + this.quantity + "\nFlight ID: " + this.flightId;
		return str;
	 }
	 
	    public void print()
	    {
	    	System.out.println("Departure Date: "+ this.departureDate.print()+ "\nLanding Date: "+ this.landingDate.print());
	    	System.out.println("LandingAirport: "+this.landingAirport + "\nVendor: "+this.vendor +"\nPrice: "+this.price+"$");
	    	System.out.println("Quantity: " + this.quantity + "\nFlight ID: " + this.flightId);
	    }
	   	    
}