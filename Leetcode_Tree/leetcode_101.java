package Leetcode_Tree;

public class leetcode_101 {
	/*
	 * �Գƶ�����
	 * ����һ����������������Ƿ��Ǿ���ԳƵġ�
		���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�
		   1
		  / \
		 2   2
		/ \ / \
		3  4 4  3
		����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:
		   1
		  / \
		 2   2
		  \   \
		  3    3
		˵��:
		�����������õݹ�͵������ַ������������⣬��ܼӷ֡�
		
		˼·
		1. ���ǿյģ�true��
		2. �ж�����������������������Ƿ�Գơ�
		3. ���������ĶԳ����������ڵ���ȣ��������������������������������Գƣ��������������������������������Գƣ�
	 */
	public static boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		else{
			return isSymmetric(root.left, root.right);
		}
	}
	private static boolean isSymmetric(TreeNode left, TreeNode right){
		if(left == null && right == null){
			return true;
		}
		else if(left == null || right == null){
			return false;
		}
		if(left.val != right.val){
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode();
		TreeNode node7 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		System.out.println("The tree is symmetric: "+ isSymmetric(node1));
	}
}
