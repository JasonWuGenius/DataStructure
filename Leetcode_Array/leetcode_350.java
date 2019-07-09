package Leetcode_Array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 *  ��������Ľ��� II
 * 
	�����������飬��дһ���������������ǵĽ�����

	ʾ�� 1:

	����: nums1 = [1,2,2,1], nums2 = [2,2]
	���: [2,2]
	ʾ�� 2:

	����: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	���: [4,9]
	˵����

	��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ�¡�
	���ǿ��Բ�������������˳��
	����:

	��������������Ѿ��ź����أ��㽫����Ż�����㷨��
	��� nums1 �Ĵ�С�� nums2 С�ܶ࣬���ַ������ţ�
	��� nums2 ��Ԫ�ش洢�ڴ����ϣ������ڴ������޵ģ������㲻��һ�μ������е�Ԫ�ص��ڴ��У������ô�죿
 */
public class leetcode_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0, j=0; i<nums1.length && j<nums2.length; ){
			if(nums1[i] < nums2[j]){
				i++;
			}
			else if(nums1[i] > nums2[j]){
				j++;
			}
			else{
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] res = new int[list.size()];
		for(int i=0; i<res.length; i++){
			res[i] = list.get(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		System.out.println("The nums1: ");
		for(int item: nums1){
			System.out.print(item+" ");
		}
		System.out.println("\nThe nums2: ");
		for(int item: nums2){
			System.out.print(item+" ");
		}
		int[] res = intersect(nums1, nums2);
		System.out.println("\nThe res num: ");
		for(int item: res){
			System.out.print(item+" ");
		}
		
	}

}
