package Leetcode_String;

public class leetcode_007 {
	/*
	 * 整数反转
	 * 
	 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
		示例 1:
		输入: 123
		输出: 321
		 示例 2:
		输入: -123
		输出: -321
		示例 3:
		输入: 120
		输出: 21
		
		注意:
		假设我们的环境只能存储得下 32 位的有符号整数，
		则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，
		如果反转后整数溢出那么就返回 0。
	 */
	public static int reverse(int x){
		char[] temp = Integer.toString(x).toCharArray();
		if(temp[0] < 48 || temp[0] > 57){
			for(int i=1; i<(temp.length+2)/2; i++){
				reverseNum(temp, i, temp.length-1-i);
			}
		}
		else{
			for(int i=0; i<temp.length/2; i++){
				reverseNum(temp, i, temp.length-1-i);
			}
		}
		return Integer.parseInt(new String(temp));
	}
	public static void reverseNum(char[] s, int begin, int end){
		char temp = s[begin];
		s[begin] = s[end];
		s[end] = temp;
	}
	public static void main(String[] args) {
//		int x = -123;
//		int x = 123;
		int x = 120;
		System.out.println("The Origin Num: "+x);
		System.out.println("The Reversed Num: "+reverse(x));
	}
}
