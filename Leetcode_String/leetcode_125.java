package Leetcode_String;

public class leetcode_125 {
	/*
	 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
		˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���
		ʾ�� 1:
		����: "A man, a plan, a canal: Panama"
		���: true
		ʾ�� 2:
		����: "race a car"
		���: false
	 */
	//����һ��
	public static boolean isPalindrome1(String s){
		s = s.toLowerCase();
		char[] charArray = s.toCharArray();
		String temp = "";
		for(int i=0; i<charArray.length; i++){
			if (((int)charArray[i] >= 48 && (int)charArray[i] <= 57) || 
					((int)charArray[i] >= 97 && (int)charArray[i] <=122)){
				temp +=charArray[i];
			}
		}
		char[] resultArray = temp.toCharArray();
		int begin = 0, end = resultArray.length-1;
		while(begin < end){
			if(resultArray[begin] == resultArray[end]){
				begin++;
				end--;
			}
			else{
				return false;
			}
		}
		return true;
	}
	//��������
	public static boolean isPalindrome2(String s){
        if(s == null)
            return true;
        if(s.length() == 0)
            return true;
        s = s.toLowerCase();
        int len = s.length();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder(len);
        for(char c: s.toCharArray()){
            if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')){
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
	}
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
//		String s = "race a car";
		System.out.println("The String is Palindrome: "+isPalindrome2(s));
	}

}
