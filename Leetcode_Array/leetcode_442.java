package Leetcode_Array;

import java.util.ArrayList;
import java.util.List;

public class leetcode_442 {
	/*
	 * �������ظ�����
	 * ����һ���������� a������1 �� a[i] �� n ��nΪ���鳤�ȣ�, ������ЩԪ�س������ζ�����Ԫ�س���һ�Ρ�
		�ҵ����г������ε�Ԫ�ء�
		����Բ��õ��κζ���ռ䲢��O(n)ʱ�临�Ӷ��ڽ�����������
		ʾ����
		����:
		[4,3,2,7,8,2,3,1]
		���:
		[2,3]
	 */
	//����һ��ʹ�ö���ռ�
	public static List<Integer> findDuplicates(int[] nums){
		int n = nums.length;
		int[] array = new int[n+1];
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<nums.length; i++){
			array[nums[i]] += 1;
		}
		for(int i=1; i<array.length; i++){
			if(array[i] > 1){
				result.add(i);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println("The Duplicated item are: "+findDuplicates(nums));
	}

}
