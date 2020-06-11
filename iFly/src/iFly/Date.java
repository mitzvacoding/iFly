package iFly;

import java.io.Serializable;

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
		this.year = convertString(str.substring(6,10));
	}
	
	public String print()
	{
		String str = day + "/" + month + "/" + year;
		return str;
	}
	
	public static int convertString(String str)
	{
		int size= str.length();
		int num=0;
		for(int i= 0; i<size ; i++)
		{
			num += (str.charAt(i)-'0') * Math.pow(10, size - i-1);
		}
		return num;
	}

}
