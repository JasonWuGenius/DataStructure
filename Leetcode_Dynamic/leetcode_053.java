package Leetcode_Dynamic;

/**
 * ��������
 * 
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * ����: [-2,1,-3,4,-1,2,1,-5,4],
 * ���: 6
 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
 */
public class leetcode_053 {
	//����һ
	public static int maxSubArray1(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int sum = nums[0];
		int max = nums[0];
		for(int i=1; i<nums.length; i++){
			if(sum > 0){
				sum += nums[i];
			}
			else{
				sum = nums[i];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
	//������
	public static int maxSubArray2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int curSum = nums[0];
		int maxSum = nums[0];
		for (int i=1; i<nums.length; i++){
			curSum = Math.max(curSum + nums[i], nums[i]);
			maxSum = Math.max(curSum, maxSum);
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("The result is:"+maxSubArray1(nums));
		System.out.println("The result is:"+maxSubArray2(nums));
	}
}










