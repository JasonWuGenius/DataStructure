package Leetcode;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] scores = new int[n];
        int count = 2;
        for(int i = 0; i < n; i++){
        	count = 2*count;
            height[i] = sc.nextInt();
            if(i > 0){
            	scores[i] = scores[i-1]*2 + height[i];
            }else{
            	scores[i] = height[i];
            }
        }
        int res = 0;
        if(scores[n-1] % count == 0){
        	res = scores[n-1]/count;
        }
        else{
        	res = scores[n-1]/count+1;
        }
        System.out.println(res);
	}
}
