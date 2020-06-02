package iFly;

public class Flight 
{
	private  Date 	departureDate;
	private  Date 	landingDate;
    private  String landinAairport;
  	private String 	vendor;
    private int 	price;
    private int 	quantity;
    private int 	flightId;
   
	public int priceCalculation() {return 1;}

	
	public Date getDep()
	{
	return  this.departureDate;
	}
	public Date getLandDate()
	{
	return  this.landingDate;
	}
	
	public String getLandAir()
	{
	return  this.landinAairport;
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

