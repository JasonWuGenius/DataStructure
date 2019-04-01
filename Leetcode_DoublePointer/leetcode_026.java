package Leetcode_DoublePointer;

public class leetcode_026 {
	/*
	 * ɾ�������������ظ���
	 * 
	 *  ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
		��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
		ʾ�� 1:
		�������� nums = [1,1,2], 
		����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 
		�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
		ʾ�� 2:
		���� nums = [0,0,1,1,1,2,2,3,3,4],
		����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
		�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
	 */	
	public static int removeDuplicates(int[] nums){
		if(nums == null){
			return 0;
		}
		int i=0, j=0;
		while(j<nums.length){
			if(nums[i] != nums[j]){
				nums[++i] = nums[j];
			}
			j++;
		}
		return i+1;
	}
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
//		int[] nums = {1,1,2};
		System.out.println("The List:");
		for(int item:nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe Length of the Changed List: "+removeDuplicates(nums));
	}

}
