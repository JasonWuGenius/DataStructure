package Leetcode_Tree;

/*
	找树左下角的值

	给定一个二叉树，在树的最后一行找到最左边的值。

	示例 1:

	输入:

		2
	   / \
	  1   3

	输出:
	1
	 

	示例 2:

	输入:

			1
		   / \
		  2   3
		 /   / \
		4   5   6
		   /
		  7

	输出:
	7
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
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        int res = root.val;
        while(!temp.isEmpty()){
            res = temp.get(0).val;
            List<TreeNode> temp2 = new ArrayList<>();
            for(TreeNode t:temp){
                if(t.left != null){
                    temp2.add(t.left);
                }
                if(t.right != null){
                    temp2.add(t.right);
                }
            }
            temp = temp2;
        }
        return res;
    }
}