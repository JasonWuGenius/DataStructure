package Leetcode_LinkedList;

public class leetcode_234 {
	/*
	 * 回文链表
	 * 请判断一个链表是否为回文链表。
		示例 1:
		输入: 1->2
		输出: false
		示例 2:
		输入: 1->2->2->1
		输出: true
		
		距离AC只差一个测试用例的错误思路
		之前应该有看过关于回文链表的一种解法，就是对于链表的每个元素依次乘以1,2,3,4…求得一个和sum1;
		然后就是把这个链表反转，反转链表正好昨天做过哈，每天一道leetcode206-反转链表，直接把代码拿来用，得到反转后的链表;
		然后对于这个反转后的链表，依次遍历然后对于每个元素依次乘以1,2,3,4…求得一个和sum2;
		然后比较这个两个sum值，如果相等，那么就是回文链表
	 */
	//方法一：
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
	//方法二：
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
	