package Leetcode_BinarySearch;

public class leetcode_162 {
	/*
	 * Ѱ�ҷ�ֵ
	 * 
	 * ��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�
		����һ���������� nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������
		������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�
		����Լ��� nums[-1] = nums[n] = -�ޡ�
		ʾ�� 1:
		����: nums = [1,2,3,1]
		���: 2
		����: 3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
		ʾ�� 2:
		����: nums = [1,2,1,3,5,6,4]
		���: 1 �� 5 
		����: ��ĺ������Է������� 1�����ֵԪ��Ϊ 2��
		     ���߷������� 5�� ���ֵԪ��Ϊ 6��
		˵��:
		��ĽⷨӦ���� O(logN) ʱ�临�Ӷȵġ�
	 */
	public static int findPeakElement(int[] nums){
		if(nums == null || nums.length <= 1){
			return nums == null || nums.length == 0? -1:0;
		}
		int left = 0, right = nums.length-1;
		while(left < right){
			int mid = (left+right)/2;
			if(nums[mid] < nums[mid+1])
				left = mid+1;
			else{
				right = mid;
			}
		}
		return left;
	}
	public static void main(String[] args) {
//		int[] nums = {1,2,3,1};
		int[] nums = {1,2,1,3,5,6,4};
		System.out.print("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe peak element: "+findPeakElement(nums));
	}

}
