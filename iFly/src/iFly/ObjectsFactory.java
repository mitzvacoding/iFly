package iFly;

public class ObjectsFactory {

	public static Object getFlightByButton(Date depDate,Date returnDate,String destination) //Integer abroadType ,Integer roundTripType)
	{
		Object obj = null;
		
		
		if(returnDate!=null)
		{
			if(destination!=null)
				obj =new RoundTripFlight(new InternationalFlight( depDate, destination),new InternationalFlight(returnDate, destination));
			else
				obj =new RoundTripFlight(new Flight(depDate,"ELT"),new Flight(returnDate, "TLV"));
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

