package Leetcode_LinkedList;

public class leetcode_234 {
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
	//����һ��
	public static boolean isPalindrome1(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		slow = reverse(slow.next);
		while(slow != null){
			if(head.val != slow.val){
				return false;
			}
			head = head.next;
			slow = slow.next;
		}
		return true;
	}
	private static ListNode reverse(ListNode head){
		if(head.next == null){
			return head;
		}
		ListNode temp = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
	}
	//��������
	public static boolean isPalindrome2(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		int sum1 = 0;
		int count = 1;
		ListNode temp = head;
		while(temp != null){
			sum1 += count*temp.val;
			count += 1;
			temp = temp.next;
		}
		int sum2 = 0;
		count = 1;
		temp = reverseList(head);
		while(temp != null){
			sum2 += count*temp.val;
			count += 1;
			temp = temp.next;
		}
		if(sum1 == sum2){
			return true;
		}
		return false;
	}
	public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode pre = null;
		ListNode now = head;
		while(now != null){
			ListNode next = now.next;
			now.next = pre;
			pre = now;
			now = next;
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
//		System.out.println("The List is Palindrome: "+isPalindrome2(node1));
	}

}
	