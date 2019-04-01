package Leetcode_Array;

public class leetcode_334 {
	/*
	 * ��������Ԫ������
	 * 
	 * ����һ��δ��������飬�ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�
		��ѧ���ʽ����:
		������������� i, j, k,  ������ 0 �� i < j < k �� n-1��
		ʹ�� arr[i] < arr[j] < arr[k] ������ true ; ���򷵻� false ��
		˵��: Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ��
		ʾ�� 1:
		����: [1,2,3,4,5]
		���: true
		ʾ�� 2:
		����: [5,4,3,2,1]
		���: false
	 */
	public static boolean increasingTriplet1(int[] nums) {
		if(nums == null || nums.length <3){
			return false;
		}
		int n = nums.length;
		int little, middle, moreLittle;
		boolean moreLittleFlag = false;
		
		moreLittle = middle = little = nums[0];
		for(int i=1; i<n; i++){
			if(nums[i] > middle){
				if(little == middle){
					middle = nums[i];
				}
				else{
					return true;
				}
			}
			else if(nums[i] <= middle && nums[i] > little){
				middle = nums[i];
			}
			else{
				if(!moreLittleFlag){
					moreLittle = nums[i];
					moreLittleFlag = true;
				}
				else{
					if(nums[i] > moreLittle){
						little = moreLittle;
						middle = nums[i];
						moreLittleFlag = false;
					}
					else{
						moreLittle = nums[i];
					}
				}
			}
		}
		return false;
	}
	
	//������
	public static boolean increasingTriplet2(int[] nums){
        if(nums.length<3)
            return false;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>min2)
                return true;
            if(nums[i]<min1)
                min1=nums[i];
            if(nums[i]>min1&&nums[i]<min2)
                min2=nums[i];
        }
        return false;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
//		int[] nums = {5,4,3,2,1};
		System.out.print("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThere is increasingTriplet: "+increasingTriplet2(nums));
		
	}

}
