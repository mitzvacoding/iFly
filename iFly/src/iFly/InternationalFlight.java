package iFly;

@SuppressWarnings("serial")
public class InternationalFlight extends Flight 
{

	private String destenation;

		
	public InternationalFlight()
	{
		super();
		this.destenation="any place";
		
	}

	public InternationalFlight(Date departureDate, Date landingDate,String origin, String landingAirport, String vendor,int price, int quantity, String flightId,String destenation)
	{
		super(departureDate, landingDate, origin, landingAirport,  vendor, price, quantity,flightId);
		this.setDestenation(destenation);
	}

	public InternationalFlight(Date departureDate,String origin, String destination) 
	{
		super();
		this.setDepartureDate(departureDate);
		this.setOrigin(origin);
		this.destenation=destination;
	}

	public int priceCalculation() {return 1;}

	public String getDestenation() 
	{
		return destenation;
	}

	public void setDestenation(String destenation) {
		this.destenation = destenation;
	}
	
	@SuppressWarnings("static-access")
	public  void print()
	    {
	    	System.out.println("Departure Date: "+ getDepartureDate().print() + "\nLanding Date: "+ getLandingDate().print());
	    	System.out.println("LandingAirport: "+getLandingAirport() + "\nVendor: "+getVendor() +"\nPrice: "+getPrice()+"$");
	    	System.out.println("Quantity: " + getQuantity() + "\nFlight ID: " + getFlightId()+"\nDestenation:"+ this.destenation);
        }
	 
	 
	 
}