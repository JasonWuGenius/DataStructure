package Leetcode_BinarySearch;

public class leetcode_069 {
	/**
	 * 	实现 int sqrt(int x) 函数。
		计算并返回 x 的平方根，其中 x 是非负整数。
		由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
	 */
	//方法一：暴力搜索，从1开始逐渐便利，时间复杂度太高，不建议使用
	public int mySqrt1(int x){
		for(long i=0; i<=x; i++){
			if(i*i>x){
				return (int)i-1;
			}
			else if(i*i == x){
				return (int)i;
			}
		}
		return 0;
	}
	//方法二：二分查找法，
	public int mySqrt2(int x){
		int left = 1;
		int right = x;
		int mid = (left+right)/2;
		while(left<right){
			if(mid*mid == x){
				break;
			}
			else if(mid*mid>x){
				right = mid-1;
				mid = (left+right)/2;
			}
			else if(mid*mid<x){
				left = mid+1;
				mid = (left+right)/2;
			}
		}
		return mid*mid>x? mid-1:mid;
	}
	//方法三：牛顿法求解-收敛速度快，
	private final double precision = 0.001;
	public int mySqrt3(int x){
		double y = x * 1.0;
		double sqrt_y = 1;
		while(Math.abs(y - sqrt_y*sqrt_y)>precision){
			sqrt_y = (sqrt_y + y / sqrt_y) / 2;
		}
		return (int)sqrt_y;
	}
	
	public static void main(String[] args) {
		leetcode_069 l069 = new leetcode_069();
		int x = 4;
		System.out.println("The sqrt of "+x+" : "+l069.mySqrt3(x));
	}

}
