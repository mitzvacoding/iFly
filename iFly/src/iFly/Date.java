package iFly;

public class Date {
	
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
	
	public String print()
	{
		String str = day + "/" + month + "/" + year;
		return str;
	}

}