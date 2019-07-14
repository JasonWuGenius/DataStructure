package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * �Ӽ�
 * 
 * ����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
	˵�����⼯���ܰ����ظ����Ӽ���
	ʾ��:
	����: nums = [1,2,3]
	���:
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
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(nums == null){
			return res;
		}
		res.add(new ArrayList<>());
		dfs(res, list, nums, 0);
		return res;
	}
	private static void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int j){
		for(int i=j; i<nums.length; i++){
			list.add(nums[i]);
			res.add(new ArrayList<>(list));
			// ������Ҫע�����dfs()��������i+1��������j+1
			dfs(res, list, nums, i+1);
			list.remove(list.size()-1);
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


















