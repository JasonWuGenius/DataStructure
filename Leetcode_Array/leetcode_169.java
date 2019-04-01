package Leetcode_Array;

import java.util.Arrays;

public class leetcode_169 {
	/*
	 * 求众数
	 * 
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
		你可以假设数组是非空的，并且给定的数组总是存在众数。
		示例 1:
		输入: [3,2,3]
		输出: 3
		示例 2:
		输入: [2,2,1,1,1,2,2]
		输出: 2
	 */
	//方法一：不建议，尽量不要使用现成的API
	public static int majorityElement1(int[] nums){
		if(nums == null){
			return -1;
		}
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	//方法二：
	public static int majorityElement2(int[] nums){
		if(nums == null){
			return -1;
		}
		int count = 1;
		int maj = nums[0];
		for(int i=1; i<nums.length; i++){
			if(maj == nums[i]){
				count++;
			}
			else{
				count--;
				if(count == 0){
					maj = nums[i+1];
				}
			}
		}
		return maj;
	}
	public static void main(String[] args) {
//		int[] nums = {3,2,3};
		int[] nums = {2,2,1,1,1,2,2};
		System.out.print("The Nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe single num is: "+majorityElement2(nums));
	}

}
