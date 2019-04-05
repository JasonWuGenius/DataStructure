
/*
	螺旋矩阵2
	
	给定一个矩阵 A， 返回 A 的转置矩阵。

	矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

	 

	示例 1：

	输入：[[1,2,3],[4,5,6],[7,8,9]]
	输出：[[1,4,7],[2,5,8],[3,6,9]]
	示例 2：

	输入：[[1,2,3],[4,5,6]]
	输出：[[1,4],[2,5],[3,6]]
	 

	提示：

	1 <= A.length <= 1000
	1 <= A[0].length <= 1000

*/

//这个结题思路是参考排名击败100%用户的解法，思路很巧妙，代码也非常简洁

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1, j=0;
        while(c <= n*n){
            for(int i=j; i<n-j; i++)
                arr[j][i] = c++;
            for(int i=j+1; i<n-j; i++)
                arr[i][n-j-1] = c++;
            for(int i=n-j-2; i>=j; i--)
                arr[n-j-1][i] = c++;
            for(int i=n-j-2; i>j; i--)
                arr[i][j] = c++;
            
            j++;
        }
        return arr;
    }
}