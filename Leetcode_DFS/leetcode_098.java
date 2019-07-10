package Leetcode_DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 验证二叉搜索树
 * 
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	假设一个二叉搜索树具有如下特征：
	节点的左子树只包含小于当前节点的数。
	节点的右子树只包含大于当前节点的数。
	所有左子树和右子树自身必须也是二叉搜索树。
	示例 1:
	输入:
		2
	   / \
	  1   3
	输出: true
	示例 2:
	输入:
		5
	   / \
	  1   4
		 / \
		3   6
	输出: false
	解释: 输入为: [5,1,4,null,null,3,6]。
		 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class leetcode_098 {
	//树的中序遍历是递增序列，以此确定是二叉搜索树
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

	// 方法二：迭代的方法进行判断。这个思路十分巧妙，但不太好理解，需要好好想一下
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
