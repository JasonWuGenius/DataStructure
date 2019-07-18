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
	static List<List<Integer>> res = new ArrayList<>();
	public static List<List<Integer>> subsets(int[] nums){
		List<Integer> list = new ArrayList<>();
		res.add(new ArrayList<>());
		subsetsSub(list, nums, 0);
		return res;

	}
	private static void subsetsSub(List<Integer> list, int[] nums, int index){
		for(int i=index; i<nums.length; i++){
			list.add(nums[i]);
			res.add(new ArrayList<>(list));
			subsetsSub(list, nums, i+1);
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


















