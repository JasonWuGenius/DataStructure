package Leetcode_Tree;

/*
	����������С���

	����һ�����������ҳ�����С��ȡ�

	��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������

	˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

	ʾ��:

	���������� [3,9,20,null,null,15,7],

		3
	   / \
	  9  20
		/  \
	   15   7
	����������С���  2.

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
//ʹ�õݹ����������У���һ����Ҫע�⣬�����ֻ��Ҷ�ӽڵ���ڵ�����£�������̵ĸ��ڵ㵽Ҷ�ӽڵ�ľ��롣
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