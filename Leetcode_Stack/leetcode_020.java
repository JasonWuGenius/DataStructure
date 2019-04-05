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

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                if(c == ')' && stack.pop() != '(')  return false;
                if(c == ']' && stack.pop() != '[')  return false;
                if(c == '}' && stack.pop() != '{')  return false;
            }
        }
        return stack.isEmpty();
    }
}