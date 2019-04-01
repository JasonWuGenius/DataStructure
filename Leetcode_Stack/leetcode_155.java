package Leetcode_Stack;

import java.util.Stack;

public class leetcode_155 {
	/*
	 * ��Сջ
	 * 
	 * ���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
		push(x) -- ��Ԫ�� x ����ջ�С�
		pop() -- ɾ��ջ����Ԫ�ء�
		top() -- ��ȡջ��Ԫ�ء�
		getMin() -- ����ջ�е���СԪ�ء�
		ʾ��:
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();   --> ���� -3.
		minStack.pop();
		minStack.top();      --> ���� 0.
		minStack.getMin();   --> ���� -2.
		
		˼·��ÿ����ջ2��Ԫ�أ�һ������ջ��Ԫ�ر���һ���ǵ�ǰջԪ�ص���Сֵ 
		 �磺��ջ����Ϊ2-3-1������ջ��ջ��Ԫ������Ϊ��2-2-3-2-1-1 
	 */
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minstack = new Stack<Integer>();
	public leetcode_155(){
		
	}
	
	public void push(int x){
		if(minstack.isEmpty() || x<minstack.peek()){
			minstack.push(x);
		}
		else{
			minstack.push(minstack.peek());
		}
		stack.push(x);
	}

	public void pop(){
		minstack.pop();
		stack.pop();
	}
	
	public int top(){
		return stack.peek();
	}
	
	public int getMin(){
		return minstack.peek();
	}
	
	public static void main(String[] args) {
		leetcode_155 l155 = new leetcode_155();
		l155.push(-2);
		l155.push(0);
		l155.push(-3);
		System.out.println(l155.getMin());
		l155.pop();
		System.out.println(l155.top());
		l155.top();
		System.out.println(l155.getMin());
	}
}
