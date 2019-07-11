package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * 子集
 * 
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	说明：解集不能包含重复的子集。
	示例:
	输入: nums = [1,2,3]
	输出:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 */
public class leetcode_078 {
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		dfs(res, temp, nums, 0);
		return res;
	}
	private static void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j){
		res.add(new ArrayList<Integer>(temp));
		for(int i=j; i<nums.length; i++){
			temp.add(nums[i]);
			dfs(res, temp, nums, i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("The subsets: "+subsets(nums));
	}

}


















