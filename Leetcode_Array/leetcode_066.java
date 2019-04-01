package Leetcode_Array;

import java.util.Arrays;
import java.util.List;

public class leetcode_066 {
	/*
	 * 加1
	 * 
	 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
		最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
		你可以假设除了整数 0 之外，这个整数不会以零开头。
		示例 1:
		输入: [1,2,3]
		输出: [1,2,4]
		解释: 输入数组表示数字 123。
		示例 2:
		输入: [4,3,2,1]
		输出: [4,3,2,2]
		解释: 输入数组表示数字 4321。
		
		思路
		分两种情况讨论，一种是数组中的数字都是9,比如999，这时候数组长度需要+1；
		首位置位1，后几位置位0。
		另一种是情况是不全是9，那么加1的话，比如说个位是9，那么就把个位变为0，
		同时下一位加1，就是通过判断每一位是不是9来结束这个判断（从个位到最高位依次+1，
		直到不是9就结束循环）
	 */
	public static int[] plusOne(int[] digits){
		boolean flag = true;
		for(int i=0; i<digits.length; i++){
			if(digits[i] != 9){
				flag = false;
				break;
			}
		}
		if(flag){
			int[] result = new int[digits.length+1];
			result[0] = 1;
			return result;
		}
		else{
			for(int i=digits.length-1; i>=0; i--){
				if(digits[i] != 9){
					digits[i] += 1;
					break;
				}
				else{
					digits[i] = 0;
				}
			}
		}
		return digits;
	}
	public static void main(String[] args) {
		int[] digits = {9,9,9};
//		int[] digits = {4,3,2,1};
		System.out.println("The origin digits: ");
		for(int item: digits){
			System.out.print(item+" ");
		}
		System.out.println("\nThe result of Plusing One: ");
		for(int item: plusOne(digits)){
			System.out.print(item+" ");
		}
	}

}
