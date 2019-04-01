package Leetcode_String;

import java.util.HashMap;
import java.util.Map;

public class leetcode_387 {
	/*
	 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
		案例:
		s = "leetcode"
		返回 0.
		s = "loveleetcode",
		返回 2.
		注意事项：您可以假定该字符串只包含小写字母。
	 */
	//方法一：map
	public static int findUniqChar1(String s){
		Map<Character, Integer> map = new HashMap<>(26);
		char[] chars = s.toCharArray();
		for(char item: chars){
			map.put(item, map.getOrDefault(item, 0)+1);
		}
		for(int i=0; i<chars.length; i++){
			if(map.get(chars[i]) == 1){
				return i;
			}
		}
		return -1;
	}
	//方法二：设置长度为26的数组，进行计数
	public static int findUniqChar2(String s){
		int[] freq = new int[26];
		char[] chars = s.toCharArray();
		for(int i=0; i<chars.length; i++){
			freq[chars[i] - 'a']++;
		}
		for(int i=0; i<chars.length; i++){
			if(freq[chars[i] - 'a'] == 1){
				return i;
			}
		}
		return -1;
	}
	//方法三：使用indexOf和lastIndexOf方法
	public static int findUniqChar3(String s){
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(s.indexOf(ch) == s.lastIndexOf(ch)){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String s = "leetcode";
//		String s = "loveleetcode";
		System.out.println("The String is: "+s);
		System.out.println("The first unique char is: "+findUniqChar1(s));
		System.out.println("The first unique char is: "+findUniqChar2(s));
		System.out.println("The first unique char is: "+findUniqChar3(s));
	}

}
