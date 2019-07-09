package Leetcode_Dynamic;

/*
 * ��ͬ������������
 * 
 * ����һ������ n������?1 ...?n?Ϊ�ڵ���ɵĶ����������ж����֣�

	ʾ��:

	����: 3
	���: 5
	����:
	���� n = 3, һ���� 5 �ֲ�ͬ�ṹ�Ķ���������:

		1         3     3      2      1
		\       /     /      / \      \
		3     2     1      1   3      2
		/     /       \                 \
		2     1         2                 3

	˼·��
	˼· ��ǩ����̬�滮 ����n���ڵ���ڶ����������ĸ�����G(n)��
	��f(i)Ϊ��iΪ���Ķ����������ĸ������� G(n) = f(1) + f(2) + 
	f(3) + f(4) + ... + f(n) 
	��iΪ���ڵ�ʱ�����������ڵ����Ϊi-1�����������ڵ�Ϊn-i
	���� f(i) = G(i-1)*G(n-i)
 */
public class leetcode_096 {
	public static int numTrees(int n) {
		if(n <= 1){
			return 1;
		}
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++){
			int count = 0;
			for(int j=1; j<=i; j++){
				count += dp[j-1]*dp[i-j];
			}
			dp[i] = count;
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 8;
		System.out.println("The n is: "+n);
		System.out.println("The Solution is: "+numTrees(n));
	}

}
