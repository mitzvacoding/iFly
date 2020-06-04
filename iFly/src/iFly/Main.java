package iFly;
//import java.util.HashMap;

import UI.MainPage;

public class Main {
	
	public static void main(String[] args)
	{

		MainPage.UI_func();
		
		System.out.println("\n****FLIGHT******\n");
		
		Flight ff =new Flight( new Date(25,10,2020),new Date(25,10,2020),"Natbg","elal",100,25,12);
		ff.print();
		System.out.println("\n****InternationalFlight FLIGHT******\n");
		
		InternationalFlight in=new InternationalFlight(new Date(25,10,2000),new Date(25,11,2000),"Natbg","elal",200,3,141,"NY city"); 
		in.print();
		System.out.println("\n****ConnectionFlight FLIGHT******\n");
		
		ConnectionFlight cf=new ConnectionFlight(new Date(1,1,2020),new Date(07,1,2020),"Natbag air port","elal",500,12,747,"NY air port",new Date(02,1,2020),new Date(03,1,2020),"bangkok air port"); 
		cf.print();
		
		
	}

}
