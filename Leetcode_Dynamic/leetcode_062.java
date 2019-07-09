package Leetcode_Dynamic;

/*
 * ��ͬ·��
 * 
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
	������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
	���ܹ��ж�������ͬ��·����
	˵����m �� n ��ֵ�������� 100��
	ʾ�� 1:
	����: m = 3, n = 2
	���: 3
	����:
	�����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
	1. ���� -> ���� -> ����
	2. ���� -> ���� -> ����
	3. ���� -> ���� -> ����
	ʾ�� 2:
	����: m = 7, n = 3
	���: 28
 */
public class leetcode_062 {
	
	//����һ��������һ������m+n-2��������m+n-2������m-1�������߲��������𣿼�C����m+n-2������m-1������
	
	//��������ʹ���������ʧȥ����Ŀ�������ˡ��ڶ��ַ���ʹ�ö�̬�滮�ķ���
	public static int uniquePaths(int m, int n){
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(i == 0 || j == 0){
					dp[i][j] = 1;
				}
				else{
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		System.out.println("m: "+m+" n:"+n);
		System.out.println("The uniquePath are: "+uniquePaths(m, n));
	}

}
