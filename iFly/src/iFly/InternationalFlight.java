package iFly;

public class InternationalFlight extends Flight {

	private String destenation;
	
	public int priceCalculation() {return 1;}
    
	public InternationalFlight(Date d,Date lD,String lA,String v,int p,int q,int fI,String destenation)
	{
		super(getFlightId(),getPrice(),getDep(),getLandAir(),getLandDate(),getQuantity(),getVen());
		this.destenation=destenation;
		
	
		
		
	}


}
