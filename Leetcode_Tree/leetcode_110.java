package Leetcode_Tree;

import Leetcode.BinaryTreeNode;

public class leetcode_110 {
	/**
	 * 判断一棵树是否是平衡二叉树
	 * 二叉树的定义是：空树或者左右子树的高度差不超过1，且左右子树也是平衡二叉树
	 */
	//计算左右子树的深度
	public static int treeDepth(BinaryTreeNode node){
		if(node == null) return 0;
		int left = treeDepth(node.left);
		int right = treeDepth(node.right);
		return Math.max(left, right)+1;
	}
	//判断左右子树是否为平衡二叉树
	public boolean isBalanced(BinaryTreeNode node){
		if(node == null) return true;
		//左右子树高度差大于1，则不是平衡二叉树
		if(Math.abs(treeDepth(node.left) - treeDepth(node.right)) > 1) return false;
		//递归判断左右子树是否是平衡二叉树
		else return isBalanced(node.left) && isBalanced(node.right);
	}
	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode();
		BinaryTreeNode node2 = new BinaryTreeNode();
		BinaryTreeNode node3 = new BinaryTreeNode();
		BinaryTreeNode node4 = new BinaryTreeNode();
		BinaryTreeNode node5 = new BinaryTreeNode();
		BinaryTreeNode node6 = new BinaryTreeNode();
		BinaryTreeNode node7 = new BinaryTreeNode();
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = null;
		node4.left = node7;
		
		leetcode_110 l110 = new leetcode_110();
		System.out.println("Tree is Bananced ?: "+ l110.isBalanced(node1));
		
		//此处静态方法直接使用-类名.方法名-进行调用，当然，静态方法也可以使用对象名.方法名进行调用
		int result = leetcode_110.treeDepth(node1);
		System.out.println("The Depth of Tree?: "+ result);
	}

}
