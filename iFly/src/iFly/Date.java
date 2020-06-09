package iFly;

import java.io.Serializable;
import java.time.LocalDate;

public class Date implements Serializable {
	
	public int day,month,year;
	public Date()
	{
		day=month = 1;
		year = 2000;
		
	}
	
	public Date(int day, int month , int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(String str)
	{
		this.day = (str.charAt(0)-'0')*10 + (str.charAt(1)-'0');
		this.month = (str.charAt(3)-'0')*10 +str.charAt(4)-'0';
		this.year = (str.charAt(6)-'0')*1000 + (str.charAt(7)-'0')*100 + (str.charAt(8)-'0')*10 + str.charAt(9)-'0';
	}
	
	public String print()
	{
		String str = day + "/" + month + "/" + year;
		return str;
	}

}
