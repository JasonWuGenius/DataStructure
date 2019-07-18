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
