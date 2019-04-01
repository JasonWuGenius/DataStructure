package Leetcode_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_103 {
	/*
	 * 二叉树的锯齿形层次遍历
	 * 
	 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
		例如：
		给定二叉树 [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
		返回锯齿形层次遍历如下：
		[
		  [3],
		  [20,9],
		  [15,7]
		]
	 */
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		if(root == null){
			return null;
		}
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int depth=0;
		while(!queue.isEmpty()){
			int count = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			while(count>0){
				TreeNode node = queue.poll();
				if(depth%2==1){
					list.add(0, node.val);
				}
				else{
					list.add(node.val);
				}
				count--;
				if(node.left != null) queue.add(node.left);
				if(node.right != null) queue.add(node.right);
			}
			depth++;
			res.add(list);
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
//		node4.left = node6;
		
		System.out.println("The zigzagLevelOrder: "+zigzagLevelOrder(node1));
	}

}
