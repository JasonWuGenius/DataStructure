package Leetcode_Math;

public class leetcode_326 {
	/*
	 * 3的幂
	 * 
	 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
		示例 1:
		输入: 27
		输出: true
		示例 2:
		输入: 0
		输出: false
		示例 3:
		输入: 9
		输出: true
		示例 4:
		输入: 45
		输出: false
		进阶：
		你能不使用循环或者递归来完成本题吗？
	 */
	public static boolean isPowerOfThree(int n){
		System.out.println("n is: "+n);
		if(n<=1){
			return false;
		}
		while(n>1){
			if(n%3 != 0){
				return false;
			}
			n /= 3;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("The n is the power of three: "+isPowerOfThree(1));
	}

}
