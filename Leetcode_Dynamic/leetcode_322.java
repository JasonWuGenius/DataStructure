package Leetcode_Dynamic;

import java.util.Arrays;

/*
 * 零钱兑换
 * 
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
	示例 1:
	输入: coins = [1, 2, 5], amount = 11
	输出: 3 
	解释: 11 = 5 + 5 + 1
	示例 2:
	输入: coins = [2], amount = 3
	输出: -1
 */
public class leetcode_322 {
	//动态规划
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
