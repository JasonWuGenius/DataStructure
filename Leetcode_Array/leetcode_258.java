package Leetcode_Array;

/*
	缺失数字

	给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

	示例 1:

	输入: [3,0,1]
	输出: 2
	示例 2:

	输入: [9,6,4,2,3,5,7,0,1]
	输出: 8
*/
public class leetcode_258 {
    public static int missingNumber(int[] nums) {
		if(nums.length == 0){
			return -1;
		}
		int sum = nums.length;
		for(int i=0; i<nums.length; i++){
			sum ^= nums[i];
			sum ^= i;
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] nums = {9,6,4,2,3,5,7,0,1};
		System.out.println("The Nums:");
		for(int i: nums){
			System.out.print(i+" ");
		}
		System.out.println("\nTHe missingNumber: "+missingNumber(nums));
	}

}
