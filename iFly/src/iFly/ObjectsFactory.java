package iFly;

public class ObjectsFactory {

	public static Flight getFlightByButton(Date depDate,Date returnDate,String origin, String destination) //Integer abroadType ,Integer roundTripType)
	{
		Flight flt = null;
		
		
		if(returnDate!=null)
		{
			if(origin.equals("ELT") || origin.equals("TLV"))
				flt = new RoundTripFlight(new Flight(depDate,origin, ""), new Flight(depDate,destination, ""));

			else
				flt = new RoundTripFlight(new InternationalFlight( depDate, destination),new InternationalFlight(returnDate, destination));
		}
		
		else
		{
			if(origin.equals("ELT") || origin.equals("TLV"))
				flt =new Flight(depDate,origin, "ELT");
			else
				flt =new InternationalFlight(depDate,origin, "ELT");	
		
		}

		
		return flt;
	}
}

