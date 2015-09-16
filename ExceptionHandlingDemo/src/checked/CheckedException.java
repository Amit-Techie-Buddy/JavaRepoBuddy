package checked;

import beans.Audi;
import beans.Ferrari;

public class CheckedException {

	public Object getNewObject(String type) throws ClassNotFoundException{
		if(type.equals("Ferrari")){
			return new Ferrari(); 
		}
		if(type.equals("Audi")){
			return new Audi(); 
		}
		return null;
	}
	
}
