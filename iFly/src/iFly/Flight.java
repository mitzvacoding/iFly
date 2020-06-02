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
    
    private void print()
    {
    	this.departureDate.print();
    	this.landingDate.print();
    	System.out.println(this.landingAirport + this.vendor +this.price + this.quantity + this.flightId);
    
    }
   
	public int priceCalculation() {return 1;}

	
}
