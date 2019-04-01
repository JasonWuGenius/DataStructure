package Leetcode_BinarySearch;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

public class leetcode_034 {
	/*
	 * 在排序数组中查找元素的第一个和最后一个的位置
	 * 
	 * 题目详述
		给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
		你的算法时间复杂度必须是 O(log n) 级别。
		如果数组中不存在目标值，返回 [-1, -1]。
		示例 1:
		输入: nums = [5,7,7,8,8,10], target = 8输出: [3,4]
		示例 2:
		输入: nums = [5,7,7,8,8,10], target = 6输出: [-1,-1]
		
		思路
		有序和数组这个两个字眼结合起来，肯定是要用到二分查找这一类；
		首先就是找最左侧的下标，利用二分查找首先是找到有一个值是与目标值target是相等的，然后因为是找最左侧的下标，所以把right=mid-1来一直往左边去逼近最左侧的值；
		至于找最右侧的下标就是，将left=mid+1,来去逼近最右侧的下标；
		如果没有找到则说明不存在返回-1；
	 */
	public static int[] searchRange(int[] nums, int target){
		int[] result = {-1, -1};
		result[0] = findLeftIndex(nums, target);
		if(result[0] != -1){
			result[1] = findRightIndex(nums, result[0], target);
		}
		return result;
	}
	public static int findLeftIndex(int[] nums, int target){
		int left = 0;
		int right = nums.length-1;
		int leftIndex = -1;
		while(left <= right){
			int mid = left + (right - left)/2;
			if(nums[mid]<target){
				left = mid+1;
			}
			else if(nums[mid]>target){
				right = mid-1;
			}
			else{
				leftIndex = mid;
				right = mid-1;
			}
		}
		return leftIndex;
	}
	public static int findRightIndex(int[] nums, int left, int target){
		int right = nums.length-1;
		int rightIndex = -1;
		while(left<=right){
			int mid = left + (right - left)/2;
			if(nums[mid]<target){
				left = mid+1;
			}
			else if(nums[mid]>target){
				right = mid-1;
			}
			else{
				rightIndex = mid;
				left = mid+1;
			}
		}
		return rightIndex;
	}
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
//		int target = 6;
		int[] result = searchRange(nums, target);
		System.out.println("The index of the target nums is :");
		for(int item:result){
			System.out.print(item+" ");
		}
	}
}
