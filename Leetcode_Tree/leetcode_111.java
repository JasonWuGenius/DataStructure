package Leetcode_Tree;

/*
	二叉树的最小深度

	给定一个二叉树，找出其最小深度。

	最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

	说明: 叶子节点是指没有子节点的节点。

	示例:

	给定二叉树 [3,9,20,null,null,15,7],

		3
	   / \
	  9  20
		/  \
	   15   7
	返回它的最小深度  2.

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
//使用递归做法，其中，有一点需要注意，深度在只有叶子节点存在的情况下，计算最短的根节点到叶子节点的距离。
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return minDepth(root.right)+1;
        }
        if(root.right == null){
            return minDepth(root.left)+1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left > right)? (right+1):(left+1);
    }
}