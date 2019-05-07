package Leetcode_Tree;

/*
	�������½ǵ�ֵ

	����һ�������������������һ���ҵ�����ߵ�ֵ��

	ʾ�� 1:

	����:

		2
	   / \
	  1   3

	���:
	1
	 

	ʾ�� 2:

	����:

			1
		   / \
		  2   3
		 /   / \
		4   5   6
		   /
		  7

	���:
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