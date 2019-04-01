package Leetcode_BinarySearch;

public class leetcode_075 {
	/*
	 * ��ɫ����
	 * 
	 * ����һ��������ɫ����ɫ����ɫ��һ�� n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�
		�����У�����ʹ������ 0�� 1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
		ע��:
		����ʹ�ô�����е����������������⡣
		ʾ��:
		����: [2,0,2,1,1,0]
		���: [0,0,1,1,2,2]
		���ף�
		һ��ֱ�۵Ľ��������ʹ�ü������������ɨ���㷨��
		���ȣ����������0��1 �� 2 Ԫ�صĸ�����Ȼ����0��1��2��������д��ǰ���顣
		�������һ����ʹ�ó����ռ��һ��ɨ���㷨��
	 */
	//����һ�����α���
	public static void sortColors1(int[] nums){
		int[] colors = new int[3];
		for(int i=0; i<nums.length; i++){
			colors[nums[i]]++;
		}
		int index = 0;
		for(int i=0; i<colors.length; i++){
			while(colors[i] != 0){
				nums[index] = i;
				colors[i]--;
				index++;
			}
		}
	}
	
	//��������ͷβ˫ָ��
	public static void sortColors2(int[] nums){
		if(nums == null || nums.length <= 1){
			return;
		}
		int low=0, high=nums.length-1;
		for(int i=0; i<nums.length; i++){
			if(nums[i]==0){
				int temp = nums[i];
				nums[i] = nums[low];
				nums[low] = temp;
				low++;
			}
			//i<=high������ϣ���������
			else if(i<=high && nums[i]==2){
				int temp = nums[i];
				nums[i] = nums[high];
				nums[high] = temp;
				high--;
			}
		}
	}
	public static void swap(int i, int j){
		int temp = i;
		i = j;
		j = temp;
	}
	//��������
	public static void sortColors3(int[] nums){
		if(nums == null || nums.length <= 1){
			return;
		}
		int i=0, j=0, k=0;
		for(int m=0; m<nums.length; m++){
			int temp = nums[m];
			if(temp == 0){
				nums[k++] = 2;
				nums[j++] = 1;
				nums[i++] = 0;
			}
			else if(temp == 1){
				nums[k++] = 2;
				nums[j++] = 1;
			}
			else{
				nums[k++] = 2;
			}
			
		}
	}
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		System.out.println("The origin nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		sortColors2(nums);
		System.out.println("\nThe sorted nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
	}

}
