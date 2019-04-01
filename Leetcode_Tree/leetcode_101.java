package Leetcode_Tree;

public class leetcode_101 {
	/*
	 * 对称二叉树
	 * 给定一个二叉树，检查它是否是镜像对称的。
		例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
		   1
		  / \
		 2   2
		/ \ / \
		3  4 4  3
		但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
		   1
		  / \
		 2   2
		  \   \
		  3    3
		说明:
		如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
		
		思路
		1. 树是空的，true。
		2. 判断这棵树的左子树和右子树是否对称。
		3. 两棵子树的对称条件：根节点相等，左子树的左子树和右子树的右子树对称，左子树的右子树和右子树的左子树对称：
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
