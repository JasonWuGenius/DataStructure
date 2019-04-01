package Leetcode_BackTrack;

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
	 */
	static boolean[][] flag;
	static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

	public static boolean exist(char[][] board, String word) {
		int m = board.length;
		if(m == 0){
			return word.length() == 0;
		}
		int n = board[0].length;
		flag = new boolean[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(board[i][j] == word.charAt(0)){
					flag[i][j] = true;
					if(exist(board, word, 1, i, j)){
						return true;
					}
					flag[i][j] = false;
				}
			}
		}
		return false;
	}
	
    //We have found [0, index] of word in board, trying to find index + 1.
    //Now we are in (x, y)
	private static boolean exist(char[][] board, String word, int index, int x, int y){
		if(index == word.length()){
			return true;
		}
		for(int i=0; i<directions.length; i++){
			int newX = x+directions[i][0];
			int newY = y+directions[i][1];
			if(newX >= 0 && newX < board.length && newY >= 0 && newY <board[0].length){
				if(!flag[newX][newY] && board[newX][newY] == word.charAt(index)){
					flag[newX][newY] = true;
					if(exist(board, word, index+1, newX, newY)){
						return true;
					}
					flag[newX][newY] = false;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//		String word = "ABCCED";
		String word = "SEE";
//		String word = "ABCD";
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
