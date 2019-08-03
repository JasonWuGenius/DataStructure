package Other;

public class XORDemo {
	public static int findLost(int a[]){ 
		int result=0; 
        for(int i=0;i<a.length;i++) { 
			result^=a[i]; 
        } 
        return result; 
	} 
	public static void main(String[] args) {
		System.out.println("^:" + (3^3) );
		int[] arr = {2,4,6,5,8,2,5,6,4};
		System.out.println("lost:" + findLost(arr));
	}
}
