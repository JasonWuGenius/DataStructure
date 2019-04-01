package Leetcode_LinkedList;

public class leetcode_203 {
	/*
	 *  删除链表中等于给定值 val 的所有节点。
		示例:
		输入: 1->2->6->3->4->5->6, val = 6
		输出: 1->2->3->4->5

		思路：
		首先是删除开头的节点与val值相等的节点；
		然后是删除中间的与val相等的节点，采取之前的这道题的解法每天一道leetcode237-删除链表中的节点，
		就是交换当前节点与下一个节点的val值，然后把下一个节点删除就行；
		最后处理最后的一个节点。
	 */
	//现在表头添加一个header结点
	public static ListNode removeElements(ListNode head, int val){
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode curNode = header;
		while(curNode.next != null){
			if(curNode.next.val == val){
				curNode.next = curNode.next.next;
			}
			else{
				curNode = curNode.next;
			}
		}
		return header.next;
	}
	public static void printFromHeadToTail(ListNode node){
		while(node != null){
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		System.out.println("The Original List:");
		printFromHeadToTail(node1);
		System.out.println("The Changed List:");
		ListNode newHead = removeElements(node1, 2);
		printFromHeadToTail(newHead);
	}

}
