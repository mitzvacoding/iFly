package iFly;

public class ObjectsFactory {

	public static Flight getFlightByButton(Date depDate,Date returnDate,String origin, String destination) //Integer abroadType ,Integer roundTripType)
	{
		Flight obj = null;
		
		
		if(returnDate!=null)
		{
			if(origin.equals("ELT") || origin.equals("TLV"))
				obj =new RoundTripFlight(new Flight(depDate,origin, " "), new Flight(depDate,destination, " "));

			else
				obj =new RoundTripFlight(new InternationalFlight( depDate, destination),new InternationalFlight(returnDate, destination));
		}
		
		else
		{
			if(destination!=null)
				obj =new InternationalFlight(depDate, destination);
			else
				obj =new Flight(depDate, "ELT");	
		
		}

		
		return obj;
	}
}

