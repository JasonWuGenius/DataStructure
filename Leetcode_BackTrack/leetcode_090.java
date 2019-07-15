package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 子集2
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

	说明：解集不能包含重复的子集。

	示例:

	输入: [1,2,2]
	输出:
	[
	[2],
	[1],
	[1,2,2],
	[2,2],
	[1,2],
	[]
	]
 */
public class leetcode_090 {
	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(nums == null){
			return res;
		}
		res.add(new ArrayList<>());
		Arrays.sort(nums);
		dfs(res, list, nums, 0);
		return res;
	}
	private static void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int j){
		for(int i=j; i<nums.length; i++){
			list.add(nums[i]);
			if(!res.contains(list)){
				res.add(new ArrayList<>(list));
			}
			// 这里需要注意的是dfs()中索引是i+1，而不是j+1
			dfs(res, list, nums, i+1);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {4,4,4,1,4};
		System.out.println("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("The subsets: "+subsets(nums));
	}

}


















