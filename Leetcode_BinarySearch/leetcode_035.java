package Leetcode_BinarySearch;

public class leetcode_035 {
	/*
	 * 搜索插入位置
	 * 题目详述
		给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
		你可以假设数组中无重复元素。
		示例 1:
		输入: [1,3,5,6], 5输出: 2
		示例 2:
		输入: [1,3,5,6], 2输出: 1
		示例 3:
		输入: [1,3,5,6], 7输出: 4
		示例 4:
		输入: [1,3,5,6], 0输出: 0
	 */
	public static int searchInsert(int[] nums, int target){
		if(nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			if(nums[0]<target){
				return 1;
			}
			return 0;
		}
		int left = 0;
		int right = nums.length-1;
		while(left <= right){
			if(left == right){
				if(nums[left] == target){
					return left;
				}
				break;
			}
			int mid = left + (right - left)/2;
			if(nums[mid] == target){
				return mid;
			}
			else if(nums[mid] > target){
				right = mid - 1;
			}
			else{
				left = mid + 1;
			}
		}
		if(nums[left] > target){
			return left;
		}
		return left+1;
	}
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int[] targets = {5,2,7,0};
		System.out.println("The nums is: ");
		for(int num:nums){
			System.out.print(num+" ");
		}
		for(int target:targets){
			System.out.print("\nTarget is : "+target+"  The result is:"+searchInsert(nums, target));
		}
	}

}
