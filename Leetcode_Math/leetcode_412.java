package Leetcode_Math;

import java.util.ArrayList;
import java.util.List;

public class leetcode_412 {
	/*
	 * Fizz Buzz
	 * 
	 * 写一个程序，输出从 1 到 n 数字的字符串表示。
		1. 如果 n 是3的倍数，输出“Fizz”；
		2. 如果 n 是5的倍数，输出“Buzz”；
		3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
		示例：
		n = 15,
		返回:
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
