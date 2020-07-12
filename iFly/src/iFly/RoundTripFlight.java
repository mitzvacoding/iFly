package iFly;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RoundTripFlight extends InternationalFlight implements Serializable
{	
	private Flight forthFlight, backFlight;
	
	public RoundTripFlight(InternationalFlight  forthFlight, InternationalFlight backFlight)
	{
		
	}

	public RoundTripFlight(Flight flight, Flight flight2) {
		// TODO Auto-generated constructor stub
	}

	public int priceCalculation() {return 1;}
	
	
	
	
	
}


