package Leetcode_DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * ��֤����������
 * 
 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������
	����һ��������������������������
	�ڵ��������ֻ����С�ڵ�ǰ�ڵ������
	�ڵ��������ֻ�������ڵ�ǰ�ڵ������
	�������������������������Ҳ�Ƕ�����������
	ʾ�� 1:
	����:
		2
	   / \
	  1   3
	���: true
	ʾ�� 2:
	����:
		5
	   / \
	  1   4
		 / \
		3   6
	���: false
	����: ����Ϊ: [5,1,4,null,null,3,6]��
		 ���ڵ��ֵΪ 5 �����������ӽڵ�ֵΪ 4 ��
 */
public class leetcode_098 {
	//������������ǵ������У��Դ�ȷ���Ƕ���������
	public static boolean isValidBST2(TreeNode root){
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		for(int i=1; i<list.size(); i++){
			if(list.get(i-1) >= list.get(i)){
				return false;
			}
		}
		return true;
	}
	private static void inOrder(TreeNode node, List<Integer> list){
		if(node == null){
			return;
		}
		inOrder(node.left, list);
		list.add(node.val);
		inOrder(node.right, list);
	}

	// �������������ķ��������жϡ����˼·ʮ���������̫����⣬��Ҫ�ú���һ��
	static long last = Long.MIN_VALUE;
	public static boolean isValidBST(TreeNode root){
		if(root == null){
			return true;
		}
		boolean flag = true;
		flag = flag && isValidBST(root.left);
		if(last < root.val){
			last = root.val;
		}
		flag = flag && isValidBST(root.right);
		return flag;
	}


	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(9);
		node1.left = node2;
		node1.right = node3;
		node3.left = node6;
		node3.right = node7;
		
		System.out.println("The Tree is the valid BST: "+ isValidBST(node1));
		System.out.println("The Tree is the valid BST: "+ isValidBST2(node1));

	}

}
