package Leetcode_LinkedList;

public class LinkedListReverseFromNToM {
	public static ListNode reverseList(ListNode head, int n, int m){
		ListNode pre = null;
		int count = m-n;
		while(head != null && count != 0){
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
			count--;
		}
		return pre;
	}
	
	public static ListNode reverseListFromNToM(ListNode head, int n, int m){
		ListNode cur = new ListNode(-1);
		ListNode node_n = null;
		ListNode node_n_next = null;
		ListNode node_m = null;
		ListNode node_m_next = null;
		cur.next = head;
		int count = 0;
		while(count < m){
			cur = cur.next;
			count++;
			if(count == n-1){
				node_n = cur;
				node_n_next = node_n.next;
				System.out.println(count+":"+node_n.val);
			}
			if(count == m){
				node_m = cur;
				node_m_next = node_m.next;
				System.out.println(count+":"+node_m.val);
			}
		}
		ListNode pre = reverseList(node_n_next, n-1, m);
		node_n.next = pre;
		node_n_next.next = node_m_next;
		return head;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		
		System.out.println("The Before:");
		PrintList.printFromHeadToTail(node1);
		System.out.println("The After:");
		PrintList.printFromHeadToTail(reverseListFromNToM(node1,2,6));
	}
}
