package Leetcode_DFS;

import java.util.Arrays;

/* 
 * ��ǰ����������й���������
 * 
 *  ���磬����
	ǰ����� preorder = [3,9,20,15,7]
	������� inorder = [9,3,15,20,7]
	�������µĶ�������
		3
	   / \
	  9  20
		/  \
	   15   7
	��������Ҫ�õ���ǰ�������л�ȡ���ڵ㣬Ȼ������������У��ҵ����ڵ��λ�ã�
	�Դ�ֱ�������������������ķ�Χ�����ҵõ���������֮������Ϳ�ʼ�ظ��ˣ�
	������Ȼ��Ҫ����ǰ���������ҵ�����������ĸ��ڵ㣬
	Ȼ���ٸ����������еõ�������������ڵ����������,������һֱ�ظ�������̣�
	ֱ����������ֻ��һ���ڵ㣬��ôҲ�����ڵݹ���������һ�㣬��ʱ��Ͱ�����ڵ㷵�أ�
	Ȼ���һ�����ݣ�������������������Ĺ���������������Ҳ��ͬ��
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
	
	// ���������õ����ķ�����ʵ�Ǹ�Ϊ�򵥵�
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
