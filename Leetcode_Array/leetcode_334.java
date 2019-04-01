package Leetcode_Array;

public class leetcode_334 {
	/*
	 * 递增的三元子序列
	 * 
	 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
		数学表达式如下:
		如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
		使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
		说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
		示例 1:
		输入: [1,2,3,4,5]
		输出: true
		示例 2:
		输入: [5,4,3,2,1]
		输出: false
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
	
	//方法二
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
