package Leetcode_LinkedList;

public class leetcode_160 {
	/**
	 * 
	 * 相交链表
	 * 
	 *  编写一个程序，找到两个单链表相交的起始节点。
		例如，下面的两个链表：
		A:          a1 → a2
		                   	↘
		                     c1 → c2 → c3
		                   	↗            
		B:     b1 → b2 → b3
		在节点 c1 开始相交。
		
		注意：
		如果两个链表没有交点，返回 null.
		在返回结果后，两个链表仍须保持原有的结构。
		可假定整个链表结构中没有循环。
		程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
		
		思路：
		如果两个链表有共同的节点，那么就是可以先分别计算两个链表的长度。
		两个链表是A和B，如果A的·长度比B的长，长度差是C，那么A就先从头结点走个长度差C，这样两者的长度就一样长了；
		然后两者一起进行遍历，直到找到的节点是相同的节点，那么循环结束，找到这个节点，返回即可。
	 */
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB){
		if(headA == null || headB == null){
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		while(pA != pB){
			pA = pA == null? headB : pA.next;
			pB = pB == null? headA : pB.next;
			try{
				System.out.println("--PA: "+pA.val);
				System.out.println("  PB: "+pB.val);
			}
			catch(Exception e){
				System.out.println("Error");
			}
		}
		return pA;
	}
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB){
		if(headA == null || headB == null){
			return null;
		}
		ListNode pA = headA;
		ListNode pB = headB;
		int lenA = 0;
		int lenB = 0;
		while(pA != null){
			pA = pA.next;
			lenA++;
		}
		while(pB != null){
			pB = pB.next;
			lenB++;
		}
		if(lenA > lenB){
			int span = lenA - lenB;
			for(int i=0 ;i<span; i++){
				headA = headA.next;
			}
		}
		if(lenB > lenA){
			int span = lenB - lenA;
			for(int i=0 ;i<span; i++){
				headB = headB.next;
			}
		}
		while(headB != null){
			if(headA == headB){
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
	public static void main(String[] args) {
		ListNode node = new ListNode(6);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(8);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(0);
		ListNode node8 = new ListNode(1);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node6.next = node7;
		node7.next = node8;
		node8.next = node3;
		
		System.out.println("The List1: ");
		PrintList.printFromHeadToTail(node);
		System.out.println("The List2: ");
		PrintList.printFromHeadToTail(node6);
		ListNode intersectionNode = getIntersectionNode2(node, node6);
		System.out.println("The Intersection Node is: "+intersectionNode.val);
	}

}
