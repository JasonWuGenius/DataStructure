package Leetcode_DoublePointer;

public class leetcode_028 {
	/*
	 * strStr()
	 * 
	 * ʵ�� strStr() ������
		����һ�� haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�  -1��
		ʾ�� 1:
		����: haystack = "hello", needle = "ll"
		���: 2
		ʾ�� 2:
		����: haystack = "aaaaa", needle = "bba"
		���: -1
		˵��:
		�� needle �ǿ��ַ���ʱ������Ӧ������ʲôֵ�أ�����һ���������кܺõ����⡣
		���ڱ�����ԣ��� needle �ǿ��ַ���ʱ����Ӧ������ 0 ������C���Ե� strstr() �Լ� Java�� indexOf() ���������
	 */
	public static int strStr1(String hayStack, String needle){
		if(needle.length() == 0){
			return 0;
		}
		char[] charArrayhayStack = hayStack.toCharArray();
		char[] charArrayneedle = needle.toCharArray();
		for(int i=0; i<charArrayhayStack.length; i++){
			if(charArrayhayStack[i] == charArrayneedle[0]){
				int j = i+1;
				int k;
				for(k=1; k<charArrayneedle.length && j<charArrayhayStack.length; k++){
					if(charArrayhayStack[j] == charArrayneedle[k]){
						j++;
					}
					else{
						break;
					}
				}
				if(k == charArrayneedle.length){
					return i;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String hayStack = "hello";
		String needle = "ll";
//		String hayStack = "aaaaa";
//		String needle = "bba";
		System.out.println("hayStack: "+hayStack);
		System.out.println("needle: "+needle);
		System.out.println("The result: "+strStr2(hayStack, needle));
	}

}
