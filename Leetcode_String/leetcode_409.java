package Leetcode_String;

public class leetcode_409 {
	/*
	 * ����Ĵ�
	 * 
	 * ����һ��������д��ĸ��Сд��ĸ���ַ������ҵ�ͨ����Щ��ĸ����ɵ���Ļ��Ĵ���
		�ڹ�������У���ע�����ִ�Сд������ "Aa" ���ܵ���һ�������ַ�����
		ע��:
		�����ַ����ĳ��Ȳ��ᳬ�� 1010��
		ʾ�� 1:
		����:
		"abccccdd"
		���:
		7
		����:
		���ǿ��Թ������Ļ��Ĵ���"dccaccd", ���ĳ����� 7��
	 */
	public static int longestPalindrome(String s){
		int[] arr = new int[123];
		for(char c:s.toCharArray()){
			arr[(int)c]++;
		}
		int len=0;
		boolean flag = false;
		for(int i=0; i<arr.length; i++){
			if(arr[i]%2==0){
				len += arr[i];
			}
			else{
				len += arr[i]-1;
				flag = true;
			}
		}
		return flag==false? len:len+1;
	}
	public static void main(String[] args) {
		String s = "dccaccd";
		System.out.println("The String: "+s);
		System.out.println("The longestPalindrome: "+longestPalindrome(s));
	}

}
