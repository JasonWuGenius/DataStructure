package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * �������2
 * 
 * ����һ������?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�

	candidates?�е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�

	˵����

	�������֣�����Ŀ������������������
	�⼯���ܰ����ظ�����ϡ�?
	ʾ��?1:

	����: candidates =?[10,1,2,7,6,1,5], target =?8,
	����⼯Ϊ:
	[
	[1, 7],
	[1, 2, 5],
	[2, 6],
	[1, 1, 6]
	]
	ʾ��?2:

	����: candidates =?[2,5,2,1,2], target =?5,
	����⼯Ϊ:
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
