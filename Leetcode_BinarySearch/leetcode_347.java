package Leetcode_BinarySearch;

import java.util.List;
import java.util.PriorityQueue;

public class leetcode_347 {
	/*
	 * ǰK����ƵԪ��
	 * 
	 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
		ʾ�� 1:
		����: nums = [1,1,1,2,2,3], k = 2
		���: [1,2]
		ʾ�� 2:
		����: nums = [1], k = 1
		���: [1]
		˵����
		����Լ�������� k ���Ǻ���ģ��� 1 �� k �� �����в���ͬ��Ԫ�صĸ�����
		����㷨��ʱ�临�Ӷȱ������� O(nlogn) , n������Ĵ�С��
	 */
//	public static List<Integer> topKFrequent(int[] nums, int k){
//		
//	}
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.offer(3);
            pq.offer(-6);
            pq.offer(9);
            //��ӡ���Ϊ[-6, 3, 9]
            System.out.println(pq);
            //��ӡ���Ϊ-6
            System.out.println(pq.peek());
            //��ӡ���Ϊ-6
            System.out.println(pq.poll());
    }
}
