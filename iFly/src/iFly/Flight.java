package iFly;

public class Flight 
{
	private Date departureDate;
	private Date landingDate;
	private String landingAirport;
  	private String vendor;
    private int price;
    private int quantity;
    private int flightId;
    public static int num;
    
    public Flight()
    {
     	this. departureDate = new Date();
    	this.landingDate = new Date();
    	this.landingAirport = "";
    	this.vendor = "";
    	this.price  = 0;
    	this.quantity = 0;
    	this.flightId = 0;
    }
    
    public Flight(Date departureDate, Date landingDate,String landingAirport, String vendor, int price, int quantity, int flightId)
    {
    	this. departureDate = departureDate;
    	this.landingDate = landingDate;
    	this.landingAirport = landingAirport;
    	this.vendor = vendor;
    	this.price  = price;
    	this.quantity = quantity;
    	this.flightId = flightId;
    }
    
    public void print()
    {
    	System.out.println("Departure Date: "+ this.departureDate.print()+ "\nLanding Date: "+ this.landingDate.print());
    	System.out.println("LandingAirport: "+this.landingAirport + "\nVendor: "+this.vendor +"\nPrice: "+this.price);
    	System.out.println("Quantity: " + this.quantity + "\nFlight ID: " + this.flightId);
    }
   
	public int priceCalculation() {return 1;}

	
	public Date getDep()
	{
	return  this.departureDate;
	}
	public Date getLandDate()
	{
	return  this.landingDate;
	}
	
	public String getLandingAirport()
	{
	return  this.landingAirport;
	}
	public String getVen()
	{
	return  this.vendor;
	}
	
	 public int getPrice() {
		 return this.price;
	 }
	    public int getQuantity() {return this.quantity;}
	    public int getFlightId() {return this.flightId;}
	   
	
}

