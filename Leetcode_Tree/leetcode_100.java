/*
	��ͬ����


	������������������дһ�����������������Ƿ���ͬ��

	����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ�

	ʾ�� 1:

	����:       1         1
			  / \       / \
			 2   3     2   3

			[1,2,3],   [1,2,3]

	���: true
	ʾ�� 2:

	����:      1          1
			  /           \
			 2             2

			[1,2],     [1,null,2]

	���: false
	ʾ�� 3:

	����:       1         1
			  / \       / \
			 2   1     1   2

			[1,2,1],   [1,1,2]

	���: false

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
            return false;
        }
    }
}
