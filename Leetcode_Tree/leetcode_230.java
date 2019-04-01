package Leetcode_Tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode_230 {
	/*
	 * 二叉搜索树中第K小的元素
	 * 
	 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
		说明：
		你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
		示例 1:
		输入: root = [3,1,4,null,2], k = 1
		   3
		  / \
		 1   4
		  \
		   2
		输出: 1
		示例 2:
		输入: root = [5,3,6,2,4,null,null,1], k = 3
		       5
		      / \
		     3   6
		    / \
		   2   4
		  /
		 1
		输出: 3
		进阶：
		如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
	 */
	public static int time = 0;
	public static int kthSmallest1(TreeNode root, int k){
		if(root == null){
			return 0;
		}
		int left = kthSmallest1(root.left, k);
		if(k == ++time){
			return root.val;
		}
		if(k < time){
			return left;
		}
		return kthSmallest1(root.right, k);
	}
	
	//方法二：中序遍历二叉搜索树，找到第K个值
	private static int index;
	public static int kthSmallest2(TreeNode root, int k){
		int res = 0;
		if(root == null){
			return res;
		}
		res = kthSmallest2(root.left, k);
		System.out.println(res);
		if(index == k){
			return res;
		}
		if(++index == k){
			return root.val;
		}
		return kthSmallest2(root.right, k);
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
		
		System.out.println("The Tree: "+PrintTree.levelOrder(node1));
		System.out.println("The kthSmallest: "+kthSmallest1(node1, 1));
	}
	//方法三：中序遍历
	public static List<Integer> list = new ArrayList<>();
	public static int count = 1;
	public static void inorder(TreeNode root, List<Integer> list, int k){
		if(root == null){
			return;
		}
		inorder(root.left, list, k);
		list.add(root.val);
		if(count++ == k){
			return;
		}
		inorder(root.right, list, k);
	}
	public static int kthSmallest3(TreeNode root, int k){
		inorder(root, list, k);
		if(list != null){
			return list.get(list.size()-1);
		}
		return -1;
	}

	//方法四：递归计算节点数量--这其中问题在于计数以后重新遍历了一下左子树。
	public static int count(TreeNode root){
		if(root == null)
			return 0;
		return 1+count(root.left)+count(root.right);
	}
	public static int kthSmallest4(TreeNode root, int k){
		int num = count(root.left);
		if(num == k-1){
			return root.val;
		}
		if(num > k-1){
			return kthSmallest4(root.left, k);
		}
		return kthSmallest4(root.right, k-num-1);
	}
	


}
