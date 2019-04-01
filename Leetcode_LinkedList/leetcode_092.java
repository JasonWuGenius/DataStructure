package Leetcode_LinkedList;

public class leetcode_092 {
	/*
	 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
		说明:
		1 ≤ m ≤ n ≤ 链表长度。
		示例:
		输入: 1->2->3->4->5->NULL, m = 2, n = 4
		输出: 1->4->3->2->5->NULL
		
		思路
		分两种情况讨论哈，一种是m等于1的，一种是m不等于1的
		m等于1的话，简单，就是一个反转链表，如何反转见这篇文章，之前写过；m等于1的话，先反转m-n这些节点，反转完成以后，一开始的头结点就成了最后一个节点，所以反转前把这个节点保留下来，然后反转结束以后把后面的连起来就行；
		m不等于1的话，说明是反转的中间部分的这些节点，
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n){
		if(head == null || head.next == null){
			return head;
		}
		if(m != 1){
			ListNode temp = head.next;
			
		}
	}

}
