package Leetcode_Array;
/*
	螺旋矩阵

	给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

	示例 1:

	输入:
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	输出: [1,2,3,6,9,8,7,4,5]
	示例 2:

	输入:
	[
	  [1, 2, 3, 4],
	  [5, 6, 7, 8],
	  [9,10,11,12]
	]
	输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

import java.util.ArrayList;
import java.util.List;

class leetcode_054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList<>();
    	if(matrix.length == 0) return res;
        int m = matrix.length,n = matrix[0].length;
        for(int i = 0; i < (Math.min(m,n)+1)/2; i++) {
            for(int j=i; j<=n-1-i; j++){
                res.add(matrix[i][j]);
            }
            for(int j=i+1; j<m-1-i; j++){
                res.add(matrix[j][n-1-i]);
            }
            if(m-1-i > i){
                for(int j=n-1-i; j>=i; j--){
                    res.add(matrix[m-1-i][j]);
                }
            }
            if(i<n-1-i){
                for(int j=m-1-i-1; j>i; j--){
                    res.add(matrix[j][i]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
        System.out.println("The matrix:");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The rotated matrix:"+spiralOrder(matrix));
    }
}
