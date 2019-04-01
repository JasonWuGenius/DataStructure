package Leetcode_String;

public class leetcode_744 {
	/*
	 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，
	 * 寻找有序数组里面比目标字母大的最小字母。
	        数组里字母的顺序是循环的。
	        举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
	        
	          输入:
		letters = ["c", "f", "j"]
		target = "a"
		输出: "c"
		输入:
		letters = ["c", "f", "j"]
		target = "c"
		输出: "f"
		
		说明：
		letters长度范围在[2, 10000]区间内。
		letters 仅由小写字母组成，最少包含两个不同的字母。
		目标字母target 是一个小写字母。
	 */
	public char nextGreatestLetter(char[] letters, char target){
		int n = letters.length;
		int left = 0;
		int right = n;
		while(left<right){
			int mid = (left+right)/2;
			if(letters[mid]>target){
				right = mid;
			}
			else{
				left = mid+1;//这里加1，就是考虑到需要找到当前字母的后一个最近字母的题设条件
			}
		}
		return left<n? letters[right]:letters[0];
	}
	public static void main(String[] args) {
		leetcode_744 l744 = new leetcode_744();
		char[] letters = {'c', 'f', 'j'};
		char[] targets = {'a', 'c', 'd', 'g', 'j', 'k'};
		System.out.print("The Letters : ");
		for(char item:letters){
			System.out.print(item+" ");
		}
		System.out.println();
		for(char target:targets){
			System.out.println("The target : "+target+"        ");
			System.out.println("The result : "+l744.nextGreatestLetter(letters, target));
			System.out.println();
		}
	}

}
