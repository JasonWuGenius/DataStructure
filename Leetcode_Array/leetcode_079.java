package Leetcode_Array;

import java.util.LinkedList;
import java.util.List;

public class leetcode_079 {
	/*
	 * 单词搜索
	 * 
	 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
		单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
		示例:
		board =
		[
		  ['A','B','C','E'],
		  ['S','F','C','S'],
		  ['A','D','E','E']
		]
		给定 word = "ABCCED", 返回 true.
		给定 word = "SEE", 返回 true.
		给定 word = "ABCB", 返回 false.
		
		使用回溯递归，用一个List保存尚未访问的元素(按序)、
		一个和board相等维度的boolean数组保存某个位置元素是否被访问(防止重复)，
		想好了所有边界条件就很好做了，最后记得回溯时要恢复List和数组即可
	 */
	public static boolean exist(char[][] board, String word){
		List<Character> unuse = new LinkedList<Character>();
		int m = board.length, n = board[0].length, len = word.length();
		boolean[][] used = new boolean[m][n];
		for(int i=0; i<len; i++){
			unuse.add(word.charAt(i));
		}
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(find(board, unuse, used, i, j)){
					return true;
				}
			}
		}
		return false;
	}
	private static boolean find(char[][] board, List<Character> unuse, boolean[][] used, int row, int col){
		if(unuse.isEmpty()){
			return true;
		}
		if(row == board.length || row < 0){
			return false;
		}
		if(col == board.length || col < 0){
			return false;
		}
		if(!used[row][col] && board[row][col] == unuse.get(0)){
			char c = board[row][col];
			unuse.remove(0);
			used[row][col] = true;
			boolean flag = find(board, unuse, used, row+1, col) || find(board, unuse, used, row-1, col) ||
					find(board, unuse, used, row, col+1) || find(board, unuse, used, row, col-1);
			used[row][col] = false;
			unuse.add(0, c);
			return flag;
		}
		else{
			return false;
		}
	}

}
