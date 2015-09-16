package checked;

public class UnCheckedException {

	public int divide(int a,int b) throws RuntimeException{
		int result=0;
		if(b!=0){
			result = a/b;
			return result;
		}
		return 0;
	}
	
	public int getIndexOfNumber(int number) throws ArrayIndexOutOfBoundsException{
		int[] array={1,6,7,4,5};
		for(int i=0;i<array.length;i++){
			if(array[i] == number)
				return i;
		}
		return -1;		
	}
	
}
