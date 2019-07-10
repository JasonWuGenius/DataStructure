package Leetcode_DFS;
/*
	相同的树


	给定两个二叉树，编写一个函数来检验它们是否相同。

	如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

	示例 1:

	输入:       1         1
			  / \       / \
			 2   3     2   3

			[1,2,3],   [1,2,3]

	输出: true
	示例 2:

	输入:      1          1
			  /           \
			 2             2

			[1,2],     [1,null,2]

	输出: false
	示例 3:

	输入:       1         1
			  / \       / \
			 2   1     1   2

			[1,2,1],   [1,1,2]

	输出: false

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class leetcode_100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null){
			return true;
		}
		else if(p == null || q == null){
			return false;
		}
		else{
			if(p.val == q.val){
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
			else{
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(2);
		TreeNode node7 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;

		node5.right = node6;
		node5.left = node7;

		System.out.println("These two trees are the Same: "+isSameTree(node1, node5));

	}
}
