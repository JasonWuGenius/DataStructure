package Leetcode_BinarySearch;

public class leetcode_153 {
	/**
	 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
		( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
		���ҳ�������С��Ԫ�ء�
		����Լ��������в������ظ�Ԫ�ء�
		ʾ�� 1:
		����: [3,4,5,1,2]���: 1
		ʾ�� 2:
		����: [4,5,6,7,0,1,2]���: 0
	 */
	public int findMin(int[] nums){
		if(nums.length == 1)
			return nums[0];
		if(nums[0]<nums[nums.length-1])
			return nums[0];
		int left = 0;
		int right = nums.length-1;
		while(left<right){
			int mid = (left + right)/2;
			if(mid+1<nums.length && nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1]){
				return nums[mid];
			}
			else if(left >= 1 && left+1<nums.length && nums[left]<nums[left-1] && nums[left]<nums[left+1]){
				return nums[left];
			}
			else if(right >= 1 && right+1<nums.length && nums[right]<nums[right-1] && nums[right]<nums[right+1]){
				return nums[right];
			}
			else if(nums[mid]>nums[0]){
				left = mid+1;
			}
			else{
				right = mid-1;
			}
		}
		return nums[0]<nums[nums.length-1]? nums[0]:nums[nums.length-1];
	}
	
	public static void main(String[] args) {
		leetcode_153 l153 = new leetcode_153();
		int[] nums = {4,5,6,7,0,1,2};
//		int[] nums = {3,4,5,1,2};
		System.out.print("The Nums: ");
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
			if(i == nums.length-1){
				System.out.println();
			}
		}
		System.out.println("The minimum of the nums is :"+l153.findMin(nums));
	}

}
