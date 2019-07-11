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


















