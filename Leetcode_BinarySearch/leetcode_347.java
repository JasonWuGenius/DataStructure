package Leetcode_BinarySearch;

import java.util.List;
import java.util.PriorityQueue;

public class leetcode_347 {
	/*
	 * 前K个高频元素
	 * 
	 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
		示例 1:
		输入: nums = [1,1,1,2,2,3], k = 2
		输出: [1,2]
		示例 2:
		输入: nums = [1], k = 1
		输出: [1]
		说明：
		你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
		你的算法的时间复杂度必须优于 O(nlogn) , n是数组的大小。
	 */
//	public static List<Integer> topKFrequent(int[] nums, int k){
//		
//	}
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.offer(3);
            pq.offer(-6);
            pq.offer(9);
            //打印结果为[-6, 3, 9]
            System.out.println(pq);
            //打印结果为-6
            System.out.println(pq.peek());
            //打印结果为-6
            System.out.println(pq.poll());
    }
}
