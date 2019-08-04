package Leetcode_Dynamic;
/*
	�ж�������

	�����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�

	�������Ϊ s �� t �н�����Ӣ��Сд��ĸ���ַ��� t ���ܻ�ܳ������� ~= 500,000������ s �Ǹ����ַ��������� <=100����

	�ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ���ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���"aec"���ǣ���

	ʾ�� 1:
	s = "abc", t = "ahbgdc"

	���� true.

	ʾ�� 2:
	s = "axc", t = "ahbgdc"

	���� false.

	������ս :

	����д�������� S������S1, S2, ... , Sk ���� k >= 10�ڣ�����Ҫ���μ�������Ƿ�Ϊ T �������С�����������£���������ı���룿

	��л:

	�ر��л @pbrother ��Ӵ����Ⲣ�Ҵ������в���������

*/

class Solution {
    public boolean isSubsequence1(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        int i = 0;
        int j = 0;
        while(j<t.length() && i<s.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == s.length()){
            return true;
        }
        return false;
    }
	
	public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for(char c: s.toCharArray()){
            index = t.indexOf(c, index+1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}

