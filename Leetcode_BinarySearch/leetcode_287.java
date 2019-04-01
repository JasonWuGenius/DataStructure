package Leetcode_BinarySearch;

public class leetcode_287 {
	/*
	 * 寻找重复数字
	 * 
	 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
		示例 1:
		输入: [1,3,4,2,2]
		输出: 2
		示例 2:
		输入: [3,1,3,4,2]
		输出: 3
		说明：
		不能更改原数组（假设数组是只读的）。
		只能使用额外的 O(1) 的空间。
		时间复杂度小于 O(n2) 。
		数组中只有一个重复的数字，但它可能不止重复出现一次。
	 */
	
	/*
	 * 思路
		1、第一时间想到了使用一个hashmap去存储每一个数字，然后如何遇到相同的数字，那么直接返回即可，但发现题目是不让使用额外的空间；
		2、而如果使用排序的方法，先排好序，然后依次遍历，但是题目明确说了不能更改原数组，数组的顺序是不可以改变的，所以这条路也行不通了；
		3、最后，由于这道题目的分类是二分查找类别，所以思考着怎么往二分查找这里靠；
		4、对于包括n+1个数字的数组，每个数字的范围是在[1,n],所以肯定会有一个数字出现了两次，比如说n取4，也就是5个数字，但取值范围是[1,4],所以你为了避免不出现重复数字，前4个取1,2,3,4，第5个你取值范围是【1,4】，所以肯定会有重复数字出现的；
		5、根据上述的特点，我们每次去取中的数,比如第一次取（1+n）/2这个数，每次去遍历整个数组中有多少小于等于这个数，如果遍历结束以后，计数的个数大于（1+n）/2,就说明在小于这个数字肯定出现重复了，这个时候缩小右边界的范围到这个（1+n）/2这个数字。然后继续重复这个过程；
		6、直到左边界与右边界的范围重合，那么这个数字就是我们要找的数字。
	 */
	public static int findDuplicate(int[] nums){
		int low = 1;
		int high = nums.length;
		int mid = low + (high - low)/2;
		while(low<high){
			int count = 0;
			mid = low + (high - low)/2;
			for(int i=0; i<nums.length; i++){
				if(nums[i] <= mid){
					count++;
				}
			}
			if(count > mid)
				high = mid;
			else
				low = mid+1;
		}
		return low;
	}
	public static void main(String[] args) {
//		int[] nums = {1,3,4,2,2};
		int[] nums = {3,1,3,4,2};
		System.out.println("The duplicate num is: "+findDuplicate(nums));
	}

}
