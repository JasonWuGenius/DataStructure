package Leetcode_Dynamic;

import java.util.Arrays;

public class leetcode_198 {
	/*
	 * 打家劫舍
	 * 
	 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
		给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
		示例 1:
		输入: [1,2,3,1]
		输出: 4
		解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
		     偷窃到的最高金额 = 1 + 3 = 4 。
		示例 2:
		输入: [2,7,9,3,1]
		输出: 12
		解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
		     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
	 */
	private static int[] memo;
	
	//方法一：记忆化搜索
	public static int rob1(int[] nums){
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return tryRob(nums, 0);
	}
	public static int tryRob(int[] nums, int index){
		if(index >= nums.length){
			return 0;
		}
		//记忆化搜索可以避免重叠子问题的重复搜索
		if(memo[index] != -1){
			return memo[index];
		}
		//下面是对状态转移方程的描述
		int res = 0;
		for(int i=index; i<nums.length; i++){
			res = Math.max(res, nums[i]+tryRob(nums, i+2));
		}
		memo[index] = res;
		return res;
	}
	//方法二：动态规划
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
	//方法三：使用dp[i]表示第i间房屋能够偷窃到的最高金额，numa[i]表示第i间房屋存放的金额。
	//对于第n间房屋，能够偷窃到的最高金额是dp[i-1]或dp[i-2]+nums[i]
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
