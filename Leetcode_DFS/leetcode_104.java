package Leetcode_DFS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 二叉树的最大深度
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	说明: 叶子节点是指没有子节点的节点。
	示例：
	给定二叉树 [3,9,20,null,null,15,7]，
	   3
	  / \
	 9  20
	   /  \
	  15   7
	返回它的最大深度 3 。
 */
public class leetcode_104 {
	public static int maxDepth1(TreeNode root){
		if(root == null){
			return 0;
		}
		return maxDepth1(root.left)>maxDepth1(root.right)? maxDepth1(root.left)+1:maxDepth1(root.right)+1;
	}
	
    public static int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        } 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int preCount = 1;
        int pCount = 0;
        
        int level = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            preCount--;
            
            if(temp.left != null){
                q.offer(temp.left);
                pCount++;
            }
            if(temp.right != null){
                q.offer(temp.right);
                pCount++;
            }
            if(preCount == 0){
                preCount = pCount;
                pCount = 0;
                level++;
            }
        }
        return level;
    }
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode();
		TreeNode node5 = new TreeNode();
		TreeNode node6 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node3.left = node6;
		node3.right = node7;
		
		System.out.println("The maxDepth of The tree : "+ maxDepth1(node1));
	}

}
