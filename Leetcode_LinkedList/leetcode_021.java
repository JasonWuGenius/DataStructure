package Leetcode_LinkedList;

public class leetcode_021 {
	/*
	 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
		示例：
		输入：1->2->4, 1->3->4输出：1->1->2->3->4->4
		
		思路：
		1、合并两个有序链表，由于两个链表是有序的，那么就依次去比较两个链表的当前节点的大小；首先新建一个头结点temp，用来代表一个新的链表的头结点。
		2、链表A和B，链表A的当前节点是节点A1，链表B的当前的节点是节点B1，然后去比较A1与B1的大小，如果A1比B1小，那么temp的下一个节点就指向A1,同时链表A往下移动一个节点；
		3、如果比较A1与B1的大小，发现A1比B1大，那么temp的下一个节点就指向B1，同时链表B往下移动一个节点；
		4、直到链表A或者链表B当中的一个链表为空了，那么循环结束。
		5、最后比如说链表A为空了，那么B可能不为空，所以temp的下一个节点指向B，这样就把剩余的B的节点接在了后面；
		6、最后如果链表B为空了，那么A可能不为空，所以temp的下一个节点指向A，这样就把剩余的A链表的节点接在了temp的后面
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode temp = new ListNode(-1);
		ListNode result = temp;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				temp.next = l1;
				temp = temp.next;
				l1 = l1.next;
			}
			else{
				temp.next = l2;
				temp = temp.next;
				l2 = l2.next;
			}
		}
		if(l1 == null){
			temp.next = l2;
		}
		if(l2 == null){
			temp.next = l1;
		}
		return result.next;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		node4.next = node5;
		node5.next = node6;
		
		System.out.println("打印链表1：");
		PrintList.printFromHeadToTail(node1);
		System.out.println("打印链表2：");
		PrintList.printFromHeadToTail(node4);
		System.out.println("打印合并链表：");
		PrintList.printFromHeadToTail(mergeTwoLists(node1, node4));
	}

}
