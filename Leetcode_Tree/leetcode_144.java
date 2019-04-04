/**
	��������ǰ�����

	����һ������������������ ǰ�� ������

	 ʾ��:

	����: [1,null,2,3]  
	   1
		\
		 2
		/
	   3 

	���: [1,2,3]
	����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����
/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //ʹ�õݹ�ķ������б�������ͨ�ĵ������Ͳ�������
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }
}