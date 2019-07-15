package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * �������
 * 
	����һ�����ظ�Ԫ�ص�����?candidates?��һ��Ŀ����?target?���ҳ�?candidates?�����п���ʹ���ֺ�Ϊ?target?����ϡ�

	candidates?�е����ֿ����������ظ���ѡȡ��

	˵����

	�������֣�����?target��������������
	�⼯���ܰ����ظ�����ϡ�?
	ʾ��?1:

	����: candidates = [2,3,6,7], target = 7,
	����⼯Ϊ:
	[
	[7],
	[2,2,3]
	]
	ʾ��?2:

	����: candidates = [2,3,5], target = 8,
	����⼯Ϊ:
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
