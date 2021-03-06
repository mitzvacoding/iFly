package iFly;


public class ConnectionFlight extends InternationalFlight
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	Date stopLandingDate;
	private Date stopDepartureDate;
	private String stopAirport; 	
   
	
	public ConnectionFlight()
	{
		super();
	
		this.stopDepartureDate=new Date();
		this.stopLandingDate=new Date();
		this.stopAirport= "any place";	
	}
	
	
	public ConnectionFlight(Date departureDate, Date landingDate,String origin ,String destination,String vendor, int price, int quantity
							,String flightId,Date stopLandingDate,Date stopDepartureDate,String stopAirport) 	
   
	{
		super(departureDate,landingDate,origin,destination, vendor, price, quantity,flightId);
		this.setStopAirport(stopAirport);
		this.setStopLandingDate(stopLandingDate);
		this.setStopDepartureDate(stopDepartureDate);
		
	}

	public Date getStopLandingDate() {
		return stopLandingDate;
	}

	public void setStopLandingDate(Date stopLandingDate) {
		this.stopLandingDate = stopLandingDate;
	}

	public Date getStopDepartureDate() {
		return stopDepartureDate;
	}

	public void setStopDepartureDate(Date stopDepartureDate) {
		this.stopDepartureDate = stopDepartureDate;
	}

	public String getStopAirport() {
		return stopAirport;
	}

	public void setStopAirport(String stopAirport) {
		this.stopAirport = stopAirport;
	}

	public int priceCalculation() {return 1;}
	
	@Override
	public  void print()  
	{
		System.out.println("Departure Date: "+ getDepartureDate().print() + "\nLanding Date: "+ getLandingDate().print());
	   	System.out.println("Vendor: "+getVendor() +"\nPrice: "+getPrice()+"$");
	   	System.out.println("Quantity: " + getQuantity() + "\nFlight ID: " + getFlightId()+"\nDestenation: "+ getDestenation());
	   	System.out.println("stopLandingDate:"+this.stopLandingDate.print()+ "\nstopDepartureDate:"+this.stopDepartureDate.print()+"\nstopAirport:"+this.stopAirport);
	}
	   
	
	
}
