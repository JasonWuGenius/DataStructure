package Leetcode_Dynamic;

import java.util.Arrays;

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
public class leetcode_198 {
	//��������ʹ��dp[i]��ʾ��i�䷿���ܹ�͵�Ե�����߽�numa[i]��ʾ��i�䷿�ݴ�ŵĽ�
	//���ڵ�n�䷿�ݣ��ܹ�͵�Ե�����߽����dp[i-1]��dp[i-2]+nums[i]
	public static int rob3(int[] nums){
		int len = nums.length;
		if(len <= 1){
			return len==0? 0:nums[0];
		}
		int[] memo = new int[len];
		memo[0] = nums[0];
		memo[1] = Math.max(nums[0], nums[1]);
		for(int i=2; i<nums.length; i++){
			memo[i] = Math.max(memo[i-1], memo[i-2]+nums[i]);
		}
		return memo[len-1];
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
