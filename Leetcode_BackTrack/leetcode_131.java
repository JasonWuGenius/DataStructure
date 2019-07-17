package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * �ָ��ַ���
 *
 * ����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���

	���� s ���п��ܵķָ����

	ʾ��:

	����:?"aab"
	���:
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


















