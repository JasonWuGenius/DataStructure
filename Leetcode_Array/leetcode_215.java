package Leetcode_Array;

import java.util.PriorityQueue;

public class leetcode_215 {
	/*
	 * �����еĵ�K�����Ԫ��
	 * 
	 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
		ʾ�� 1:
		����: [3,2,1,5,6,4] �� k = 2
		���: 5
		ʾ�� 2:
		����: [3,2,3,1,2,4,5,5,6] �� k = 4
		���: 4
		˵��:
		����Լ��� k ������Ч�ģ��� 1 �� k �� ����ĳ��ȡ�
	 */
    public static int findKthLargest(int[] nums, int k) {
        if(k > nums.length || k < 1){
            return Integer.MIN_VALUE;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0; i<k; i++){
            pq.add(nums[i]);
        }
        for(int i=k; i<nums.length; i++){
            if(nums[i] > pq.peek()){
            	System.out.println("The peek: "+pq.peek());
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 3;
		System.out.println("The KthLargest is: "+findKthLargest(nums, k));
	}

}
