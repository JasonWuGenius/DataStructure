package Other;


/**
 * 	汉明距离
 * 
	两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

	给出两个整数 x 和 y，计算它们之间的汉明距离。

	注意：
	0 ≤ x, y < 231.

	示例:

	输入: x = 1, y = 4

	输出: 2

	解释:
	1   (0 0 0 1)
	4   (0 1 0 0)
		↑   ↑

	上面的箭头指出了对应二进制位不同的位置。
 */
class Solution {
    public static int hammingDistance(int x, int y) {
		y = x&y;
		int count = 0;
		while(y != 0){
			y ^= y-1;
			count++;
		}
		return count;
    }
	public static void main(String[] args) {
		int x = 0, y = 6;
		System.out.println("The x:"+x);
		System.out.println("The y:"+y);
		System.out.println("The hammingDistance:"+hammingDistance(x, y));
	}
}
