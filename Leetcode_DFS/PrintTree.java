package Leetcode_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTree {
	/*
	 * ��ӡ��
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		if(root == null){
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int toBePrint = 1;//��һ����Ҫ��ӡ�Ľڵ�
		int nextLevelCount = 0;//��һ����Ҫ��ӡ�Ľ��
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();//����
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
				toBePrint = nextLevelCount;//��һ��Ҫ��ӡ�Ľ����и�ֵ
				nextLevelCount = 0;//���²��㸳ֵΪ0
			}
		}
		return list;
	}
}
