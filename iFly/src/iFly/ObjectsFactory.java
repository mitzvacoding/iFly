package iFly;

public class ObjectsFactory {

	public static Flight getFlightByButton(Date depDate,Date returnDate,String origin, String destination) //Integer abroadType ,Integer roundTripType)
	{
		Flight flt = null;
		
		
		if(returnDate!=null)
		{
			if(origin.equals("ELT") || origin.equals("TLV"))
				flt = new RoundTripFlight(new Flight(depDate,origin), new Flight(depDate,destination));

			else
				flt = new RoundTripFlight(new InternationalFlight(depDate,origin, destination),new InternationalFlight(returnDate, destination, origin));
		}
		
		else
		{
			if(origin.equals("ELT") || origin.equals("TLV"))
				flt =new Flight(depDate,origin);
			else
				flt =new InternationalFlight(depDate,origin, destination);	
		
		}

		
		return flt;
	}
	
	public static String getDestinationByFlight(Flight flight)
	{
		String destination;
		if(Flight.class.getClass().getSimpleName().equals("Flight"))
		{
			if(flight.getOrigin() == "TLV")
				destination = "ELT";
			else
				destination = "TLV";
		}
		else
			destination = ((InternationalFlight)flight).getDestenation();
		
		return destination;
		
	}
}

