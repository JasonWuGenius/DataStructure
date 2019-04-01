package Leetcode_String;

import java.util.ArrayList;
import java.util.List;

public class leetcode_890 {
	/*
	 * Medium
	 * 查找和替换
	 *  你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
		如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
		（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
		返回 words 中与给定模式匹配的单词列表。
		你可以按任何顺序返回答案。
		示例：
		输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
		输出：["mee","aqq"]
		解释：
		"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
		"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
		因为 a 和 b 映射到同一个字母。
		
	 * 步骤
	 * 1.首先判断长度，显然，长度不同无法映射
	 * 2.将word与pattern 进行映射：设s为word[i], p为pattern[i]
	 * 如果map[p]为0且s没有被映射
	 * map[p] = s; s标记被映射
	 * 如果map[p]不为0,则已经映射出去
	 * 则检查map[p]是否映射为当前s, 不等则false
	 * return
	 */
	public static List<String> findAndReplacePattern(String[] words, String pattern){
		List<String> list = new ArrayList<>();
		for(int i=0; i<words.length; i++){
			if(isMatch(words[i], pattern)){
				list.add(words[i]);
			}
		}
		return list;
	}
	private static boolean isMatch(String word, String pattern){
		int[] map = new int[138];
		int[] isUse = new int[138];
		if(word.length() == pattern.length()){
			for(int i=0; i<word.length(); i++){
				int s = word.charAt(i);
				int p = pattern.charAt(i);
				if(map[p] == 0 && isUse[s] == 0){
					map[p] = s;
					isUse[s] = 1;
				}
				else if(map[p] != s){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "aba";
        System.out.println("Find and Replace Pattern : "+findAndReplacePattern(words, pattern));
	}
}



