package checked;

import beans.Child;
import beans.Parent;

public class NestedException {

	Parent p;
	Child c;
	public String getParentChild(String parent) throws ClassNotFoundException{
		if(parent.equals("Parent")){
			p=new Parent();
			c=new Child();
			System.out.println(c instanceof Parent);
			if(p instanceof Child)
				c = new Child();
		}
		StringBuffer sb = new StringBuffer();
		return sb.append(p + "|" + c).toString();	
	}
	
	
}
