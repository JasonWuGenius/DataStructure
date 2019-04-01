package Other;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {
	/*
	 * Stack是Vector的子类，实现标准的先进后出。
	 */
	public static void showpush(Stack<Integer> st, int a){
		st.push(new Integer(a));
		System.out.println("push("+a+")");
		System.out.println("stack"+st);
	}
	public static void showpop(Stack<Integer> st){
		System.out.print("pop -> ");
		Integer a = (Integer) st.pop();
		System.out.println(a);
		System.out.println("stack"+st);
	}
	public static void main(String[] args) {
		Stack<Integer> st = new Stack();
		System.out.println("stack:"+st);
		showpush(st, 1);
		showpush(st, 2);
		showpush(st, 3);
		showpop(st);
		showpop(st);
		showpop(st);
		try{
			showpop(st);
		}
		catch(EmptyStackException e){
			System.out.println("empty stack");
		}
	}

}
