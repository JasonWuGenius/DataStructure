package Leetcode_Design;

import java.util.Arrays;
import java.util.Random;

public class leetcode_384 {
	/*
	 * ��������
	 * 
	 * ����һ��û���ظ�Ԫ�ص����顣
		ʾ��:
		// �����ּ��� 1, 2 �� 3 ��ʼ�����顣
		int[] nums = {1,2,3};
		Solution solution = new Solution(nums);
		// �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ��
		solution.shuffle();
		// �������鵽���ĳ�ʼ״̬[1,2,3]��
		solution.reset();
		// �����������[1,2,3]���Һ�Ľ����
		solution.shuffle();
		
		���ǵ��͵�ϴ���㷨
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
		//ÿ��ֻ�õ�һ�������н���
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
