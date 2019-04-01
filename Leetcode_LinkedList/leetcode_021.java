package Leetcode_LinkedList;

public class leetcode_021 {
	/*
	 *  ��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ� 
		ʾ����
		���룺1->2->4, 1->3->4�����1->1->2->3->4->4
		
		˼·��
		1���ϲ�������������������������������ģ���ô������ȥ�Ƚ���������ĵ�ǰ�ڵ�Ĵ�С�������½�һ��ͷ���temp����������һ���µ������ͷ��㡣
		2������A��B������A�ĵ�ǰ�ڵ��ǽڵ�A1������B�ĵ�ǰ�Ľڵ��ǽڵ�B1��Ȼ��ȥ�Ƚ�A1��B1�Ĵ�С�����A1��B1С����ôtemp����һ���ڵ��ָ��A1,ͬʱ����A�����ƶ�һ���ڵ㣻
		3������Ƚ�A1��B1�Ĵ�С������A1��B1����ôtemp����һ���ڵ��ָ��B1��ͬʱ����B�����ƶ�һ���ڵ㣻
		4��ֱ������A��������B���е�һ������Ϊ���ˣ���ôѭ��������
		5��������˵����AΪ���ˣ���ôB���ܲ�Ϊ�գ�����temp����һ���ڵ�ָ��B�������Ͱ�ʣ���B�Ľڵ�����˺��棻
		6������������BΪ���ˣ���ôA���ܲ�Ϊ�գ�����temp����һ���ڵ�ָ��A�������Ͱ�ʣ���A����Ľڵ������temp�ĺ���
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
		
		System.out.println("��ӡ����1��");
		PrintList.printFromHeadToTail(node1);
		System.out.println("��ӡ����2��");
		PrintList.printFromHeadToTail(node4);
		System.out.println("��ӡ�ϲ�����");
		PrintList.printFromHeadToTail(mergeTwoLists(node1, node4));
	}

}
