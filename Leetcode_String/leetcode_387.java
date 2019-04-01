package Leetcode_String;

import java.util.HashMap;
import java.util.Map;

public class leetcode_387 {
	/*
	 * ����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��
		����:
		s = "leetcode"
		���� 0.
		s = "loveleetcode",
		���� 2.
		ע����������Լٶ����ַ���ֻ����Сд��ĸ��
	 */
	//����һ��map
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
	//�����������ó���Ϊ26�����飬���м���
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
	//��������ʹ��indexOf��lastIndexOf����
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
