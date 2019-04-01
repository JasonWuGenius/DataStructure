package Leetcode_Tree;

import java.util.HashMap;

public class Trie_Tree {
	/*
	 * ʵ��һ��Trie����Ҳ�����ֵ���
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
	
	//�����ִ�����ѭ���������ʵ��
	public void insert(String words){
		insert(this.root, words);
	}
	
	private void insert(Node root, String words){
		words = words.toLowerCase();
		char[] chrs = words.toCharArray();
		for(int i=0, length=chrs.length; i<length; i++){
			int index = chrs[i]-'a';
			if(root.childs[index] != null){
				//�Ѿ�����
				root.childs[index].prefix_num++;
			}
			else{
				//���������
				root.childs[index] = new Node();
				root.childs[index].prefix_num++;
			}
			//��������ִ���β���������
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
	//�ж��ִ��Ƿ����ֵ�����
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
	
	//�õ���ĳ�ִ�Ϊǰ׺���ִ����������ִ�����
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
	    	System.out.println(key+" ����: "+ map.get(key)+"��");
	    }
	    
	    map=trie.getWordsForPrefix("chin");
	    
	    System.out.println("\n\n����chin����������ǰ׺�ĵ��ʼ����ִ�����");
	    for(String key:map.keySet()){
	    	System.out.println(key+" ����: "+ map.get(key)+"��");
	    }
	    
	    if(trie.isExist("xiaoming")==false){
	    	System.out.println("\n\n�ֵ����в����ڣ�xiaoming ");
	    }
	}
}
