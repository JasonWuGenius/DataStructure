package Leetcode_LinkedList;

public class leetcode_002 {
	/*
	 * 两数相加
	 * 
	 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
		如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
		您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
		示例：
		输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
		输出：7 -> 0 -> 8
		原因：342 + 465 = 807
		
		请特别注意以下情况：
		测试用例	说明
		l1=[0,1]
		l2=[0,1,2]	当一个列表比另一个列表长时。
		l1=[]
		l2=[0,1]	当一个列表为空时，即出现空列表。
		l1=[9,9]
		l2=[1]   	求和运算最后可能出现额外的进位，这一点很容易被遗忘
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
