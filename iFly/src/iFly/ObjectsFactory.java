package iFly;

public class ObjectsFactory {

	public static Object getObject(String objectType)
	{
		Object obj = null;
		if(objectType == "flight"){
			obj = new Flight();
		
		}else if(objectType == "customer"){
		obj = new Customer();
		
		}else if(objectType == "manager"){
			obj = new Manger();
		}

		
		
		
		return obj;
	}
}

