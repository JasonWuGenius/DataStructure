package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

public class leetcode_046 {
	/*
	 * 全排列
	 * 
	 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
		示例:
		输入: [1,2,3]
		输出:
		[
		  [1,2,3],
		  [1,3,2],
		  [2,1,3],
		  [2,3,1],
		  [3,1,2],
		  [3,2,1]
		]
	 */
	//方法一：
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(nums[0]);
		result.add(l1);
		for(int i=1; i<nums.length; i++){
			List<List<Integer>> resultx = new ArrayList<List<Integer>>();
			for(List<Integer> list: result){
				for(int j=0; j<=list.size(); j++){
					List<Integer> list2 = new ArrayList<Integer>();
					list2.addAll(list);
					list2.add(j, nums[i]);
					resultx.add(list2);
				}
			}
			result = resultx;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe permute: ");
		for(List<Integer> item: permute(nums)){
				System.out.print(item+" ");
		}
		
	}
}
