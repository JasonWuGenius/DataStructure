package Leetcode_Dynamic;
/*
	三角形最小路径和

	给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

	例如，给定三角形：

	[
		 [2],
		[3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

	说明：

	如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 动态规划思路
class leetcode_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int[] dp = new int[triangle.size()+1];
        for(int i=triangle.size()-1; i>=0; i--){
            List<Integer> curList = triangle.get(i);
            for(int j=0; j<curList.size(); j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + curList.get(j);
            }
        }
        return dp[0];
    }
}