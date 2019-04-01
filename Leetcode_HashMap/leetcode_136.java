package Leetcode_HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class leetcode_136 {
	/*
	 * 只出现一次的数字
	 * 
	 * 	给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
	 * 找出那个只出现了一次的元素。
		说明：
		你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
		示例 1:
		输入: [2,2,1]
		输出: 1
		示例 2:
		输入: [4,1,2,1,2]
		输出: 4
	 */
	//方法一：Hash
	public static int singleNumber1(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		if(nums.length == 1){
			return nums[0];
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		//遍历法一：keyset
//		Iterator<Integer> iter = map.keySet().iterator();
//		while(iter.hasNext()){
//			int key = iter.next();
//			if(map.get(key) == 1){
//				return key;
//			}
//		}
		//遍历法一：for each
		for(Integer key: map.keySet()){
			if(map.get(key) == 1){
				return key;
			}
		}
		//遍历法二：entrySet
//		Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
//		Entry<Integer, Integer> entry;
//		while(iter.hasNext()){
//			entry = iter.next();
//			int key = entry.getKey();
//			int value = entry.getValue();
//			if(value == 1){
//				return key;
//			}
//		}
		//遍历法二：for each
//		for(Entry<Integer, Integer> entry: map.entrySet()){
//			int key = entry.getKey();
//			int value = entry.getValue();
//			if(value == 1){
//				return key;
//			}
//		}
		return -1;
	}
	//方法二：异或
	public static int singleNumber2(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		if(nums.length == 1){
			return nums[0];
		}
		for(int i=1 ;i<nums.length; i++){
			nums[i] = nums[i] ^ nums[i-1];
		}
		return nums[nums.length-1];
	}
	public static void main(String[] args) {
		int[] nums = {2,2,1};
//		int[] nums = {4,1,2,1,2};
		System.out.print("The Nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe single num is: "+singleNumber2(nums));
	}

}
