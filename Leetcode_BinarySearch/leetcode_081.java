package Leetcode_BinarySearch;

public class leetcode_081 {
	/**
	 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
	 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
	 * 示例 1:
	 * 输入: nums = [2,5,6,0,0,1,2], target = 0输出: true
	 * 示例 2:
	 * 输入: nums = [2,5,6,0,0,1,2], target = 3输出: false
	 * 
	 * nums[mid]=nums[left]
	 * 当着二者相等的时候，无法讨论，这是为啥呢？
	 * 这里举个例子，帮助大家理解。
	 * 对于数组
	 * [3,3,3,3,4,5,6,7]，nums[mid]=nums[left]对吧，这时候如果要找6,target=6,那么应该是left=mid+1;往6去逼近。
	 * 而对于数组
	 * [3,3,3,3,4,5,6,7,1,2,3,3,3,3,3,3,3,3,3,3,3,3],nums[mid]=nums[left]也是相等的对吧，但是这是候去找6，就应该是right=mid-1,去逼近这个6。
	 */
	public boolean search(int[] nums, int target){
		int left = 0;
		int right = nums.length-1;
		while(left<=right){
			int mid = left + (right-left)/2;
			if(nums[mid] == target || nums[left] == target || nums[right] == target)
				return true;
			if(nums[mid] > nums[left]){
				if(target > nums[mid])
					left = mid+1;
				else{
					if(target > nums[left])
						right = mid-1;
					else
						left = mid+1;
				}
			}
			else if(nums[mid] < nums[left]){
				if(target < nums[mid])
					right = mid-1;
				else{
					if(target > nums[left])
						right = mid-1;
					else
						left = mid+1;
				}
			}
			else{
				left++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		leetcode_081 l081 = new leetcode_081();
		int[] nums = {2,5,6,0,0,1,2};
		int target = 3;
		System.out.println("The result is : "+l081.search(nums, target));
	}
}
