package Leetcode_Dynamic;

import java.util.List;

public class leetcode_139 {
	/*
	 * ���ʲ��
	 * 
	 * ����һ���ǿ��ַ��� s ��һ�������ǿյ����б���ֵ� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
		˵����
		���ʱ�����ظ�ʹ���ֵ��еĵ��ʡ�
		����Լ����ֵ���û���ظ��ĵ��ʡ�
		ʾ�� 1��
		����: s = "leetcode", wordDict = ["leet", "code"]
		���: true
		����: ���� true ��Ϊ "leetcode" ���Ա���ֳ� "leet code"��
		ʾ�� 2��
		����: s = "applepenapple", wordDict = ["apple", "pen"]
		���: true
		����: ���� true ��Ϊ "applepenapple" ���Ա���ֳ� "apple pen apple"��
		     ע��������ظ�ʹ���ֵ��еĵ��ʡ�
		ʾ�� 3��
		����: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
		���: false
	 */
	//����һ����̬�滮
	public static boolean wordBreak(String s, List<String> wordDict){
		int n = s.length();
		boolean[] memo = new boolean[n+1];
		memo[0] = true;
		for(int i=1; i<=n; i++){
			for(int j=0; j<i; j++){
				if(memo[j] &&  wordDict.contains(s.substring(j, i))){
					memo[i] = true;
					break;
				}
			}
		}
		return memo[n];
	}

}
