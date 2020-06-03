package iFly;

import java.util.HashMap;

public class Customer extends User
{
 HashMap<Integer,String> cart;
 CreditCard  credit;
	
 
 
 public Customer()
 {
	 super();
	 this.cart=new HashMap<Integer, String>(0);
     this.credit= new CreditCard();

 }

 public Customer(String email,String password,HashMap<Integer,String> cart,CreditCard  credit)
 {
	 super(email,password);
	 this.cart=new HashMap<Integer, String>(0);
     this.credit= new CreditCard();

 }

 

	@Override
	public  String showDetalis(){return null;}
	public boolean serachFlight(String dates,String destination) {return true;}
	
}
