package Leetcode_Tree;

/**
	·���ܺ�3

	����һ��������������ÿ����㶼�����һ������ֵ��

	�ҳ�·���͵��ڸ�����ֵ��·��������

	·������Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��

	������������1000���ڵ㣬�ҽڵ���ֵ��Χ�� [-1000000,1000000] ��������

	ʾ����

	root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

		  10
		 /  \
		5   -3
	   / \    \
	  3   2   11
	 / \   \
	3  -2   1

	���� 3���͵��� 8 ��·����:

	1.  5 -> 3
	2.  5 -> 2 -> 1
	3.  -3 -> 11

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
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int res = pathSum(root.left, sum) + pathSum(root.right, sum) + pathFromRoot(root, sum);
        return res;
    }
    private int pathFromRoot(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.val == sum){
            res++;
        }
        res += pathFromRoot(root.left, sum-root.val) + pathFromRoot(root.right, sum-root.val);
        return res;
    }
}