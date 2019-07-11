package Leetcode_DFS;

import java.util.Arrays;

/* 
 * 从前序和中序序列构建二叉树
 * 
 *  例如，给出
	前序遍历 preorder = [3,9,20,15,7]
	中序遍历 inorder = [9,3,15,20,7]
	返回如下的二叉树：
		3
	   / \
	  9  20
		/  \
	   15   7
	我们首先要得到从前序序列中获取根节点，然后遍历中序序列，找到根节点的位置，
	以此直到其左子树和右子树的范围。当我得到其左子树之后，事情就开始重复了，
	我们仍然需要根据前序序列中找到这颗左子树的根节点，
	然后再根据中序序列得到这颗左子树根节点的左右子树,就这样一直重复这个过程，
	直到，左子树只有一个节点，那么也就是在递归的最深的那一层，这时候就把这个节点返回，
	然后就一层层回溯，这样就完成了左子树的构建；对于右子树也是同理。
 */
public class leetcode_105 {
	public static TreeNode buildTree1(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null || preorder.length == 0){
			return null;
		}
		return buildCode(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	private static TreeNode buildCode(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd){
		int rootValue = preorder[preSt];
		TreeNode root = new TreeNode(rootValue);
		
		if(preSt == preEnd){
			return root;
		}
		
		int rootInorder = inSt;
		while(inorder[rootInorder] != rootValue && rootInorder <= inEnd){
			rootInorder++;
		}
		
		int leftLength = rootInorder - inSt;
		int leftPreEnd = preSt + leftLength;
		
		if(leftLength > 0){
			root.left = buildCode(preorder, preSt+1, leftPreEnd, inorder, inSt, inEnd);
		}
		if(leftLength < preEnd - preSt){
			root.right = buildCode(preorder,leftPreEnd +1,preEnd,inorder,rootInorder+1,inEnd);
		}
		return root;
	}
	
	// 方法二利用迭代的方法其实是更为简单的
	public static TreeNode buildTree2(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
			return null;
		}
		if(preorder.length == 1){
			return new TreeNode(preorder[0]);
		}
		TreeNode root = new TreeNode(preorder[0]);
		for(int i=0; i<inorder.length; i++){
			if(inorder[i] == preorder[0]){
				root.left = buildTree2(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
				root.right = buildTree2(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
			}
		}
		return root;
	}
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode root = buildTree2(preorder, inorder);
		System.out.println("The LevelOrder of The Tree :"+PrintTree.levelOrder(root));
	}

}
