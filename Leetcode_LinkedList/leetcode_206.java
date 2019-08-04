package Leetcode_LinkedList;

/*
 *  ��ת����
 * 
	ʾ��:
	����: 1->2->3->4->5->NULL
	���: 5->4->3->2->1->NULL
	����:
	����Ե�����ݹ�ط�ת�������ܷ������ַ����������⣿
	
	˼·
	��ת����Ļ�������Ҫ�������ڵ㣬�ֱ���pre�ڵ����ǰһ���ڵ㣬pNode�ڵ��ǵ�ǰ�ڵ㣬next�ڵ��ǵ�ǰ�ڵ����һ���ڵ�;
	�ҵķ�������ȥ�����ʼ����һ���ڵ㣬Ҳ����ͷ��㣬��ͷ����next��Ϊ�գ�Ȼ��preָ��ͷ��㣬pNode��ǰ�ڵ���ָ��head.next,next��ָ��pNode�ڵ����һ���ڵ㣻���ǳ�ʼ������;
	Ȼ��������Ĳ������ǣ�����next��������pNode����һ���ڵ㣬Ȼ�����pNodeָ��pre,��Ϊpre��pNode����һ���ڵ㣬���������÷�ת����Ϊ�����Ѿ���ת����ˣ�Ȼ����Ǿ���pre��pNodeͬʱ����������ƶ���
	����ƶ����ܼ򵥾���pre��ָ��pNode,Ȼ��pNodeָ��next;
	���ѭ��������ʱ��pNodeΪ�գ�pre��pNode��ǰһ����pre�����һ���ڵ㣬Ҳ�Ǿͷ�ת���ͷ��㣬��󷵻�pre����
 */
public class leetcode_206 {
	public static ListNode reverseList1(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode pre = head;
		ListNode pNode = head.next;
		ListNode next = head;
		pre.next = null;
		while(pNode != null)
	    {
		    next = pNode.next;
		    pNode.next = pre;
		    pre = pNode;
		    pNode = next;
	    }
	    return pre;
	}
	//ͷ�巨��������
	public static ListNode reverseList2(ListNode head){
		ListNode pre = null;
		while(head != null){
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	//�ݹ鷨
	public static ListNode reverseList3(ListNode head){
		if(head.next == null)
			return head;
		ListNode next = head.next;
		head.next = null;
		ListNode re = reverseList3(next);
		next.next = head;
		return re;
	}
	//������
	public static ListNode reverseList4(ListNode head){
		if(head.next == null){
			return head;
		}
		ListNode next = head.next;
		head.next = null;
		ListNode re = reverseList4(next);
		next.next = head;
		return re;
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
		
		System.out.println("��ӡ����");
		PrintList.printFromHeadToTail(node1);
		System.out.println("��ӡ��ת������");
//		PrintList.printFromHeadToTail(reverseList1(node1));
//		PrintList.printFromHeadToTail(reverseList2(node1));
		PrintList.printFromHeadToTail(reverseList4(node1));
	}
}
