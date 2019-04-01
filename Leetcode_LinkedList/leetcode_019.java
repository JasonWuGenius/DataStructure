package Leetcode_LinkedList;

public class leetcode_019 {
	/*
	 *  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
		示例：
		给定一个链表: 1->2->3->4->5, 和 n = 2.
		当删除了倒数第二个节点后，链表变为 1->2->3->5.
		说明：
		给定的 n 保证是有效的。
		进阶：
		你能尝试使用一趟扫描实现吗？
		
		思路:
		使用两个指针，一个快指针，一个慢指针；
		由于是要找倒数第K个节点，比如K是2，那么就是倒数第二个节点；
		快指针先走（K-1）步，也就是走1步；
		然后快慢指针同时走，当快的指针走到了链表的末尾，那么慢指针就是指向了要删除的节点；
		采用交换删除节点的值与下一个节点的值的方法来删除节点，这里如果k是1，那么也就是要删除最后一个节点，
		所以这个分开处理，遍历链表找到最后一个节点，删除即可。
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n){
		ListNode fast = head;
		ListNode slow = head;
		for(int i=0; i<n; i++){
			fast = fast.next;
		}
		if(fast == null){
			head = head.next;
			return head;
		}
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		System.out.println("Before:");
		PrintList.printFromHeadToTail(node1);
		removeNthFromEnd(node1, 1);
		System.out.println("After Delete:");
		PrintList.printFromHeadToTail(node1);
	}

}
