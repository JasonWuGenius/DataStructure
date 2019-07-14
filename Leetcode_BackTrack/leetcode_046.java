package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

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
public class leetcode_046 {
	//方法一：迭代法
	static List<List<Integer>> res = new ArrayList<>();
	static boolean[] used;
	public static List<List<Integer>> permute(int[] nums){
		if(nums.length == 0 || nums == null){
			return res;
		}
		used = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		permuteSub(nums, 0, list);
		return res;
	}

	public static void permuteSub(int[] nums, int index, List<Integer> list){
		if(index == nums.length){
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=0; i<nums.length; i++){
			if(!used[i]){
				list.add(nums[i]);
				used[i] = true;
				permuteSub(nums, index+1, list);
				list.remove(list.size()-1);
				used[i] = false;
			}
		}
		return;
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
