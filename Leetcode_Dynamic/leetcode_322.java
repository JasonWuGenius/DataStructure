package Leetcode_Dynamic;

import java.util.Arrays;

public class leetcode_322 {
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
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println("The solution: "+coinChange(coins, amount));
	}

}
