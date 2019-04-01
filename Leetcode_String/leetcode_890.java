package Leetcode_String;

import java.util.ArrayList;
import java.util.List;

public class leetcode_890 {
	/*
	 * Medium
	 * ���Һ��滻
	 *  ����һ�������б� words ��һ��ģʽ  pattern������֪�� words �е���Щ������ģʽƥ�䡣
		���������ĸ������ p ��ʹ�ý�ģʽ�е�ÿ����ĸ x �滻Ϊ p(x) ֮�����Ǿ͵õ�������ĵ��ʣ���ô������ģʽ��ƥ��ġ�
		������һ�£���ĸ�������Ǵ���ĸ����ĸ��˫�䣺ÿ����ĸӳ�䵽��һ����ĸ��û��������ĸӳ�䵽ͬһ����ĸ����
		���� words �������ģʽƥ��ĵ����б�
		����԰��κ�˳�򷵻ش𰸡�
		ʾ����
		���룺words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
		�����["mee","aqq"]
		���ͣ�
		"mee" ��ģʽƥ�䣬��Ϊ�������� {a -> m, b -> e, ...}��
		"ccc" ��ģʽ��ƥ�䣬��Ϊ {a -> c, b -> c, ...} �������С�
		��Ϊ a �� b ӳ�䵽ͬһ����ĸ��
		
	 * ����
	 * 1.�����жϳ��ȣ���Ȼ�����Ȳ�ͬ�޷�ӳ��
	 * 2.��word��pattern ����ӳ�䣺��sΪword[i], pΪpattern[i]
	 * ���map[p]Ϊ0��sû�б�ӳ��
	 * map[p] = s; s��Ǳ�ӳ��
	 * ���map[p]��Ϊ0,���Ѿ�ӳ���ȥ
	 * ����map[p]�Ƿ�ӳ��Ϊ��ǰs, ������false
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



