package Leetcode_Array;

public class leetcode_665 {
	/**
	 * 非递减数列
	 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
	 * 输入: [4,2,3]
	 * 输出: True
	 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
	 */
    public boolean checkPossibility(int[] nums) {
        int i = 0,j = nums.length - 1;
        while(i < j && nums[i] <= nums[i + 1])
            i++;
        while(i < j && nums[j] >= nums[j - 1])
            j--;
        System.out.println(i + "----" + j);
        int head = 0;
        if(i == 0)
            head = Integer.MIN_VALUE;
        else
            head = nums[i - 1];
        int next = (j==nums.length - 1)?Integer.MAX_VALUE:nums[j + 1];
        if(j - i <= 1 && (head <= nums[j] || nums[i] <= next))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
		leetcode_665 l665 = new leetcode_665();
		int[] nums = {1, 2, 9, 8, 5, 6, 7};
		System.out.println("The result is :"+l665.checkPossibility(nums));
	}


}
