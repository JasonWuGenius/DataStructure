package Leetcode_Dynamic;

import java.util.Arrays;

public class leetcode_198 {
	/*
	 * ��ҽ���
	 * 
	 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
		����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
		ʾ�� 1:
		����: [1,2,3,1]
		���: 4
		����: ͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
		     ͵�Ե�����߽�� = 1 + 3 = 4 ��
		ʾ�� 2:
		����: [2,7,9,3,1]
		���: 12
		����: ͵�� 1 �ŷ��� (��� = 2), ͵�� 3 �ŷ��� (��� = 9)������͵�� 5 �ŷ��� (��� = 1)��
		     ͵�Ե�����߽�� = 2 + 9 + 1 = 12 ��
	 */
	private static int[] memo;
	
	//����һ�����仯����
	public static int rob1(int[] nums){
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return tryRob(nums, 0);
	}
	public static int tryRob(int[] nums, int index){
		if(index >= nums.length){
			return 0;
		}
		//���仯�������Ա����ص���������ظ�����
		if(memo[index] != -1){
			return memo[index];
		}
		//�����Ƕ�״̬ת�Ʒ��̵�����
		int res = 0;
		for(int i=index; i<nums.length; i++){
			res = Math.max(res, nums[i]+tryRob(nums, i+2));
		}
		memo[index] = res;
		return res;
	}
	//����������̬�滮
	public static int rob2(int[] nums){
		int n = nums.length;
		if(n == 0){
			return 0;
		}
		int[] memo = new int[n];
		memo[n-1] = nums[n-1];
		for(int i=n-2; i>=0; i--){
			memo[i] = Math.max(nums[i]+(i+2>=n? 0:memo[i+2]), nums[i+1]+(i+3>=n?0:memo[i+3]));
		}
		return memo[0];
	}
	//��������ʹ��dp[i]��ʾ��i�䷿���ܹ�͵�Ե�����߽�numa[i]��ʾ��i�䷿�ݴ�ŵĽ�
	//���ڵ�n�䷿�ݣ��ܹ�͵�Ե�����߽����dp[i-1]��dp[i-2]+nums[i]
	public static int rob3(int[] nums){
		int len = nums.length;
		if(len <= 0){
			return 0;
		}
		int[] dp = new int[len+1];
		dp[0] = 0;
		dp[1] = nums[0];
		for(int i=1; i<len; ++i){
			dp[i+1] = Math.max(dp[i], nums[i]+dp[i-1]);
		}
		return dp[len];
	}
	public static void main(String[] args) {
//		int[] nums = {1,2,3,1};
		int[] nums = {2,7,9,3,1};
		System.out.println("The Money: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe result: "+rob3(nums));
	}

}
