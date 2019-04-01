package Leetcode_Dynamic;

public class leetcode_070 {
	/*
	 * ��¥��
	 * 
	 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
		ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
		ע�⣺���� n ��һ����������
		ʾ�� 1��
		���룺 2
		����� 2
		���ͣ� �����ַ�����������¥����
		1.  1 �� + 1 ��
		2.  2 ��
		ʾ�� 2��
		���룺 3
		����� 3
		���ͣ� �����ַ�����������¥����
		1.  1 �� + 1 �� + 1 ��
		2.  1 �� + 2 ��
		3.  2 �� + 1 ��
	 */
	//����һ���ݹ鷨
	public static int climbStairs1(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		return climbStairs1(n-1)+climbStairs1(n-2);
	}
	//��������
	public static int climbStairs2(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		int a = 1;
		int b = 2;
		int i=2;
		while(i<n){
			int temp = a+b;
			a = b;
			b = temp;
			i++;
			System.out.print(b+" ");
		}
		return b;
	}
	public static void main(String[] args) {
		System.out.println("The Solution is: "+climbStairs1(8));
		System.out.println("The Solution is: "+climbStairs2(8));
	}

}
