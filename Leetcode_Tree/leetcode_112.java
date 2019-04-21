package Leetcode_Tree;

public class leetcode_108 {
	/*
	����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·��������·�������нڵ�ֵ��ӵ���Ŀ��͡�

	˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

	ʾ��: 
	�������¶��������Լ�Ŀ��� sum = 22��

				  5
				 / \
				4   8
			   /   / \
			  11  13  4
			 /  \      \
			7    2      1
	���� true, ��Ϊ����Ŀ���Ϊ 22 �ĸ��ڵ㵽Ҷ�ӽڵ��·�� 5->4->11->2��
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

}
