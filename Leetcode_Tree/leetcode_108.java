package Leetcode_Tree;

public class leetcode_108 {
	/*
	 * 将有序数组转换为二叉搜索树
	 * 
	 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
		本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
		示例:
		给定有序数组: [-10,-3,0,5,9],
		一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
		      0
		     / \
		   -3   9
		   /   /
		 -10  5
	 */
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
        	return null;
        }
        return buildTree(nums, 0, nums.length-1);
    }
	private static TreeNode buildTree(int[] nums, int left, int right){
		if(left > right){
			return null;
		}
		if(left == right){
			return new TreeNode(nums[left]);
		}
		int mid = (left+right)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, left, mid-1);
		root.right = buildTree(nums, mid+1, right);
		return root;
	}
	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = sortedArrayToBST(nums);
		System.out.println("The tree : "+ PrintTree.levelOrder(root));
	}

}
