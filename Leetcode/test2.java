package Leetcode;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class test2{
    public static void main(String[] args) throws IOException{
    	Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[0]);
        int[][] matrix = new int[n][m];
        String line = null;
        int row = 0;
        while(row<n){
        	String[] strs = scanner.nextLine().split(" ");
        	for(int i=0; i<m; i++){
        		matrix[row][i] = Integer.parseInt(strs[i]);
        	}
        	row++;
        }
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];
        int max1 = 0;
        int max2 = 0;
        int count = 0;
        for(int i=0; i<n; i++){
        	for(int j=0; j<m; j++){
        		if(count % 2 == 0){
        			max1 = Math.max(max1, matrix[i][j]);
        			nums1[matrix[i][j]]++;
        		}
        		else{
        			max2 = Math.max(max2, matrix[i][j]);
        			nums2[matrix[i][j]]++;
        		}
        		count++;
        	}
        }
        int sum = 0;
        for(int i=0; i<10; i++){
        	if(nums1[i] < nums2[i]){
        		nums2[i] = 0;
        	}
        	else{
        		nums1[i] = 0;
        	}
        	sum += nums1[i] + nums2[i];
        }
        System.out.println(sum);
    }
}
