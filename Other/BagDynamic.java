package Other;

public class BagDynamic {
	/*
	 * 0-1背包问题
	 * 

		Weight[]  = { 2 ,3 ,4 ,5 }    

		value[]   = { 3 ,4 ,5 ,7 }      N = 4 
		
	 */
	public static int bagcount(int[] weight, int[] value, int maxweight){
		int n = weight.length;
		int[][] maxvalue = new int[n+1][maxweight+1];
		
		for(int i=0; i<maxweight+1; i++){
			maxvalue[0][i] = 0;
		}
		for(int i=0; i<n+1; i++){
			maxvalue[i][0] = 0;
		}
		
		for(int i=1; i<=n ;i++){
			for(int j=1; j<=maxweight; j++){
				maxvalue[i][j] = maxvalue[i-1][j];
				if(weight[i-1] <= j){
//					System.out.println("j-weight[i-1]"+(j-weight[i]));
					if(value[i-1]+maxvalue[i-1][j-weight[i-1]]>maxvalue[i-1][j]){
						maxvalue[i][j] = maxvalue[i-1][j-weight[i-1]]+value[i-1];
					}
				}
			}
		}
		for(int i=0; i<n+1; i++){
			for(int j=0; j<maxweight+1; j++){
				System.out.print(maxvalue[i][j]+"   ");
			}
			System.out.println();
		}
		return maxvalue[n][maxweight];
	}
	public static void main(String[] args){
		int[] weight = {2,3,4,5};
		int[] value = {3,4,5,7};
		int maxweight = 9;
		System.out.println(bagcount(weight, value, maxweight));
	}
}
























