package Leetcode_DoublePointer;

public class leetcode_080 {
	/* Medium - 不确定
	 * 
	 * 删除排序数组中重复项2
	 * 这题和26有相似之处，主要在于，每个数字重复次数可以为2次。
	 * 
	 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
		不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
		示例 1:
		给定 nums = [1,1,1,2,2,3],
		函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
		你不需要考虑数组中超出新长度后面的元素。
		示例 2:
		给定 nums = [0,0,1,1,1,1,2,3,3],
		函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
	 */
	public static int removeDuplicates(int[] nums) {
        if(nums.length < 3 ) return nums.length;
        int j = 0;
        int count = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            if(count < 2){
                nums[j++] = nums[i - 1];
            }
            if(i != nums.length && nums[i - 1] == nums[i]){
                count++;
            }else{
                count = 0;
            }
        }
        return j;
    }
	
	public static int removeDuplicates1(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int i=0;
		int j=0;
		int count=0;
		while(j<nums.length){
			if(nums[i]!=nums[j] && count<3){
				nums[i++] = nums[j];
				count++;
			}
			else{
				count++;
			}
			j++;
		}
		return 0;
			
	}
	public static int removeDuplicates(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int i=0;
		int j=2;
		while(j<nums.length){
			if(nums[j] == nums[j-2]){
				j = i;
			}
			j++;
		}
	}
    public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println("The Length of The Changed List: "+removeDuplicates(nums));
	}
}
