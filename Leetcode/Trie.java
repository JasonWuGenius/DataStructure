package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	/*
	 * ÊµÏÖTrieÊ÷
	 * 
	 * 
	 */
	private Map<Character, Map> children = new HashMap<>();
	
	//insert a word into the tree
	public void insert(String word){
		Map<Character, Map> ws = children;
		for(char c: word.toCharArray()){
			ws.putIfAbsent(c, new HashMap());
			ws = ws.get(c);
		}
		ws.put('#', null);
	}
	
	//return if the word is in the trie
	public boolean search(String word){
		Map<Character, Map> ws = children;
		for(char c: word.toCharArray()){
			if(ws.get(c) == null){
				return false;
			}
			ws = ws.get(c);
		}
		return ws.containsKey('#');
	}
	
	//return if there is any word in the trie that starts with the given prefix
	public boolean startWith(String prefix){
		Map<Character, Map> ws = children;
		for(char c: prefix.toCharArray()){
			if(ws.get(c) == null){
				return false;
			}
			ws = ws.get(c);
		}
		return true;
	}

}
