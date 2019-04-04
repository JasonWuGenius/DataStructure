/**
	N������������

	����һ�� N �������ҵ��������ȡ�

	��������ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�������

	���磬����һ�� 3���� :

	����Ӧ�����������ȣ�3��

	˵��:

	������Ȳ��ᳬ�� 1000��
	���Ľڵ��ܲ��ᳬ�� 5000��
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
 
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        for(int i=0; i<root.children.size(); i++){
            depth = Math.max(depth, maxDepth(root.children.get(i)));
        }
        return depth+1;
    }
}