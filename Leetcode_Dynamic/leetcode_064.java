package Leetcode_Dynamic;
/*
	��С·����

	����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��

	˵����ÿ��ֻ�����»��������ƶ�һ����

	ʾ��:

	����:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	���: 7
	����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��

*/

//��̬�滮�ķ���ֱ���޸�ԭ����

class leetcode_064 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 1 && n == 1){
            return grid[0][0];
        }
        for(int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int j=1; j<n; j++){
            grid[0][j] += grid[0][j-1];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("The minPath is: "+minPathSum(grid));
    }
}