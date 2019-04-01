package Leetcode_BinarySearch;

public class leetcode_033 {
	/**
	 * �����leetcode_081������֮��
	 * 
	 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
	 * ( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
	 * ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
	 * ����Լ��������в������ظ���Ԫ�ء�
	 * ����㷨ʱ�临�Ӷȱ����� O(log n) ����
	 * ʾ�� 1:
	 * ����: nums = [4,5,6,7,0,1,2], target = 0���: 4
	 * ʾ�� 2:
	 * ����: nums = [4,5,6,7,0,1,2], target = 3���: -1
	 */
	public int search(int[] nums, int target){
		if(nums.length == 0) return -1;
		int left = 0;
		int right = nums.length-1;
		while(left<right){
			int mid = left + (right-left)/2;
			if(nums[mid] == target){
				return mid;
			}
			else if(nums[left] == target){
				return left;
			}
			else if(nums[right] == target){
				return right;
			}
			else{
				if(nums[mid]>nums[left]){
					if(target>nums[mid]){
						left = mid+1;
					}
					else{
						if(target>nums[left]){
							right = mid-1;
						}
						else{
							left = mid+1;
						}
					}
				}
				else if(nums[mid]<nums[left]){
					if(target<nums[mid]){
						right = mid-1;
					}
					else{
						if(target<nums[right]){
							left = mid+1;
						}
						else{
							right = mid-1;
						}
					}
				}
				else{
					left++;//right--;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		leetcode_033 l033 = new leetcode_033();
		int nums[] = {4,5,6,7,0,1,2};
		int target = 3;
		System.out.println("The index of "+target+" is "+l033.search(nums, target));
	}

}
