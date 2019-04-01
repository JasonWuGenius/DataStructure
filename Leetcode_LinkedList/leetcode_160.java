package Leetcode_LinkedList;

public class leetcode_160 {
	/**
	 * 
	 * �ཻ����
	 * 
	 *  ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
		���磬�������������
		A:          a1 �� a2
		                   	�K
		                     c1 �� c2 �� c3
		                   	�J            
		B:     b1 �� b2 �� b3
		�ڽڵ� c1 ��ʼ�ཻ��
		
		ע�⣺
		�����������û�н��㣬���� null.
		�ڷ��ؽ���������������뱣��ԭ�еĽṹ��
		�ɼٶ���������ṹ��û��ѭ����
		���������� O(n) ʱ�临�Ӷȣ��ҽ��� O(1) �ڴ档
		
		˼·��
		������������й�ͬ�Ľڵ㣬��ô���ǿ����ȷֱ������������ĳ��ȡ�
		����������A��B�����A�ġ����ȱ�B�ĳ������Ȳ���C����ôA���ȴ�ͷ����߸����Ȳ�C���������ߵĳ��Ⱦ�һ�����ˣ�
		Ȼ������һ����б�����ֱ���ҵ��Ľڵ�����ͬ�Ľڵ㣬��ôѭ���������ҵ�����ڵ㣬���ؼ��ɡ�
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
