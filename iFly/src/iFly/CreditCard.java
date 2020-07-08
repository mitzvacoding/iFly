package iFly;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CreditCard implements Serializable {
	
	private int creditNumber;
	private int validity;
	private int cvv;															

	public CreditCard()
	{
		this.creditNumber=0;
		this.validity=0;
		this.cvv=0;
	}
	public CreditCard( int creditNumber,int validity, int cvv)
	{
		this.creditNumber=creditNumber;
		this.validity=validity;
		this.cvv=cvv;
	} 
	
	
	public String print()
	{
		String str="creditNumber:"+this.creditNumber+"\nvalidity:"+this.validity+"\ncvv"+this.cvv;
		return str;
	}
	
}
