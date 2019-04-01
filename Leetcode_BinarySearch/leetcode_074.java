package Leetcode_BinarySearch;

public class leetcode_074 {
	/*
	 * 在二维数组中搜索n
	 * 
	 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
		每行中的整数从左到右按升序排列。
		每行的第一个整数大于前一行的最后一个整数。
		示例 1:
		输入:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 3
		输出: true
		
		示例 2:
		输入:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 13
		输出: false
	 */
	//方法一：
	/*
	 * 这道题多数人看到这道题的时候，肯定就是想到剑指offer的思路.就是比较矩阵的右上角的数与target的大小，如果target比这个矩阵右上角的数大，由于矩阵的右上角元素A是A所在行的最大的值，所以target肯定不在A所在的行了，所以这时候就应该就在除去第一行的剩下的行中去找这个target;
		如果target比矩阵右上角的数A小，那么由于A所在的列中A是最小的，那么target就在除去最右边的列的其它的列；
		如果相等，返回true;
	 */
	public static boolean searchMatrix1(int[][] matrix, int target){
		if(matrix.length == 0){
			return false;
		}
		int rowIndex = 0;
		int colIndex = matrix[0].length-1;
		while(rowIndex < matrix.length && colIndex >= 0){
			if(target == matrix[rowIndex][colIndex])
				return true;
			else if(target > matrix[rowIndex][colIndex]){
				rowIndex++;
			}
			else{
				colIndex--;
			}
		}
		return false;
	}
	//方法二：二分查找的方法
	public static boolean searchMatrix2(int[][] matrix, int target){
		if(matrix.length == 0){
			return false;
		}
		int n = matrix[0].length;
		int left = 0;
		int right = matrix.length * matrix[0].length - 1;
		while(left <= right){
			int mid = left + (right - left)/2;
			if(target == matrix[mid/n][mid%n])
				return true;
			else if(target < matrix[mid/n][mid%n])
				right = mid-1;
			else
				left = mid+1;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
		System.out.println("The Matrix:");
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		int target = 3;
//		int target = 13;
		System.out.println("\nThe Target '"+target+"' is in the matrix: "+searchMatrix2(matrix, target));
	}

}
