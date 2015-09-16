package main;

import beans.Ferrari;
import checked.CheckedException;
import checked.NestedException;
import checked.Reflection;
import checked.UnCheckedException;

public class ExceptionMain {

	public static void main(String args[]){
			CheckedException ce = new CheckedException();
			try{
				Ferrari f=(Ferrari)ce.getNewObject("Nissan");
				if(f == null) throw new ClassNotFoundException();
			}catch(Exception e){
				System.out.println("Object not found in factory.");
			}
			
			
			UnCheckedException une = new UnCheckedException();
			int result=une.divide(6, 3);
			if(result == 0)
				System.out.println("You can't pass zero to the second argument..");
			else
				System.out.println("Division is :"+result);
			
			int index=une.getIndexOfNumber(7);
			if(index != -1)
				System.out.println("Index of the number is:" +index);
			else
				System.out.println("Passed number not found in the array..");
			
			
			
			NestedException ne = new NestedException();
			try{
				String object=ne.getParentChild("Parent");
				String[] array=object.split("|");
				System.out.println(array[0]+"|"+array[1]);
			}
			catch(ClassNotFoundException e){
				System.out.println("No parent child relation found in project");
			}
			
			
			
		}
		
		}
