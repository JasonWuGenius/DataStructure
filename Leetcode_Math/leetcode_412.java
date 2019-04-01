package Leetcode_Math;

import java.util.ArrayList;
import java.util.List;

public class leetcode_412 {
	/*
	 * Fizz Buzz
	 * 
	 * дһ����������� 1 �� n ���ֵ��ַ�����ʾ��
		1. ��� n ��3�ı����������Fizz����
		2. ��� n ��5�ı����������Buzz����
		3.��� n ͬʱ��3��5�ı�������� ��FizzBuzz����
		ʾ����
		n = 15,
		����:
		[
		    "1",
		    "2",
		    "Fizz",
		    "4",
		    "Buzz",
		    "Fizz",
		    "7",
		    "8",
		    "Fizz",
		    "Buzz",
		    "11",
		    "Fizz",
		    "13",
		    "14",
		    "FizzBuzz"
		]
	 */
	public static List<String> fizzBuzz(int n){
		System.out.println("The n is: "+n);
		List<String> list = new ArrayList<>(n);
		if(n<=0){
			return null;
		}
		int i=1;
		while(i<=n){
			if(i%3 != 0 && i%5 != 0){
				list.add(i+"");
			}
			else if(i%3 == 0 && i%5 == 0){
				list.add("FizzBuzz");
			}
			else if(i%3 == 0){
				list.add("Fizz");
			}
			else{
				list.add("Buzz");
			}
			i++;
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println("The result List is: "+fizzBuzz(15));
	}

}
