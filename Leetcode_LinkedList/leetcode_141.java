package Leetcode_LinkedList;

public class leetcode_141 {
	/*
	 * ��������
	 * ����һ�������ж��������Ƿ��л���
		Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
		ʾ�� 1��
		���룺head = [3,2,0,-4], pos = 1
		�����true
		���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
		
		˼·
		ʹ������ָ�룬һ����ָ�룬һ����ָ�룻
		���ÿ��������������ÿ����һ��������л�����ô��Ŀ϶�����׷�����㣬�������
	 */
	public static boolean hasCycle(ListNode head){
		if(head == null || head.next == null)
			return false;
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != null && slow != null){
			if(fast == slow)
				return true;
			slow = slow.next;
			if(fast.next != null)
				fast = fast.next.next;
			else
				return false;
		}
		return false;
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
