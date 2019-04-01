package Leetcode_HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class leetcode_136 {
	/*
	 * ֻ����һ�ε�����
	 * 
	 * 	����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ�
	 * �ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
		˵����
		����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
		ʾ�� 1:
		����: [2,2,1]
		���: 1
		ʾ�� 2:
		����: [4,1,2,1,2]
		���: 4
	 */
	//����һ��Hash
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
		//������һ��keyset
//		Iterator<Integer> iter = map.keySet().iterator();
//		while(iter.hasNext()){
//			int key = iter.next();
//			if(map.get(key) == 1){
//				return key;
//			}
//		}
		//������һ��for each
		for(Integer key: map.keySet()){
			if(map.get(key) == 1){
				return key;
			}
		}
		//����������entrySet
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
		//����������for each
//		for(Entry<Integer, Integer> entry: map.entrySet()){
//			int key = entry.getKey();
//			int value = entry.getValue();
//			if(value == 1){
//				return key;
//			}
//		}
		return -1;
	}
	//�����������
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
