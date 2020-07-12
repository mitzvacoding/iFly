package iFly;

public class ObjectsFactory {

	public static Flight getFlightByButton(Date depDate,Date returnDate,String origin,String destination,String vendor,int price,int quantity,String flightId, boolean flag) //Integer abroadType ,Integer roundTripType)
	{
		Flight flt = null;
		
		
		if(returnDate!=null)
		{
			if(origin.equals("ELT") || origin.equals("TLV"))
				flt = new RoundTripFlight(new Flight(depDate,origin), new Flight(returnDate,destination));
			else
				flt = new RoundTripFlight(new InternationalFlight(depDate,origin, destination),new InternationalFlight(returnDate,destination,origin));
		}
		else
		{
			if(destination.isBlank())
				flt =new Flight(depDate,origin);  
			else
				flt =new InternationalFlight(depDate,origin, destination);	
		
		}

		if(flag)
		{
			
			flt.setVendor(vendor);
			flt.setPrice(price);
			flt.setQuantity(quantity);
			flt.setFlightId(flightId);
		}
		
		return flt;
	}
	
	public static String getDestinationByFlight(Flight flight)
	{
		String destination;
		if(getClassName(flight).equals("Flight"))
		{
			if(flight.getOrigin().equals("TLV"))
				destination = "ELT";
			else
				destination = "TLV";
		}
		else
			destination = ((InternationalFlight)flight).getDestenation();
		
		return destination;
		
	}
	
	public static String getClassName(Object obj)
	{
		return obj.getClass().getSimpleName();
	}
}

