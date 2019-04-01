package Leetcode_Math;

public class leetcode_326 {
	/*
	 * 3����
	 * 
	 * ����һ��������дһ���������ж����Ƿ��� 3 ���ݴη���
		ʾ�� 1:
		����: 27
		���: true
		ʾ�� 2:
		����: 0
		���: false
		ʾ�� 3:
		����: 9
		���: true
		ʾ�� 4:
		����: 45
		���: false
		���ף�
		���ܲ�ʹ��ѭ�����ߵݹ�����ɱ�����
	 */
	public static boolean isPowerOfThree(int n){
		System.out.println("n is: "+n);
		if(n<=1){
			return false;
		}
		while(n>1){
			if(n%3 != 0){
				return false;
			}
			n /= 3;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("The n is the power of three: "+isPowerOfThree(1));
	}

}
