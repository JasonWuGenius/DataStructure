package Leetcode_LinkedList;

/*
 * ��������
 * ���ж�һ�������Ƿ�Ϊ��������
	ʾ�� 1:
	����: 1->2
	���: false
	ʾ�� 2:
	����: 1->2->2->1
	���: true
	
	����ACֻ��һ�����������Ĵ���˼·
	֮ǰӦ���п������ڻ��������һ�ֽⷨ�����Ƕ��������ÿ��Ԫ�����γ���1,2,3,4�����һ����sum1;
	Ȼ����ǰ��������ת����ת��������������������ÿ��һ��leetcode206-��ת����ֱ�ӰѴ��������ã��õ���ת�������;
	Ȼ����������ת����������α���Ȼ�����ÿ��Ԫ�����γ���1,2,3,4�����һ����sum2;
	Ȼ��Ƚ��������sumֵ�������ȣ���ô���ǻ�������
 */
public class leetcode_234 {
	//����һ��
	public static boolean isPalindrome1(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = reverse(slow.next);
		if(slow != null){
			if(slow.val != head.val){
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
	}
	private static ListNode reverse(ListNode head){
		ListNode pre = null;
		while(head != null){
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println("The List is Palindrome: "+isPalindrome1(node1));
	}

}
	