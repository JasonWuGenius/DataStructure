package Leetcode_Array;

import java.util.ArrayList;
import java.util.List;

public class leetcode_442 {
	/*
	 * 数组中重复数据
	 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
		找到所有出现两次的元素。
		你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
		示例：
		输入:
		[4,3,2,7,8,2,3,1]
		输出:
		[2,3]
	 */
	//方法一：使用额外空间
	public static List<Integer> findDuplicates(int[] nums){
		int n = nums.length;
		int[] array = new int[n+1];
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<nums.length; i++){
			array[nums[i]] += 1;
		}
		for(int i=1; i<array.length; i++){
			if(array[i] > 1){
				result.add(i);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println("The Duplicated item are: "+findDuplicates(nums));
	}

}
