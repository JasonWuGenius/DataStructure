package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * ��������
 * 
 * ����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
	ʾ��:
	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	���� word = "ABCCED", ���� true.
	���� word = "SEE", ���� true.
	���� word = "ABCB", ���� false.
 */
public class leetcode_079 {
	public static boolean exist(char[][] board, String word) {
		char[] wordChars = word.toCharArray();
		int m = board.length;
		int n = board[0].length;
		boolean[][] used = new boolean[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(existSub(board, wordChars, used, i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean existSub(char[][] board, char[] wordChars, boolean[][] used, int row, int col, int pathLength){
		boolean flag = false;
		if(pathLength == wordChars.length){
			return true;
		}
		if(row>=0 && row<board.length && col>=0 && col<board[0].length && !used[row][col] && board[row][col]==wordChars[pathLength++]){
			used[row][col] = true;
			flag = existSub(board, wordChars, used, row+1, col, pathLength) ||
			existSub(board, wordChars, used, row-1, col, pathLength)||
			existSub(board, wordChars, used, row, col+1, pathLength)||
			existSub(board, wordChars, used, row, col-1, pathLength) ;
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
		// String word = "SEE";
		String word = "ABCD";
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
