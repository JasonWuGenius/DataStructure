package Leetcode_Design;

import java.util.Arrays;
import java.util.Random;

public class leetcode_384 {
	/*
	 * 打乱数组
	 * 
	 * 打乱一个没有重复元素的数组。
		示例:
		// 以数字集合 1, 2 和 3 初始化数组。
		int[] nums = {1,2,3};
		Solution solution = new Solution(nums);
		// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
		solution.shuffle();
		// 重设数组到它的初始状态[1,2,3]。
		solution.reset();
		// 随机返回数组[1,2,3]打乱后的结果。
		solution.shuffle();
		
		这是典型的洗牌算法
	 */
	private int[] nums;
	private int[] originalNums;
	
	public leetcode_384(int[] nums){
		this.nums = nums;
		this.originalNums = Arrays.copyOf(nums, nums.length);
	}
	
	public int[] reset(){
		return this.originalNums;
	}
	public int[] shuffle(){
		//每次只拿第一个数进行交换
		Random random = new Random();
		for(int i=0; i<nums.length/2; i++){
			swap(nums, 0, random.nextInt(nums.length));
		}
		return nums;
	}
	
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		leetcode_384 l384 = new leetcode_384(nums);
		System.out.println("The Nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe shuffle: ");
		for(int item: l384.shuffle()){
			System.out.print(item+" ");
		}
		System.out.println("\nThe reset: ");
		for(int item: l384.reset()){
			System.out.print(item+" ");
		}
	}

}
