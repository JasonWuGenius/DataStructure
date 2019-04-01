package Leetcode_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_107 {
	/*
	 * 和leetcode_102有点相似，但也有点区别，因为102只是从最头进行遍历
	 * 二叉树的层次遍历
	 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
		例如：
		给定二叉树 [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
		返回其自底向上的层次遍历为：
		[
		  [15,7],
		  [9,20],
		  [3]
		]
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		if(root == null){
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int toBePrint = 1;
		int nextLevelCount = 0;
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
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
				toBePrint = nextLevelCount;
				nextLevelCount = 0;
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		for(int i=list.size()-1; i>=0; i--){
			result.add(list.get(i));
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
		node3.left = node6;
		node3.right = node7;
		
		System.out.println("The levelOrderBottom of The tree : "+ levelOrderBottom(node1));
	}
}
