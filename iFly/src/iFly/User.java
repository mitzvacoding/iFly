package iFly;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class User implements Serializable
{
	
  private String name; 	
  private String email;
  private String password;
  
  
 public User(String name,String email,String password)
 {
	 this.setName(name);
	 this.setEmail(email);
	 this.setPassword(password);
 } 
 
 public User()
 {
	 this.setName(null);
	 this.setEmail(null);
	 this.setPassword(null);
 }
  
 

  public  abstract String showDetalis();

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() 
{
	return name;
}

public void setName(String name) {
	this.name = name;
}
  




}
