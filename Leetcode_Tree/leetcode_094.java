package Leetcode_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_094 {
	/*
	 * 二叉树中序遍历
	 * 
	 * 给定一个二叉树，返回它的中序 遍历。
		示例:
		输入: [1,null,2,3]
		   1
		    \
		     2
		    /
		   3
		输出: [1,3,2]
		进阶: 递归算法很简单，你可以通过迭代算法完成吗？
	 */
	//方法一：递归
	public static List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root == null){
			return null;
		}
		return inorder(root, list);
	}
	public static List<Integer> inorder(TreeNode root, List<Integer> list){
		if(root != null){
			inorder(root.left, list);
			list.add(root.val);
			inorder(root.right, list);
		}
		return list;
	}
	//方法二：循环--中序
	public static List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			if(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			else{
				cur = stack.pop();
				list.add(cur.val);
				cur = cur.right;
			}
		}
		return list;
	} 
	//方法二：循环--前序
	public static List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(cur != null || !stack.empty()){
			while(cur != null){
				list.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			}
			if(!stack.empty()){
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return list;
	}
	//方法二：循环--后续
	public static List<Integer> afterorderTraversal2(TreeNode root){
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		TreeNode cur = root;
		int i = 1;
		while(cur != null || !stack1.empty()){
			while(cur != null){
				stack1.push(cur);
				stack2.push(0);
				cur = cur.left;
			}
			while(!stack1.empty() && stack2.peek() == i){
				stack2.pop();
				list.add(stack1.pop().val);
			}
			if(!stack1.empty()){
				stack2.pop();
				stack2.push(1);
				cur = stack1.peek();
				cur = cur.right;
			}
		}
		return list;
 	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode();
//		TreeNode node5 = new TreeNode();
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node7 = new TreeNode(9);
		node1.right = node2;
		node2.left = node3;
		
		System.out.println("The Inorder of the Tree: "+inorderTraversal2(node1));
		System.out.println("The Preorder of the Tree: "+preorderTraversal2(node1));
		System.out.println("The Afterorder of the Tree: "+afterorderTraversal2(node1));
	}

}
