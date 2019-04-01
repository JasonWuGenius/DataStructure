package Leetcode_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102 {
	/*
	 * �������Ĳ�α���
	 * ����һ���������������䰴��α����Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
		����:
		����������: [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
		�������α��������
		[
		  [3],
		  [9,20],
		  [15,7]
		]
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		if(root == null){
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int toBePrint = 1;//��һ����Ҫ��ӡ�Ľڵ�
		int nextLevelCount = 0;//��һ����Ҫ��ӡ�Ľ��
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();//����
			tempList.add(temp.val);
			toBePrint--;
			if(temp.left != null){
				queue.add(temp.left);
				nextLevelCount++;
			}
			if(temp.right != null){
				queue.add(temp.right);
				nextLevelCount++;
			}
			if(toBePrint == 0){
				list.add(new ArrayList<>(tempList));
				tempList.clear();
				toBePrint = nextLevelCount;//��һ��Ҫ��ӡ�Ľ����и�ֵ
				nextLevelCount = 0;//���²��㸳ֵΪ0����
			}
		}
		return list;
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		System.out.println("The levelOrder of The tree : "+ levelOrder(node1));
		
	}

}
