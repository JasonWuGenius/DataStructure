package Leetcode_LinkedList;

import java.util.HashMap;

public class leetcode_142 {
	/*
	 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
		为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
		说明：不允许修改给定的链表。
		示例 1：
		输入：head = [3,2,0,-4], pos = 1
		输出：tail connects to node index 1
		解释：链表中有一个环，其尾部连接到第二个节点。
		
		使用额外空间的思路
		就是使用一个hashmap，去遍历一遍链表，每遍历一个链表，
		如果不存在这个节点，那么就插入hashmap，如果存在，
		说明这个节点已经插入了，那么这个节点就是重复的节点，为啥重复了，
		就是环的入口节点了。
	 */
	//使用额外空间
	public static ListNode detectCycle1(ListNode head){
		HashMap<ListNode, Integer> map = new HashMap<>();
		if(head == null || head.next == null)
			return null;
		while(head != null){
			if(!map.containsKey(head)){
				map.put(head, head.val);
				head = head.next;
			}
			else{
				System.out.println("The Node is :"+head.val);
				return head;
			}
		}
		return null;
	}
	//不使用额外的空间
	public static ListNode detectCycle2(ListNode head){
		if(head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean hasCycle = false;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				hasCycle = true;
				break;
			}
		}
		//判断已经有环以后的操作
		if(hasCycle){
			ListNode temp = head;
			while(temp != slow){
				temp = temp.next;
				slow = slow.next;
			}
			return temp;
		}
		else{
			System.out.println("No Cycle");
			return null;
		}
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		System.out.println("The circle entry in the ListNode is : "+detectCycle2(node1));
	}

}
