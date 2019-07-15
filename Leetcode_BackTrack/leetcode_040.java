package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 组合总数2
 * 
 * 给定一个数组?candidates?和一个目标数?target?，找出?candidates?中所有可以使数字和为?target?的组合。

	candidates?中的每个数字在每个组合中只能使用一次。

	说明：

	所有数字（包括目标数）都是正整数。
	解集不能包含重复的组合。?
	示例?1:

	输入: candidates =?[10,1,2,7,6,1,5], target =?8,
	所求解集为:
	[
	[1, 7],
	[1, 2, 5],
	[2, 6],
	[1, 1, 6]
	]
	示例?2:

	输入: candidates =?[2,5,2,1,2], target =?5,
	所求解集为:
	[
	? [1,2,2],
	? [5]
	]
 */
class leetcode_040 {
	static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0){
			return res;
		}
		List<Integer> list = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSumSub(candidates, list, 0, target);
		return res;
	}
	
	public static void combinationSumSub(int[] nums, List<Integer> list, int index, int target){
		if(target == 0 && !res.contains(list)){
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=index; i<nums.length&&target>=nums[i]; i++){
			list.add(nums[i]);
			combinationSumSub(nums, list, i+1, target-nums[i]);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = {2,5,2,1,2};
		int target = 5;
		// int[] candidates = {10,1,2,7,6,1,5};
		// int target = 8;
		System.out.println("The candidates: ");
		for(int item: candidates){
			System.out.print(item+" ");
		}
		System.out.println("\nThe target: "+target);
		System.out.println("The result: "+combinationSum2(candidates, target));
	}
}
