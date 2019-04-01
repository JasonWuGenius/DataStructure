package Leetcode_Array;

import java.util.LinkedList;
import java.util.List;

public class leetcode_079 {
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
		
		ʹ�û��ݵݹ飬��һ��List������δ���ʵ�Ԫ��(����)��
		һ����board���ά�ȵ�boolean���鱣��ĳ��λ��Ԫ���Ƿ񱻷���(��ֹ�ظ�)��
		��������б߽������ͺܺ����ˣ����ǵû���ʱҪ�ָ�List�����鼴��
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
