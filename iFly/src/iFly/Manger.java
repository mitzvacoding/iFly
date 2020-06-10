package iFly;

public class Manger extends User {
	
	private int seniority;
	
  	
	public Manger()
	{
		super();
		this.setSeniority(0);
	}
	public Manger(String email,String password,String name,int seniority)
	{
	   super(email,password,name);
		this.setSeniority(seniority);
	}

	@Override
	public  String showDetalis(){return null;}
	
  public boolean addFlight() {return false;};
  public void removeFlight() {}
  public boolean addUser() {return false;};
  public boolean removeUser() {return false;}
  
  public int getSeniority() {
	return seniority;
  	}
  public void setSeniority(int seniority) {
	this.seniority = seniority;
  	}
  
@Override
public String toString() 
{
	String str="seniority:"+this.seniority +"\nEmail"+ this.getEmail()+"Password"+this.getPassword();
	return str;
};
	

	
	

}
