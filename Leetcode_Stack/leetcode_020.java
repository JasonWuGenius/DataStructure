package Leetcode_Stack;

import java.util.Stack;

/*
	��Ч������
	
	����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��

	��Ч�ַ��������㣺

	�����ű�������ͬ���͵������űպϡ�
	�����ű�������ȷ��˳��պϡ�
	ע����ַ����ɱ���Ϊ����Ч�ַ�����

	ʾ�� 1:

	����: "()"
	���: true
	ʾ�� 2:

	����: "()[]{}"
	���: true
	ʾ�� 3:

	����: "(]"
	���: false
	ʾ�� 4:

	����: "([)]"
	���: false
	ʾ�� 5:

	����: "{[]}"
	���: true
*/

//ʹ��ջ��˼�����ƥ��

class leetcode_020 {
    public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c: s.toCharArray()){
			if(c == '(' || c == '{' || c == '['){
				stack.push(c);
			}
			else{
				if(stack.isEmpty())  return false;
				if(c == ')' && stack.pop() != '(') return false; 
				if(c == '}' && stack.pop() != '{') return false;
				if(c == ']' && stack.pop() != '[') return false; 
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		String s = "{[]}";
		System.out.println("The String: "+s);
		System.out.println("The String is Valid: "+isValid(s));
	}
}