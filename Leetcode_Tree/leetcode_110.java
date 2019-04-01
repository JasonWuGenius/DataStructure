package Leetcode_Tree;

import Leetcode.BinaryTreeNode;

public class leetcode_110 {
	/**
	 * �ж�һ�����Ƿ���ƽ�������
	 * �������Ķ����ǣ������������������ĸ߶Ȳ����1������������Ҳ��ƽ�������
	 */
	//�����������������
	public static int treeDepth(BinaryTreeNode node){
		if(node == null) return 0;
		int left = treeDepth(node.left);
		int right = treeDepth(node.right);
		return Math.max(left, right)+1;
	}
	//�ж����������Ƿ�Ϊƽ�������
	public boolean isBalanced(BinaryTreeNode node){
		if(node == null) return true;
		//���������߶Ȳ����1������ƽ�������
		if(Math.abs(treeDepth(node.left) - treeDepth(node.right)) > 1) return false;
		//�ݹ��ж����������Ƿ���ƽ�������
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
		
		//�˴���̬����ֱ��ʹ��-����.������-���е��ã���Ȼ����̬����Ҳ����ʹ�ö�����.���������е���
		int result = leetcode_110.treeDepth(node1);
		System.out.println("The Depth of Tree?: "+ result);
	}

}
