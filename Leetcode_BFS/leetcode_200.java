package Leetcode_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 岛屿数量
 * 
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，
 * 计算岛屿的数量。一个岛被水包围，并且它是通过水平方
 * 向或垂直方向上相邻的陆地连接而成的。你可以假设网格的
 * 四个边均被水包围。

	示例 1:

	输入:
	11110
	11010
	11000
	00000

	输出: 1
	示例 2:

	输入:
	11000
	11000
	00100
	00011

	输出: 3

 */
class leetcode_200 {
    public static int numIslands(char[][] grid) {
		int islandNum = 0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == '1'){
					infect(grid, i, j);
					islandNum++;
				}
			}
		}
		return islandNum;
	}
	public static void infect(char[][] grid, int i, int j){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != '1'){
			return;
		}
		grid[i][j] = '2';
		infect(grid, i+1, j);
		infect(grid, i-1, j);
		infect(grid, i, j+1);
		infect(grid, i, j-1);
	}

	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'}, 
						{'1','1','0','0','0'}, 
						{'0','0','1','0','0'}, 
						{'0','0','0','1','1'}};
		System.out.println("The Num of the Islands: "+ numIslands(grid));

	}

}
