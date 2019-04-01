package Leetcode_LinkedList;

public class leetcode_002 {
	/*
	 * �������
	 * 
	 * �������� �ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
		��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
		�����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
		ʾ����
		���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
		�����7 -> 0 -> 8
		ԭ��342 + 465 = 807
		
		���ر�ע�����������
		��������	˵��
		l1=[0,1]
		l2=[0,1,2]	��һ���б����һ���б�ʱ��
		l1=[]
		l2=[0,1]	��һ���б�Ϊ��ʱ�������ֿ��б�
		l1=[9,9]
		l2=[1]   	������������ܳ��ֶ���Ľ�λ����һ������ױ�����
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while(p != null || q != null){
			int x = (p!=null)? p.val:0;
			int y = (q!=null)? q.val:0;
			int sum = carry+x+y;
			carry = sum/10;
			curr.next = new ListNode(sum%10);
			curr = curr.next;
			if(p != null) p = p.next;
			if(q != null) q = q.next;
		}
		if(carry > 0){
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(9);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node4.next = node5;
		node5.next = node6;
		
		System.out.println("The List1: ");
		PrintList.printFromHeadToTail(node1);
		System.out.println("The List2: ");
		PrintList.printFromHeadToTail(node4);
		System.out.println("The New List: ");
		ListNode newNode = addTwoNumbers(node1, node4);
		PrintList.printFromHeadToTail(newNode);
	}

}
