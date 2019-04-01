package Leetcode_Tree;

import java.util.HashMap;

public class Trie_Tree {
	/*
	 * 实现一个Trie树，也就是字典树
	 */
	private class Node{
		private int dumpli_num;
		private int prefix_num;
		private Node childs[];
		private boolean isLeaf;
		public Node(){
			dumpli_num=0;
			prefix_num=0;
			isLeaf=false;
			childs=new Node[26];
		}
	}
	
	private Node root;
	public Trie_Tree(){
		root = new Node();
	}
	
	//插入字串，用循环代替迭代实现
	public void insert(String words){
		insert(this.root, words);
	}
	
	private void insert(Node root, String words){
		words = words.toLowerCase();
		char[] chrs = words.toCharArray();
		for(int i=0, length=chrs.length; i<length; i++){
			int index = chrs[i]-'a';
			if(root.childs[index] != null){
				//已经存在
				root.childs[index].prefix_num++;
			}
			else{
				//如果不存在
				root.childs[index] = new Node();
				root.childs[index].prefix_num++;
			}
			//如果到了字串结尾，则做标记
			if(i==length-1){
				root.childs[index].isLeaf = true;
				root.childs[index].dumpli_num++;
			}
			root = root.childs[index];
		}
	}
	public HashMap<String, Integer> getAllWords(){
		return preTraversal(this.root, "");
	}
	
	private HashMap<String, Integer> preTraversal(Node root, String prefixs){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		if(root != null){
			if(root.isLeaf == true){
				map.put(prefixs, root.dumpli_num);
			}
			for(int i=0, length=root.childs.length; i<length; i++){
				if(root.childs[i]!=null){
					char ch = (char)(i+'a');
					String tempStr = prefixs+ch;
					map.putAll(preTraversal(root.childs[i], tempStr));
				}
			}
		}
		return map;
	}
	//判断字串是否在字典树中
	public boolean isExist(String word){
		return search(this.root, word);
	}
	
	private boolean search(Node root, String word){
		char[] chs = word.toLowerCase().toCharArray();
		for(int i=0, length=chs.length; i<length; i++){
			int index=chs[i]-'a';
			if(root.childs[index] == null)
				return false;
			root = root.childs[index];
		}
		return true;
	}
	
	//得到以某字串为前缀的字串集，包括字串本身
	public HashMap<String, Integer> getWordsForPrefix(String prefix){
		return getWordsForPrefix(this.root, prefix);
	}
	
	private HashMap<String, Integer> getWordsForPrefix(Node root, String prefix){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		char[] chrs = prefix.toLowerCase().toCharArray();
		for(int i=0, length=chrs.length; i<length; i++){
			int index = chrs[i]-'a';
			if(root.childs[index] == null){
				return null;
			}
			root = root.childs[index];
		}
		return preTraversal(root, prefix);
	}
	
	public static void main(String args[]){  //Just used for test

		Trie_Tree trie = new Trie_Tree();
	    trie.insert("I");
	    trie.insert("Love");
	    trie.insert("China");
	    trie.insert("China");
	    trie.insert("China");
	    trie.insert("China");
	    trie.insert("China");
	    trie.insert("xiaoliang");
	    trie.insert("xiaoliang");
	    trie.insert("man");
	    trie.insert("handsome");
	    trie.insert("love");
	    trie.insert("chinaha");
	    trie.insert("her");
	    trie.insert("know");
	  
	    HashMap<String,Integer> map=trie.getAllWords();
	    
	    for(String key:map.keySet()){
	    	System.out.println(key+" 出现: "+ map.get(key)+"次");
	    }
	    
	    map=trie.getWordsForPrefix("chin");
	    
	    System.out.println("\n\n包含chin（包括本身）前缀的单词及出现次数：");
	    for(String key:map.keySet()){
	    	System.out.println(key+" 出现: "+ map.get(key)+"次");
	    }
	    
	    if(trie.isExist("xiaoming")==false){
	    	System.out.println("\n\n字典树中不存在：xiaoming ");
	    }
	}
}
