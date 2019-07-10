package Leetcode_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTree {
	/*
	 * 打印树
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		if(root == null){
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int toBePrint = 1;//这一层需要打印的节点
		int nextLevelCount = 0;//下一层需要打印的结点
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();//出队
			tempList.add(temp.val);
			toBePrint--;
			if(temp.left != null){
				queue.add(temp.left);
				nextLevelCount++;
			}
			if(temp.right != null){
				queue.add(temp.right);
				nextLevelCount++;
			}
			if(toBePrint == 0){
				list.add(new ArrayList<>(tempList));
				tempList.clear();
				toBePrint = nextLevelCount;//下一层要打印的结点进行赋值
				nextLevelCount = 0;//下下层结点赋值为0
			}
		}
		return list;
	}
}
