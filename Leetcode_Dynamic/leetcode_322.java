package Leetcode_Dynamic;

import java.util.Arrays;

/*
 * ��Ǯ�һ�
 * 
 * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ����� -1��
	ʾ�� 1:
	����: coins = [1, 2, 5], amount = 11
	���: 3 
	����: 11 = 5 + 5 + 1
	ʾ�� 2:
	����: coins = [2], amount = 3
	���: -1
 */

/**
 * 
 * 
	�Ƚϵ��͵Ķ�̬�滮���⡣
	
	���� f(n) ����Ҫ������Ϊ n ��Ҫ�õ�����Ӳ����������ô�У�
	
	f(n) = min(f(n - c1), f(n - c2), ... f(n - cn)) + 1
	���� c1 ~ cn ΪӲ�ҵ�������
	
	�پ������һ�������ʽ�ɣ��������ʾ����
	
	����: coins = [1, 2, 5], amount = 11
	���: 3 
	����: 11 = 5 + 5 + 1
	��Ŀ���ֵΪ f(11)����һ��ѡ��Ӳ��ʱ����������ѡ��
	
	��������ȡ���Ϊ 1 ��Ӳ�ң���ô��������Ҫ������ܽ���Ϊ 11 - 1 = 10��
	�� f(11) = f(10) + 1������� +1 ��������ȡ�������Ϊ 1 ��Ӳ�ҡ�
	
	ͬ�����ȡ���Ϊ 2 �����Ϊ 5 ��Ӳ�ҿ��Եõ���
	
	f(11) = f(9) + 1
	f(11) = f(6) + 1
	���ԣ�
	
	f(11) = min(f(10), f(9), f(6)) + 1
 */


public class leetcode_322 {
	//��̬�滮
	public static int coinChange(int[] coins, int amount){
		int[] memo = new int[amount+1];
		Arrays.fill(memo, amount+1);
		for(int i=1; i<=amount; i++){
			for(int coin: coins){
				if(i-coin>=0){
					memo[i] = Math.min(memo[i], memo[i-coin]+1);
				}
			}
		}
		return memo[amount] == amount+1? -1:memo[amount];
	}

	public static int coinChange1(int[] coins, int amount){
		int[] dp = new int[amount+1];
		for(int i=1; i<amount+1; i++){
			dp[i] = amount+1;
		}
		dp[0]=0;
		for(int i=1; i<amount+1; i++){
			for(int j=0; j<coins.length; j++){
				dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
			}
		}
		if(dp[amount] == amount+1){
			return -1;
		}
		return dp[amount];
	}
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println("The solution: "+coinChange(coins, amount));
	}

}
