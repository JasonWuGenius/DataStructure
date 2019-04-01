package Leetcode_BinarySearch;

public class leetcode_081 {
	/**
	 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
	 * ( ���磬���� [0,0,1,2,2,5,6] ���ܱ�Ϊ [2,5,6,0,0,1,2] )��
	 * ��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ��� true�����򷵻� false��
	 * ʾ�� 1:
	 * ����: nums = [2,5,6,0,0,1,2], target = 0���: true
	 * ʾ�� 2:
	 * ����: nums = [2,5,6,0,0,1,2], target = 3���: false
	 * 
	 * nums[mid]=nums[left]
	 * ���Ŷ�����ȵ�ʱ���޷����ۣ�����Ϊɶ�أ�
	 * ����ٸ����ӣ����������⡣
	 * ��������
	 * [3,3,3,3,4,5,6,7]��nums[mid]=nums[left]�԰ɣ���ʱ�����Ҫ��6,target=6,��ôӦ����left=mid+1;��6ȥ�ƽ���
	 * ����������
	 * [3,3,3,3,4,5,6,7,1,2,3,3,3,3,3,3,3,3,3,3,3,3],nums[mid]=nums[left]Ҳ����ȵĶ԰ɣ��������Ǻ�ȥ��6����Ӧ����right=mid-1,ȥ�ƽ����6��
	 */
	public boolean search(int[] nums, int target){
		int left = 0;
		int right = nums.length-1;
		while(left<=right){
			int mid = left + (right-left)/2;
			if(nums[mid] == target || nums[left] == target || nums[right] == target)
				return true;
			if(nums[mid] > nums[left]){
				if(target > nums[mid])
					left = mid+1;
				else{
					if(target > nums[left])
						right = mid-1;
					else
						left = mid+1;
				}
			}
			else if(nums[mid] < nums[left]){
				if(target < nums[mid])
					right = mid-1;
				else{
					if(target > nums[left])
						right = mid-1;
					else
						left = mid+1;
				}
			}
			else{
				left++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		leetcode_081 l081 = new leetcode_081();
		int[] nums = {2,5,6,0,0,1,2};
		int target = 3;
		System.out.println("The result is : "+l081.search(nums, target));
	}
}
