package Leetcode_BinarySearch;

public class leetcode_088 {
	/*
	 * �ϲ�������������--δ���
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
	public static void merge1(int[] nums1, int m, int[] nums2, int n){
		int p = m-- + n-- + 1;
		while(m >= 0 && n >= 0){
			nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		}
		while(n >= 0){
			nums1[p--] = nums2[n--];
		}
	}
	
	public static void merge2(int[] nums1, int m, int[] nums2, int n){
        int j = 0, k = 0;
	    int[] nums = new int[m];
        for(int i = 0; i < m; i++)
    	    nums[i] = nums1[i];
        for(int i = 0; i < nums1.length; i++) {
    	    if(k >= n || (j < m && nums[j] < nums2[k])) {
    		    nums1[i] = nums[j++];
    	    }else{
    		    nums1[i] = nums2[k++];
    	    }
        }
	}
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		System.out.println("Before: \nThe nums1: ");
		for(int item: nums1){
			System.out.print(item+" ");
		}
		System.out.println("\nThe nums2: ");
		for(int item: nums2){
			System.out.print(item+" ");
		}
		merge2(nums1, 3, nums2, 3);
		System.out.println("\nLast: \nThe nums1: ");
		for(int item: nums1){
			System.out.print(item+" ");
		}
		System.out.println("\nThe nums2: ");
		for(int item: nums2){
			System.out.print(item+" ");
		}
	}

}
