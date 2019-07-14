package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * ȫ����
 * 
 * ����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�
	ʾ��:
	����: [1,2,3]
	���:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 */
public class leetcode_046 {
	//����һ��������
	static List<List<Integer>> res = new ArrayList<>();
	static boolean[] used;
	public static List<List<Integer>> permute(int[] nums){
		if(nums.length == 0 || nums == null){
			return res;
		}
		used = new boolean[nums.length];
		List<Integer> list = new ArrayList<>();
		permuteSub(nums, 0, list);
		return res;
	}

	public static void permuteSub(int[] nums, int index, List<Integer> list){
		if(index == nums.length){
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
		int[] nums = {1,2,3};
		System.out.println("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe permute: ");
		for(List<Integer> item: permute(nums)){
				System.out.print(item+" ");
		}
		
	}
}
