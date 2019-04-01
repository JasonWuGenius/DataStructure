package Leetcode_Dynamic;

public class leetcode_053 {
	/**
	 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
	 * ����: [-2,1,-3,4,-1,2,1,-5,4],
	 * ���: 6
	 * ����: ���������� [4,-1,2,1] �ĺ����Ϊ 6��
	 */
	//����һ
	public int maxSubArray1(int[] nums){
		int res = nums[0];
		int sum = 0;
		for(int num:nums){
			if(sum>0){
				sum += num;
				System.out.println("1:sum:"+sum);
			}
			else{
				sum = num;
				System.out.println("2:sum:"+sum);
			}
			res = Math.max(res, sum);
		}
		return res;
	}
	//������
	public int maxSubArray2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int curSum = nums[0];
		int maxSum = nums[0];
		for (int i=1; i<nums.length; i++){
			curSum = Math.max(curSum + nums[i], nums[i]);
			System.out.println("curSum:"+curSum);
			maxSum = Math.max(curSum, maxSum);
			System.out.println("maxSum:"+maxSum);
		}
		return maxSum;
	}
	public static void main(String[] args) {
		leetcode_053 l053 = new leetcode_053();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		System.out.println("The result is:"+l053.maxSubArray1(nums));
		System.out.println("The result is:"+l053.maxSubArray2(nums));
	}
}










