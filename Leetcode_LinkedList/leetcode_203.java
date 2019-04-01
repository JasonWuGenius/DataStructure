package Leetcode_LinkedList;

public class leetcode_203 {
	/*
	 *  ɾ�������е��ڸ���ֵ val �����нڵ㡣
		ʾ��:
		����: 1->2->6->3->4->5->6, val = 6
		���: 1->2->3->4->5

		˼·��
		������ɾ����ͷ�Ľڵ���valֵ��ȵĽڵ㣻
		Ȼ����ɾ���м����val��ȵĽڵ㣬��ȡ֮ǰ�������Ľⷨÿ��һ��leetcode237-ɾ�������еĽڵ㣬
		���ǽ�����ǰ�ڵ�����һ���ڵ��valֵ��Ȼ�����һ���ڵ�ɾ�����У�
		���������һ���ڵ㡣
	 */
	//���ڱ�ͷ���һ��header���
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
