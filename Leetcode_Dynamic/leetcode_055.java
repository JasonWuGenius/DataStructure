package Leetcode_Dynamic;

public class leetcode_055 {
	/*
	 * 跳跃游戏
	 * 
	 * 给定一个非负整数数组，你最初位于数组的第一个位置。
		数组中的每个元素代表你在该位置可以跳跃的最大长度。
		判断你是否能够到达最后一个位置。
		示例 1:
		输入: [2,3,1,1,4]
		输出: true
		解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
		示例 2:
		输入: [3,2,1,0,4]
		输出: false
		解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
	 */
	//贪心法
	/*
	 * 解题思路
	  贪心法的思路非常的简单，那就是，当跳到一个位置上，
		我们在当前位置到当前位置能达到的最大位置范围找到最大值，
		如果最大值的index + 最大值大于当前位置能达到的最大位置的index，
		那么选择跳到最大值的index去，反之则跳到当前位置能达到的最大位置。
	 */
	public static boolean canJump1(int[] nums){
		int index = 0;
		while(index < nums.length-1){
			if(nums[index] == 0){
				return false;
			}
			int max = Integer.MIN_VALUE;
			int maxIndex = 0;
			
			for(int i=index+1; i<nums.length && i<nums.length+nums[i]; i++){
				if(max < nums[i]){
					max = nums[i];
					maxIndex = i;
				}
			}
			
			if(maxIndex + max > index + nums[index]){
				index = maxIndex;
			}
			else{
				index = index + nums[index];
			}
		}
		return true;
	}
	public static boolean canJump2(int[] nums){
		int n = 1;
		for(int i=nums.length-2; i>=0; i--){
			if(nums[i] >= n){
				n = 1;
			}
			else{
				n++;
			}
			if(i==0 && n>1){
				return false;
			}
		}
		return true;
	}
	public static boolean canJump3(int[] nums){
		int n = nums.length;
		if(n == 1){
			return true;
		}
		int max = 0;
		for(int i=0; i<n-1; i++){
			if(max < i){
				return false;
			}
			max = Math.max(max, i+nums[i]);
			if(max >= n-1){
				return true;
			}
		}
		return false;
	}
	//动态规划
	public static boolean canJump4(int[] nums){
		boolean[] dp = new boolean[nums.length];
		dp[nums.length-1] = true;
		for(int i=nums.length-2; i>=0; i--){
			if(i+nums[i] >= nums.length-1){
				dp[i] = true;
			}
			for(int j=i; j<nums.length-1; j++){
				if(dp[j] && i+nums[i]>=j){
					dp[i] = true;
				}
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
//		int[] nums = {3,2,1,0,4};
		System.out.print("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nCan jump to the end: "+canJump4(nums));
	}

}
