package iFly;

import java.io.Serializable;

import javax.xml.crypto.Data;

@SuppressWarnings({ "unused", "serial" })
public class Date implements Serializable {
	
	public static int day;
	public static int month;
	public static int year;
	public Date()
	{
		day=month = 1;
		year = 2000;
		
	}
	public Date(int day, int month , int year)
	{
		Date.day = day;
		Date.month = month;
		Date.year = year;
	}
	
	public Date(String str)
	{
		Date.day = (str.charAt(0)-'0')*10 + (str.charAt(1)-'0');
		Date.month = (str.charAt(3)-'0')*10 +str.charAt(4)-'0';
		Date.year = 2020;//convertString(str.substring(6,10));
	}
	
	public String print()
	{
		String str = day + "/" + month + "/" + year;
		return str;
	}
	@SuppressWarnings("static-access")
	public static String print(Date date)
	{
		String str = date.day + "/" + date.month + "/" + date.year;
		return str;
	}
	
	public static int convertString(String str)
	{
		int size= str.length();
		int num=0;
		
		if(str.length()==1)
			num=str.charAt(0)-'0';
		else
		{
			for(int i= 0; i<size ; i++)
			{
				num += (str.charAt(i)-'0') * Math.pow(10, size - i-1);
			}
		}
		return num;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public boolean equals(Object date)
	{	
		if(year == ((Date)date).year && (month == ((Date)date).month) && (day == ((Date)date).day) )
			return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return print(this);
	}

}
