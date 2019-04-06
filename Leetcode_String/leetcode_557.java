/*
	��ת�ַ����еĵ���3

	����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��

	ʾ�� 1:

	����: "Let's take LeetCode contest"
	���: "s'teL ekat edoCteeL tsetnoc" 
	ע�⣺���ַ����У�ÿ�������ɵ����ո�ָ��������ַ����в������κζ���Ŀո�

*/

class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++){
            char[] chrs = strs[i].toCharArray();
            swap(chrs);
            if(i != strs.length-1){
                sb.append(new String(chrs) + " ");    
            }
            else{
                sb.append(new String(chrs));
            }
        }
        return sb.toString();  
    }
    private void swap(char[] chrs){
        for(int i=0; i<chrs.length/2; i++){
            char temp = chrs[i];
            chrs[i] = chrs[chrs.length-1-i];
            chrs[chrs.length-1-i] = temp;
        }
    }
}