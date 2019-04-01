package Leetcode_Stack;

import java.util.Stack;

public class leetcode_155 {
	/*
	 * 最小栈
	 * 
	 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
		push(x) -- 将元素 x 推入栈中。
		pop() -- 删除栈顶的元素。
		top() -- 获取栈顶元素。
		getMin() -- 检索栈中的最小元素。
		示例:
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin();   --> 返回 -3.
		minStack.pop();
		minStack.top();      --> 返回 0.
		minStack.getMin();   --> 返回 -2.
		
		思路：每次入栈2个元素，一个是入栈的元素本身，一个是当前栈元素的最小值 
		 如：入栈序列为2-3-1，则入栈后栈中元素序列为：2-2-3-2-1-1 
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
