package Leetcode_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_242 {
	/*
	 * ��Ч����ĸ��λ��
	 * 
	 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ��һ����ĸ��λ�ʡ�
		ʾ�� 1:
		����: s = "anagram", t = "nagaram"
		���: true
		ʾ�� 2:
		����: s = "rat", t = "car"
		���: false
		˵��:
		����Լ����ַ���ֻ����Сд��ĸ��
		����:
		��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ�����������
	 */
	//����һ��ʹ��Arrays�е�sort����
	public static boolean isAnagram1(String s, String t){
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		Arrays.sort(sChars);
		Arrays.sort(tChars);
		return String.valueOf(sChars).equals(String.valueOf(tChars));
	}
	//��������ʹ��map
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
	//����������������Ϊ26������
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
