package Leetcode_BinarySearch;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

public class leetcode_034 {
	/*
	 * �����������в���Ԫ�صĵ�һ�������һ����λ��
	 * 
	 * ��Ŀ����
		����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
		����㷨ʱ�临�Ӷȱ����� O(log n) ����
		��������в�����Ŀ��ֵ������ [-1, -1]��
		ʾ�� 1:
		����: nums = [5,7,7,8,8,10], target = 8���: [3,4]
		ʾ�� 2:
		����: nums = [5,7,7,8,8,10], target = 6���: [-1,-1]
		
		˼·
		�������������������۽���������϶���Ҫ�õ����ֲ�����һ�ࣻ
		���Ⱦ������������±꣬���ö��ֲ����������ҵ���һ��ֵ����Ŀ��ֵtarget����ȵģ�Ȼ����Ϊ�����������±꣬���԰�right=mid-1��һֱ�����ȥ�ƽ�������ֵ��
		���������Ҳ���±���ǣ���left=mid+1,��ȥ�ƽ����Ҳ���±ꣻ
		���û���ҵ���˵�������ڷ���-1��
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
