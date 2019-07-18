package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

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
 */
public class leetcode_079 {
	public static boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] used = new boolean[m][n];
		char[] wordChar = word.toCharArray();
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(existSub(board, wordChar, i, j, 0, used)){
					return true;
				}
			}
		}
		return false;

	}
	public static boolean existSub(char[][] board, char[] wordChar, int row, int col, int pathLength, boolean[][] used){
		boolean flag = false;
		if(row>0 && row<board.length && col>0 && col<board[0].length && !used[row][col] && board[row][col] == wordChar[pathLength]){
			used[row][col] = true;
			pathLength++;
			if(pathLength == wordChar.length){
				return true;
			}
			flag = existSub(board, wordChar, row+1, col, pathLength, used) ||
					existSub(board, wordChar, row-1, col, pathLength, used) ||
					existSub(board, wordChar, row, col+1, pathLength, used) ||
					existSub(board, wordChar, row, col-1, pathLength, used);
			if(!flag){
				used[row][col] = false;
				pathLength--;
			}
		}
		return flag;
	}


	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		// String word = "ABCCED";
		String word = "SEE";
		// String word = "ABCD";
		System.out.println("The board: ");
		for(int i=0; i<board.length; i++){
			for(char c:board[i]){
				System.out.print(c+" ");
			}
			System.out.println();
		}
		System.out.println("The word: "+word);
		System.out.println("The word is in the board: "+exist(board, word));
	}

}
