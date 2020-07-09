package iFly;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoundTripFlight extends InternationalFlight implements Serializable
{	
	private Flight forthFlight, backFlight;
	
	public RoundTripFlight(InternationalFlight inFlight, InternationalFlight inFlight2)
	{
		
	/*	super(inFlight.getDepartureDate(),inFlight.getLandingDate(),inFlight.getLandingAirport()
			,inFlight.getVendor(),inFlight.getPrice(),inFlight.getQuantity(),inFlight.getFlightId(),inFlight.getDestenation());
		
				
		this.returnDate=inFlight2.getDepartureDate();
		
		super(inFlight2.getDepartureDate(),inFlight2.getLandingDate(),inFlight2.getLandingAirport()
				,inFlight2.getVendor(),inFlight2.getPrice(),inFlight2.getQuantity(),inFlight2.getFlightId(),inFlight2.getDestenation());
			
		*/	
		
		
		
	}

	public RoundTripFlight(Flight flight, Flight flight2) {
		// TODO Auto-generated constructor stub
	}

	public int priceCalculation() {return 1;}
	
	
	
	
	
}


