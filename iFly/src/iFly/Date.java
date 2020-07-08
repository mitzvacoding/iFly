package iFly;

import java.io.Serializable;

import javax.xml.crypto.Data;

@SuppressWarnings({ "unused", "serial" })
public class Date implements Serializable {
	
	public int day;
	public int month;
	public int year;
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
		if(str.isEmpty())
			day= -1;
		int i=0, beginIndex = 0, counter = 0;
		for(i=0 ; i<str.length() ; i++)
		{
			if((str.charAt(i) == '/') || (str.charAt(i)== '\\') || (str.charAt(i)=='.') )
			{
				switch(counter) {
					
					case 0:
						day = convertString(str.substring(beginIndex, i));
						break;
					case 1:
						month = convertString(str.substring(beginIndex, i));
						break;
					case 2:
						year = convertString(str.substring(beginIndex, i));
						break;
				
				}
				counter++;
				beginIndex = i+1;
				i= beginIndex;
				
			}
			else if((i==str.length() -1))
				year = convertString(str.substring(beginIndex, i+1));
				
				
				
		}
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
	
	public boolean isEmpty()
	{
		if(day == -1)
			return true;
		return false;
	}

}
