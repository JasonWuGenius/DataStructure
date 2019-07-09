package Leetcode_Dynamic;
/*
	��ͬ·��2

    һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
	������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
	���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
	�����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
	˵����m �� n ��ֵ�������� 100��

	ʾ�� 1:

	����:
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	���: 2
	����:
	3x3 ��������м���һ���ϰ��
	�����Ͻǵ����½�һ���� 2 ����ͬ��·����
	1. ���� -> ���� -> ���� -> ����
	2. ���� -> ���� -> ���� -> ����

*/

//��̬�滮˼·

class leetcode_063 {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        boolean barrier = false;
        for(int i=0; i<n; i++){
            if(matrix[0][i] == 1){
                barrier = true;
            }
            if(barrier){
                break;
            }
            dp[0][i] = 1;
        }
        barrier = false;
        for(int i=0; i<m; i++){
            if(matrix[m][0] == 1){
                barrier = true;
            }
            if(barrier){
                break;
            }
            dp[i][0] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}