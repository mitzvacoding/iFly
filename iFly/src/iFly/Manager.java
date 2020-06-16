package iFly;

public class Manager extends User
{
	
	private int seniority;
	
  	
	public Manager() 
	{
		super();
		this.setSeniority(0);
	}
	public Manager(String email,String password,String name,int seniority)
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
