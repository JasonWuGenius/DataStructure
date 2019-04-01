package Leetcode_BackTrack;

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
