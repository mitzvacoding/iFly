package iFly;

import java.io.Serializable;
import java.util.HashMap;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Customer extends User implements Serializable
{
 HashMap<Integer,String> cart;
 CreditCard  credit;
	
 
 
 public Customer()
 { 
	 super();
	 this.cart=new HashMap<Integer, String>(0);
     this.credit= new CreditCard();

 }
 
 public Customer(String email)
 {
	 this.setName("");
	 this.setEmail(email);
	 this.setPassword("");
 }

 public Customer(String email,String password,String name,HashMap<Integer,String> cart,CreditCard  credit)
 {
	 super(email,password,name);
	 this.cart=new HashMap<Integer, String>(0);
     this.credit= new CreditCard();

 }

 


	public Customer(String name, String email, String password)
	{
		super(name, email,password);
	}

	@Override
	public  String showDetalis(){return null;}
	public boolean serachFlight(String dates,String destination) {return true;}

	@Override
	public String toString() 
	{
	String str="Name:"+ this.getName()+"/Email:"+ this.getEmail()+"/Password "+ this.getPassword();//+"\nCredit Card: "+this.credit.print();
	return str;
	}
	
	@Override
	public boolean equals(Object c)
	{//serves two things:1) checking if a chosen email of 'c' exists, in this case pass="". 2)checking if user 'c' can sign in.
		if(this.getEmail().equals( ((Customer)c).getEmail() ) )
		{
			if(((Customer)c).getPassword().equals(""))//only checking if user exists.
				return true;
			else if(this.getPassword().equals(((Customer)c).getPassword()))
				return true;
		}
		return false;
	}
	
}
