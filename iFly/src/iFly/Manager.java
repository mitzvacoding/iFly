package iFly;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Manager extends User implements Serializable
{
	
	private int seniority;
	
  	
	public Manager() 
	{
		super();
		this.setSeniority(0);
	}
	public Manager(String name,String email,String password,int seniority)
	{ 
	   super(name,email,password); 
		this.setSeniority(seniority);
	}

	@Override
	public  String showDetalis(){return null;}
	
	public boolean addFlight() {return false;};
	public void removeFlight() {}
	public boolean addUser() {return false;};
	public boolean removeUser() {return false;}
  
	public int getSeniority() 
	{
		return seniority;
  	}
	public void setSeniority(int seniority)
	{
		this.seniority = seniority;
  	}
  
@Override
public String toString() 
{
	String str="seniority:"+this.seniority +"\nEmail"+ this.getEmail()+"Password"+this.getPassword();
	return str;
};
	

	
	

}
