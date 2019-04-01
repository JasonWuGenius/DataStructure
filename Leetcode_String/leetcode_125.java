package Leetcode_String;

public class leetcode_125 {
	/*
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
		说明：本题中，我们将空字符串定义为有效的回文串。
		示例 1:
		输入: "A man, a plan, a canal: Panama"
		输出: true
		示例 2:
		输入: "race a car"
		输出: false
	 */
	//方法一：
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
	//方法二：
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
