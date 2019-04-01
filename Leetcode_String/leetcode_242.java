package Leetcode_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_242 {
	/*
	 * 有效的字母异位词
	 * 
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
		示例 1:
		输入: s = "anagram", t = "nagaram"
		输出: true
		示例 2:
		输入: s = "rat", t = "car"
		输出: false
		说明:
		你可以假设字符串只包含小写字母。
		进阶:
		如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
	 */
	//方法一：使用Arrays中的sort方法
	public static boolean isAnagram1(String s, String t){
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		Arrays.sort(sChars);
		Arrays.sort(tChars);
		return String.valueOf(sChars).equals(String.valueOf(tChars));
	}
	//方法二：使用map
	public static boolean isAnagram2(String s, String t){
		Map<Character, Integer> map = new HashMap<>();
		for(char ch: s.toCharArray()){
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		for(char ch: t.toCharArray()){
			Integer count = map.get(ch);
			if(count == null){
				return false;
			}
			else if(count > 1){
				map.put(ch, count-1);
			}
			else{
				map.remove(ch);
			}
		}
		return map.isEmpty();
	}
	//方法三：创建长度为26的数组
	public static boolean isAnagram3(String s, String t){
		int[] sChars = new int[26];
		int[] tChars = new int[26];
		for(char ch:s.toCharArray()){
			sChars[ch-'a']++;
		}
		for(char ch:t.toCharArray()){
			tChars[ch-'a']++;
		}
		for(int i=0; i<sChars.length; i++){
			if(sChars[i] != tChars[i]){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
//		String s = "rat";
//		String t = "car";
		System.out.println("The String s: "+s);
		System.out.println("The String t: "+t);
		System.out.println("The Two String is Anagram: "+isAnagram1(s, t));
		System.out.println("The Two String is Anagram: "+isAnagram2(s, t));
		System.out.println("The Two String is Anagram: "+isAnagram3(s, t));
	}

}
