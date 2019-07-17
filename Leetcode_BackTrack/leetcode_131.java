package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 分割字符串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

	返回 s 所有可能的分割方案。

	示例:

	输入:?"aab"
	输出:
	[
	["aa","b"],
	["a","a","b"]
	]

 */
public class leetcode_131 {
	static List<List<String>> res = new ArrayList<>();
	public static List<List<String>> partition(String s){
		partitionSub(0, s, new ArrayList<>());
		return res;
	}
	public static void partitionSub(int start, String s, List<String> temp){
		if(start == s.length()){
			res.add(new ArrayList<>(temp));
			return;
		}
		for(int end=start+1; end<=s.length(); end++){
			String str = s.substring(start, end);
			if(isPal(str)){
				temp.add(str);
				partitionSub(end, s, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	public static boolean isPal(String s){
		int left = 0;
		int right = s.length()-1;
		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "aab";
		System.out.println("The s: "+s);
		System.out.println("The partition: "+partition(s));
	}	

}


















