package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * 全排列
 * 
	给定一个可包含重复数字的序列，返回所有不重复的全排列。

	示例:

	输入: [1,1,2]
	输出:
	[
	[1,1,2],
	[1,2,1],
	[2,1,1]
	]
 */
public class leetcode_047 {
	//此方法在leetcode编译器中会宝座，原因在于public和static关键字的关系。
	static List<List<Integer>> res = new ArrayList<>();
	static boolean[] used;
	public static List<List<Integer>> permuteUnique(int[] nums){
		if(nums.length == 0 || nums == null){
			return res;
		}
		used = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		permuteSub(nums, 0, list);
		return res;
	}

	public static void permuteSub(int[] nums, int index, List<Integer> list){
		if(index == nums.length && !res.contains(list)){
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
		int[] nums = {1,2,2};
		System.out.println("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe permute: ");
		for(List<Integer> item: permuteUnique(nums)){
				System.out.print(item+" ");
		}
		
	}
}
