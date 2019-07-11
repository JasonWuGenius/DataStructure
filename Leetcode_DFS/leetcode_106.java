package Leetcode_DFS;

import java.util.Arrays;

/* 
 * 从中序与后序遍历序列构造二叉树
 * 
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

	注意:
	你可以假设树中没有重复的元素。

	例如，给出

	中序遍历 inorder =?[9,3,15,20,7]
	后序遍历 postorder = [9,15,7,20,3]
	返回如下的二叉树：

		 3
		/ \
	    9  20
		  /  \
		 15   7

 */
public class leetcode_106 {
	public static TreeNode buildTree(int[] inorder, int[] postorder){
		return buildTree(inorder, postorder, postorder.length-1, 0, inorder.length);
	}
	
	private static TreeNode buildTree(int[] inorder, int[] postorder, int postIndex, int start, int end){
		if(start >= end){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postIndex]);
		for(int i=start; i<end; i++){
			if(inorder[i] == postorder[postIndex]){
				root.right = buildTree(inorder, postorder, postIndex-1, i+1, end);
				root.left = buildTree(inorder, postorder, postIndex-(end-i), start, i);
				break;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = buildTree(inorder, postorder);
		System.out.println("The LevelOrder of The Tree :"+PrintTree.levelOrder(root));
	}

}
