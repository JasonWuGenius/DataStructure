package Leetcode_DFS;
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
