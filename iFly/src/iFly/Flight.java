package iFly;
import java.io.Serializable;

import org.junit.Test;


@SuppressWarnings({ "unused", "serial" })
public class Flight implements Serializable
{
	
	private Date departureDate;
	private Date landingDate; 	
	private String origin;
  	private String vendor;
    private int price;
    private int quantity;
    private String flightId;
    public static int num;
   
    
    public Flight()
    {
     	this. departureDate = new Date(); 
    	this.landingDate = new Date();
    	this.vendor = "";
    	this.price  = 0;
    	this.quantity = 0;
    	this.flightId = " ";
    }
    
    
    
    public Flight(Date departureDate, Date landingDate, String origin, String vendor, int price, int quantity, String flightId)
    {
    	this.departureDate = departureDate;
    	this.landingDate = landingDate;
    	this.origin = origin;
    	this.vendor = vendor;
    	this.price  = price;
    	this.quantity = quantity;
    	this.flightId = flightId;
    }

   
	public Flight(Date departureDate,String origin)
	{
		
    	this.departureDate = departureDate;
    	this.origin = origin;
    	this.landingDate = null;

		
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
	
	public String getOrigin()
	{
		return origin;
	}
	
	public void setOrigin(String origin)
	{
		this.origin = origin;
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
	 

	 public int getQuantity()
	 {
		 return this.quantity;
	 }

	 public void setQuantity(int q)
	 {
		  this.quantity=q;
	 }
	

	 public String getFlightId() {return this.flightId;}
	   
	 
	 @Override
	 public String toString()
	 {
		String str =  "Departure Date: "+ this.departureDate.toString()+ "\nLanding Date: "+ this.landingDate.toString();
		str += "\nVendor: "+this.vendor +"\nPrice: "+this.price+"$";
		str += "\nQuantity: " + this.quantity + "\nFlight ID: " + this.flightId;
		return str;
	 }
	 
	    public void print()
	    {
	    	System.out.println("Departure Date: "+ this.departureDate.toString()+ "\nLanding Date: "+ this.landingDate.toString());
	    	System.out.println("Vendor: "+this.vendor +"\nPrice: "+this.price+"$");
	    	System.out.println("Quantity: " + this.quantity + "\nFlight ID: " + this.flightId);
	    }
	   	    
}