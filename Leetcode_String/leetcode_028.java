package Leetcode_String;

import java.util.ArrayList;
import java.util.List;

/*
	实现 strStr()

	实现 strStr() 函数。

	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

	示例 1:

	输入: haystack = "hello", needle = "ll"
	输出: 2
	示例 2:

	输入: haystack = "aaaaa", needle = "bba"
	输出: -1
	说明:

	当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

	对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

*/
public class leetcode_028 {
	public static int strStr(String haystack, String needle) {
		if(needle == null || needle.length() == 0){
			return 0;
		}
		for(int i=0; i<=haystack.length()-needle.length(); i++){
			if(haystack.charAt(i) == needle.charAt(0)){
				int j=i+1;
				int k;
				for(k=1; j<haystack.length()&&k<needle.length(); k++){
					if(haystack.charAt(j) == needle.charAt(k)){
						j++;
					}
					else{
						break;
					}
				}
				if(k == needle.length()){
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		System.out.println("The haystack: "+haystack);
		System.out.println("The needle: "+needle);
		System.out.println("The begin of the needle in the haystack is:"+strStr(haystack, needle));
	}

}
