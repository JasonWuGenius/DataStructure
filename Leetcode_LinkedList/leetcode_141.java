package Leetcode_LinkedList;

/*
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
	为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
	示例 1：
	输入：head = [3,2,0,-4], pos = 1
	输出：true
	解释：链表中有一个环，其尾部连接到第二个节点。
	
	思路
	使用两个指针，一个快指针，一个慢指针；
	快的每次走两步，慢的每次走一步，如果有环，那么快的肯定可以追上慢点，两者相等
 */
public class leetcode_141 {
	public static boolean hasCycle(ListNode head){
		if(head == null || head.next == null){
			return false;
		}
		ListNode fast = head.next.next;
		ListNode slow = head.next;
		while(true){
			if(fast == null || fast.next == null){
				return false;
			}
			else if(fast == slow || fast.next == slow){
				return true;
			}
			else{
				slow = slow.next;
				fast = fast.next.next;
			}
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
		
		System.out.println("There is a circle in the ListNode : "+hasCycle(node1));
	}

}
