package Leetcode_Array;

public class leetcode_088 {
	/*
	 * �ϲ�������������
	 * 
	 * �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣
		˵��:
		��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
		����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�
		ʾ��:
		����:
		nums1 = [1,2,3,0,0,0], m = 3
		nums2 = [2,5,6],       n = 3
		���: [1,2,2,3,5,6]
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p = m-- + n-- - 1;
		while(m >= 0 && n >= 0){
			nums1[p--] = nums1[m] > nums2[n]? nums1[m--] : nums2[n--];
		}
		while(n >= 0){
			nums1[p--] = nums2[n--];
		}
	}
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3;
		int n = 3;
		System.out.print("The Nums1:");
		for(int item: nums1){
			System.out.print(item+" ");
		}
		System.out.println("\nm:"+m);
		System.out.print("The Nums2:");
		for(int item: nums2){
			System.out.print(item+" ");
		}
		System.out.println("\nn:"+n);
		merge(nums1, m, nums2, n);
		System.out.println("The Merged Nums:");
		for(int item: nums1){
			System.out.print(item+" ");
		}
	}

}
