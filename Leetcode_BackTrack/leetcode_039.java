package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 组合总数
 * 
	给定一个无重复元素的数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。

	candidates?中的数字可以无限制重复被选取。

	说明：

	所有数字（包括?target）都是正整数。
	解集不能包含重复的组合。?
	示例?1:

	输入: candidates = [2,3,6,7], target = 7,
	所求解集为:
	[
	[7],
	[2,2,3]
	]
	示例?2:

	输入: candidates = [2,3,5], target = 8,
	所求解集为:
	[
	? [2,2,2,2],
	? [2,3,3],
	? [3,5]
	]
 */
class leetcode_039 {
	static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0){
			return res;
		}
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSumSub(candidates, list, 0, target);
		return res;
	}
	
	public static void combinationSumSub(int[] nums, List<Integer> list, int index, int target){
		if(target == 0){
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=index; i<nums.length&&target>=nums[i]; i++){
			list.add(nums[i]);
			combinationSumSub(nums, list, i, target-nums[i]);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		// int[] candidates = {2,3,6,7};
		// int target = 7;
		int[] candidates = {2,3,5};
		int target = 8;
		System.out.println("The candidates: ");
		for(int item: candidates){
			System.out.print(item+" ");
		}
		System.out.println("\nThe target: "+target);
		System.out.println("The result: "+combinationSum(candidates, target));
	}
}
