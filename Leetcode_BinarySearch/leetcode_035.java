package Leetcode_BinarySearch;

public class leetcode_035 {
	/*
	 * ��������λ��
	 * ��Ŀ����
		����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
		����Լ������������ظ�Ԫ�ء�
		ʾ�� 1:
		����: [1,3,5,6], 5���: 2
		ʾ�� 2:
		����: [1,3,5,6], 2���: 1
		ʾ�� 3:
		����: [1,3,5,6], 7���: 4
		ʾ�� 4:
		����: [1,3,5,6], 0���: 0
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
