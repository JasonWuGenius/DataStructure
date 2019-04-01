package Leetcode_LinkedList;

public class leetcode_328 {
	/*
	 * ��ż����
	 * 
	 * ����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
		�볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������
		ʾ�� 1:
		����: 1->2->3->4->5->NULL
		���: 1->3->5->2->4->NULL
		ʾ�� 2:
		����: 2->1->3->5->6->4->7->NULL 
		���: 2->3->6->7->1->5->4->NULL
		˵��:
		Ӧ�����������ڵ��ż���ڵ�����˳��
		����ĵ�һ���ڵ���Ϊ�����ڵ㣬�ڶ����ڵ���Ϊż���ڵ㣬�Դ����ơ�
	 */
	public static ListNode oddEvenList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode o = head;
		ListNode p = head.next;
		ListNode e = p;
		while(o.next != null && e.next != null){
			o.next = e.next;
			o = o.next;
			e.next = o.next;
			e = e.next;
		}
		o.next = p;
		return head;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		System.out.println("The List1 - Before - : ");
		PrintList.printFromHeadToTail(node1);
		ListNode newNode = oddEvenList(node1);
		System.out.println("The List1 - After - : ");
		PrintList.printFromHeadToTail(newNode);
		
	}

}
