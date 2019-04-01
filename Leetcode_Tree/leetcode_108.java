package Leetcode_Tree;

public class leetcode_108 {
	/*
	 * ����������ת��Ϊ����������
	 * 
	 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������
		�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
		ʾ��:
		������������: [-10,-3,0,5,9],
		һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������
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
