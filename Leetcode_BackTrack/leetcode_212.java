package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ��������2
 *
	����һ����ά����?board?��һ���ֵ��еĵ����б� words���ҳ�����ͬʱ�ڶ�ά������ֵ��г��ֵĵ��ʡ�

	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ��һ�������в������ظ�ʹ�á�

	ʾ��:

	����: 
	words = ["oath","pea","eat","rain"] and board =
	[
	['o','a','a','n'],
	['e','t','a','e'],
	['i','h','k','r'],
	['i','f','l','v']
	]

	���:?["eat","oath"]
	˵��:
	����Լ����������붼��Сд��ĸ a-z?��ɡ�

	��ʾ:

	����Ҫ�Ż������㷨��ͨ�������������Ĳ��ԡ����ܷ����ֹͣ���ݣ�
	�����ǰ���ʲ����������е��ʵ�ǰ׺�У����������ֹͣ���ݡ�ʲô�������ݽṹ������Ч��ִ�������Ĳ�����ɢ�б��Ƿ���У�Ϊʲô�� ǰ׺����Σ��������ѧϰ���ʵ��һ��������ǰ׺�������Ȳ鿴������⣺ ʵ��Trie��ǰ׺������
 */
public class leetcode_212 {
	static List<String> res = new ArrayList<>();
	static boolean[][] used;
	static int pathLength;
	public static List<String> findWords(char[][] board, String[] words) {
		for(String word: words){
			used = new boolean[board.length][board[0].length];
			pathLength = 0;
			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[0].length; j++){
					if(findWordsSub(board, i, j, word, pathLength)){
						res.add(word);
					}
				}
			}
		}
		return res;
	}
	public static boolean findWordsSub(char[][] board, int row, int col, String word, int pathLength){
		boolean flag = false;
		if(row>=0 && row<board.length && col>=0 && col<board[0].length && !used[row][col] && board[row][col]==word.charAt(pathLength)){
			pathLength++;
			if(pathLength == word.length()){
				return true;
			}
			used[row][col] = true;
			flag = findWordsSub(board, row+1, col, word, pathLength) ||
					findWordsSub(board, row-1, col, word, pathLength) ||
					findWordsSub(board, row, col+1, word, pathLength) ||
					findWordsSub(board, row, col-1, word, pathLength);
			if(!flag){
				pathLength--;
				used[row][col] = false;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "rain"};
		System.out.println("The board: ");
		for(int i=0; i<board.length; i++){
			for(char c:board[i]){
				System.out.print(c+" ");
			}
			System.out.println();
		}
		System.out.println("The words: ");
		for(String word: words){
			System.out.print(word+" ");
		}
		System.out.println("\nThe words is in the board: "+findWords(board, words));
	}

}


















