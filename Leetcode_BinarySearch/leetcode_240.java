package Leetcode_BinarySearch;

public class leetcode_240 {
	/*
	 * 搜索二维矩阵
	 * 
	 * Medium
	 * 在二维数组中搜索一个数 和leetcode_074相似
	 * 
	 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
		每行的元素从左到右升序排列。
		每列的元素从上到下升序排列。
		示例:
		现有矩阵 matrix 如下：
		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
		给定 target = 5，返回 true。
		给定 target = 20，返回 false。
		昨天的题目：每天一道leetcode-74 在二维数组中搜索n
		这道题和昨天的那道题不同地方是昨天的那道题每行的·最末尾的数字必然小于下一行的开头的数字，
		今天这个题目每行的·最末尾的数字与下一行的开头的数字没有必然的联系
	 */
	//方法一：
	public static boolean searchMatrix1(int[][] matrix, int target){
		if(matrix.length == 0){
			return false;
		}
		int begin = 0;
		int end = matrix.length-1;
		int midRow = (begin+end)/2;
		while(begin<=end){
			midRow = (begin+end)/2;
			if(matrix[midRow][0] == target)
				return true;
			else if(matrix[midRow][0] > target)
				end = midRow-1;
			else
				begin = midRow+1;
		}
		for(int i=0; i<midRow; i++){
			int left = 0;
			int right = matrix[0].length-1;
			while(left<=right){
				int mid=(left+right)/2;
				if(matrix[i][mid] == target)
					return true;
				else if(matrix[i][mid] > target)
					right = mid-1;
				else
					left = mid+1;
			}
		}
		return false;
	}
	//方法二：
	public static boolean searchMatrix2(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		int m = 0;
		int n = matrix[0].length-1; 
		while(m<matrix.length && n>=0){
			if(matrix[m][n] == target){
				return true;
			}
			if(matrix[m][n] < target){
				m++;
			}
			else{
				n--;
			}
		}
		return false;
	}
	//方法三：主要试一下size()
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while(m<matrix.length && n>=0){
            if(matrix[m][n] == target){
                return true;
            }
            if(matrix[m][n] > target){
                n--;
            }
            else{
                m++;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,5,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
		System.out.println("The Matrix:");
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		int target = 5;
//		int target = 20;
		System.out.println("\nThe Target '"+target+"' is in the matrix: "+searchMatrix3(matrix, target));
	}


}
