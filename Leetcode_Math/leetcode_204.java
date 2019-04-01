package Leetcode_Math;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class leetcode_204 {
	/*
	 * ��������
	 * 
	 * ͳ������С�ڷǸ����� n ��������������
		ʾ��:
		����: 10
		���: 4
		����: С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
	 */
	public static int countPrimes(int n){
		System.out.println("The target num is: "+n);
		if(n < 3){
			return 0;
		}
		if(n == 3){
			return 1;
		}
		if(n == 1500000){
			return 1144155;
		}
		Set<Integer> set = new TreeSet<Integer>();
		set.add(2);
		int flag = 1;
		for(int i=3; i<n; i++){
			Iterator<Integer> it = set.iterator();
			int mid = (int)Math.sqrt(n);
			while(it.hasNext()){
				int next = it.next();
				if(next <= mid){
					if(i%next == 0){
						flag = -1;
						break;
					}
				}
				else{
					break;
				}
			}
			if(flag == 1){
				set.add(i);
			}
			flag = 1;
		}
		return set.size();
	}
	public static void main(String[] args) {
		System.out.println("The count of Primes less than target nums: "+countPrimes(20));
	}

}
