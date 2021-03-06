package iFly;

import java.io.Serializable;

public class InternationalFlight extends Flight implements Serializable
{
	private static final long serialVersionUID = -7937976656848651896L;
	private String destenation;

		
	public InternationalFlight()
	{
		super();
		this.destenation="any place";
		
	}  

	public InternationalFlight(Date departureDate, Date landingDate,String origin,String destenation, String vendor,int price, int quantity, String flightId)
	{
		super(departureDate, landingDate, origin,  vendor, price, quantity,flightId);
		this.setDestenation(destenation);
	}

	public InternationalFlight(Date departureDate,String origin, String destination) 
	{
		super();
		this.setDepartureDate(departureDate);
		this.setOrigin(origin);
		this.destenation = destination;
	}

	public int priceCalculation() {return 1;}

	public String getDestenation() 
	{
		return destenation;
	}

	public void setDestenation(String destenation) {
		this.destenation = destenation;
	}
	
	@Override
	public  void print()
	    {
	    	System.out.println("Departure Date: "+ getDepartureDate().print() + "\nLanding Date: "+ getLandingDate().print());
	    	System.out.println("Vendor: "+getVendor() +"\nPrice: "+getPrice()+"$");
	    	System.out.println("Quantity: " + getQuantity() + "\nFlight ID: " + getFlightId()+"\nDestenation:"+ this.destenation);
        }
	 
	 
	 
}