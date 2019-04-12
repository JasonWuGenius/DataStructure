import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] rand = new double[n+1];
        rand[0] = 0;
        for(int i=1; i<=n; i++){
        	rand[i] = in.nextDouble();
        }
        double res1 = 0;
        double res2 = 0;
        int count = 0;
        int index = 1;
        while(res1 < 0.5 && res2 < 0.5){
        	if(index % 2 == 1){
        		int i=1;
        		for(; i<=n; i++){
        			if(i % 2 == 1){
        				res1 += rand[i];
        			}
        			if(i % 2 != 1){
        				res2 += rand[i];
        			}
        			if(count++ == 100){
        				break;
        			}
        		}
        	}
        	else{
        		if(n % 2 == 1){
        			int i=1;
        			for(; i<=n; i++){
        				if(i % 2 == 1){
        					res2 += rand[i];
        				}
        				if(i % 2 != 1){
        					res1 += rand[i];
        				}
        				if(count++ == 100){
        					break;
        				}
        			}
        		}
        		else{
        			int i=1;
        			for(; i<=n; i++){
        				if(i % 2 == 1){
        					res1 += rand[i];
        				}
        				if(i % 2 != 1){
        					res2 += rand[i];
        				}
        				if(count++ == 100){
        					break;
        				}
        			}
        		}
        	}
        }
        System.out.printf("%.4f",res1);
    }
}