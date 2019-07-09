package Leetcode_Dynamic;

/*
 * 不同的搜索二叉树
 * 
 * 给定一个整数 n，求以?1 ...?n?为节点组成的二叉搜索树有多少种？

	示例:

	输入: 3
	输出: 5
	解释:
	给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

		1         3     3      2      1
		\       /     /      / \      \
		3     2     1      1   3      2
		/     /       \                 \
		2     1         2                 3

	思路：
	思路 标签：动态规划 假设n个节点存在二叉排序树的个数是G(n)，
	令f(i)为以i为根的二叉搜索树的个数，则 G(n) = f(1) + f(2) + 
	f(3) + f(4) + ... + f(n) 
	当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i
	，则 f(i) = G(i-1)*G(n-i)
 */
public class leetcode_096 {
	public static int numTrees(int n) {
		if(n <= 1){
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++){
			int count = 0;
			for(int j=1; j<=i; j++){
				count += dp[j-1]*dp[i-j];
			}
			dp[i] = count;
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 8;
		System.out.println("The n is: "+n);
		System.out.println("The Solution is: "+numTrees(n));
	}

}
