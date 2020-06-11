package iFly;

public class ObjectsFactory {

	public static Object getFlightByButton(Date returnDate,String destination)//Integer abroadType ,Integer roundTripType)
	{
		Object obj = null;
		
		
		if(returnDate!=null)
		{
			if(destination!=null)
				obj =new RoundTripFlight(new InternationalFlight( returnDate, destination),new InternationalFlight(returnDate, destination));
			else
				obj =new RoundTripFlight(new Flight( returnDate, destination),new Flight(returnDate, destination));
		}
		
		else
		{
			if(destination!=null)
				obj =new InternationalFlight( returnDate, destination);
			else
				obj =new Flight();	
			
		}

		
		
		
		
		return obj;
	}
}

