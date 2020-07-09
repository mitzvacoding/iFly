package iFly;

import java.util.Observable;
import java.util.Observer;

import UI.ManagerPage;
import UI.ResultPage;
import UI.SearchPage;
 
@SuppressWarnings({ "deprecation", "unused" })
public class Connected implements Observer
 
{ 	
	@Override
	public void update(Observable o, Object arg) 
	{		
		ManagerPage.ManPage();
	} 
}
