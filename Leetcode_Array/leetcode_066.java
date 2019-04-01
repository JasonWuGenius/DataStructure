package Leetcode_Array;

import java.util.Arrays;
import java.util.List;

public class leetcode_066 {
	/*
	 * ��1
	 * 
	 * ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
		���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�
		����Լ���������� 0 ֮�⣬��������������㿪ͷ��
		ʾ�� 1:
		����: [1,2,3]
		���: [1,2,4]
		����: ���������ʾ���� 123��
		ʾ�� 2:
		����: [4,3,2,1]
		���: [4,3,2,2]
		����: ���������ʾ���� 4321��
		
		˼·
		������������ۣ�һ���������е����ֶ���9,����999����ʱ�����鳤����Ҫ+1��
		��λ��λ1����λ��λ0��
		��һ��������ǲ�ȫ��9����ô��1�Ļ�������˵��λ��9����ô�ͰѸ�λ��Ϊ0��
		ͬʱ��һλ��1������ͨ���ж�ÿһλ�ǲ���9����������жϣ��Ӹ�λ�����λ����+1��
		ֱ������9�ͽ���ѭ����
	 */
	public static int[] plusOne(int[] digits){
		boolean flag = true;
		for(int i=0; i<digits.length; i++){
			if(digits[i] != 9){
				flag = false;
				break;
			}
		}
		if(flag){
			int[] result = new int[digits.length+1];
			result[0] = 1;
			return result;
		}
		else{
			for(int i=digits.length-1; i>=0; i--){
				if(digits[i] != 9){
					digits[i] += 1;
					break;
				}
				else{
					digits[i] = 0;
				}
			}
		}
		return digits;
	}
	public static void main(String[] args) {
		int[] digits = {9,9,9};
//		int[] digits = {4,3,2,1};
		System.out.println("The origin digits: ");
		for(int item: digits){
			System.out.print(item+" ");
		}
		System.out.println("\nThe result of Plusing One: ");
		for(int item: plusOne(digits)){
			System.out.print(item+" ");
		}
	}

}
