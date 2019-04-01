package Leetcode_String;

public class leetcode_344 {
	/*
	 * ��ת�ַ���
	 * 
	 * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
		��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
		����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���
		ʾ�� 1��
		���룺["h","e","l","l","o"]
		�����["o","l","l","e","h"]
		ʾ�� 2��
		���룺["H","a","n","n","a","h"]
		�����["h","a","n","n","a","H"]
	 */
	public static void reverseString(char[] s){
		if(s == null){
			return;
		}
		else{
			for(int i=0; i<s.length/2; i++){
				reverse(s, i, s.length-1-i);
			}
		}
	}
	public static void reverse(char[] s, int begin, int end){
		char temp = s[begin];
		s[begin] = s[end];
		s[end] = temp;
	}
	public static void main(String[] args) {
//		char[] string = {'h', 'e', 'l', 'l', 'o'};
		char[] string = {'H','a','n', 'n', 'a', 'h'};
		System.out.println("The Origin String:");
		for(char item: string){
			System.out.print(item+" ");
		}
		reverseString(string);
		System.out.println("\nThe Reversed String:");
		for(char item: string){
			System.out.print(item+" ");
		}
	}

}
