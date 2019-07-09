package Leetcode_Dynamic;
/*
	��������С·����

	����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�

	���磬���������Σ�

	[
		 [2],
		[3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	�Զ����µ���С·����Ϊ 11������2 + 3 + 5 + 1 = 11����

	˵����

	��������ֻʹ�� O(n) �Ķ���ռ䣨n Ϊ�����ε��������������������⣬��ô����㷨��ܼӷ֡�
*/

//��̬�滮˼·

//�ö�ά����Ľⷨ
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        for(int i=triangle.size()-1; i>=0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j=0; j<curTr.size(); j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1])+curTr.get(j);
            }
        }
        return dp[0][0];
    }
}


//��һά����Ľⷨ
//һά����Ľⷨ���ӵ����ͬʱ�Կռ俪����С
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int[] dp = new int[triangle.size()+1];
        for(int i=triangle.size()-1; i>=0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j=0; j<curTr.size(); j++){
                dp[j] = Math.min(dp[j], dp[j+1])+curTr.get(j);
            }
        }
        return dp[0];
    }
}