package Leetcode_BinarySearch;

public class leetcode_075 {
	/*
	 * 颜色分类
	 * 
	 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
		此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
		注意:
		不能使用代码库中的排序函数来解决这道题。
		示例:
		输入: [2,0,2,1,1,0]
		输出: [0,0,1,1,2,2]
		进阶：
		一个直观的解决方案是使用计数排序的两趟扫描算法。
		首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
		你能想出一个仅使用常数空间的一趟扫描算法吗？
	 */
	//方法一：两次遍历
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
	
	//方法二：头尾双指针
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
			//i<=high必须加上，否则会出错
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
	//方法三：
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
