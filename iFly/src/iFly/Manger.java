package iFly;

public class Manger extends User {
	
	private int seniority;
	
  	
	public Manger()
	{
		super();
		this.setSeniority(0);
	}
	public Manger(String email,String password,int seniority)
	{
	   super(email,password);
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
  	};
	

	
	

}
