package Leetcode_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	例如:
	给定二叉树: [3,9,20,null,null,15,7],
		3
	   / \
	  9  20
		/  \
	   15   7
	返回其层次遍历结果：
	[
	  [3],
	  [9,20],
	  [15,7]
	]
 */
public class leetcode_102 {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null){
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int preCount = 1;
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			list.add(temp.val);
			preCount--;
			while(temp.left != null){
				queue.add(temp.left);
				count++;
			}
			while(temp.right != null){
				queue.add(temp.right);
				count++;
			}
			if(preCount==0){
				res.add(new ArrayList<>(list));
				list.clear();
				preCount = count;
				count = 0;
			}
		} 
		return res;
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
		
		System.out.println("The levelOrder of The tree : "+ PrintTree.levelOrder(node1));
		
	}

}
