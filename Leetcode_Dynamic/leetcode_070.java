package Leetcode_Dynamic;

public class leetcode_070 {
	/*
	 * 爬楼梯
	 * 
	 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
		每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
		注意：给定 n 是一个正整数。
		示例 1：
		输入： 2
		输出： 2
		解释： 有两种方法可以爬到楼顶。
		1.  1 阶 + 1 阶
		2.  2 阶
		示例 2：
		输入： 3
		输出： 3
		解释： 有三种方法可以爬到楼顶。
		1.  1 阶 + 1 阶 + 1 阶
		2.  1 阶 + 2 阶
		3.  2 阶 + 1 阶
	 */
	//方法一：递归法
	public static int climbStairs1(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		return climbStairs1(n-1)+climbStairs1(n-2);
	}
	//方法二：
	public static int climbStairs2(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		int a = 1;
		int b = 2;
		int i=2;
		while(i<n){
			int temp = a+b;
			a = b;
			b = temp;
			i++;
			System.out.print(b+" ");
		}
		return b;
	}
	public static void main(String[] args) {
		System.out.println("The Solution is: "+climbStairs1(8));
		System.out.println("The Solution is: "+climbStairs2(8));
	}

}
