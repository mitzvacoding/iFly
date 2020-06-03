package iFly;



public abstract class User 
{
  
  private String email;
  private String password;
  
 
 public User(String email,String password)
 {
	 this.email=email;
	 this.password=password;
 }

 public User()
 {
	 this.email=null;
	 this.password=null;
 }
  
 
 
 
  public  abstract String showDetalis();
  

  
}
