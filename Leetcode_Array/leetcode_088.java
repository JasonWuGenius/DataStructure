package Leetcode_Array;

public class leetcode_088 {
	/*
	 * 合并两个有序数组
	 * 
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
		说明:
		初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
		你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
		示例:
		输入:
		nums1 = [1,2,3,0,0,0], m = 3
		nums2 = [2,5,6],       n = 3
		输出: [1,2,2,3,5,6]
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
