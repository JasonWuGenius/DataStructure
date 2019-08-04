package Leetcode_LinkedList;

/*
 *  反转链表。
 * 
	示例:
	输入: 1->2->3->4->5->NULL
	输出: 5->4->3->2->1->NULL
	进阶:
	你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	
	思路
	反转链表的话就是需要用三个节点，分别是pre节点代表前一个节点，pNode节点是当前节点，next节点是当前节点的下一个节点;
	我的方法是先去处理最开始的那一个节点，也就是头结点，令头结点的next置为空，然后，pre指向头结点，pNode当前节点是指向head.next,next是指向pNode节点的下一个节点；这是初始化操作;
	然后接下来的操作就是，先用next保存下来pNode的下一个节点，然后就是pNode指向pre,因为pre是pNode的上一个节点，这样可以让反转，因为这里已经反转完毕了，然后就是就是pre和pNode同时往后面进行移动；
	如何移动，很简单就是pre先指向pNode,然后pNode指向next;
	最后循环结束的时候，pNode为空，pre是pNode的前一个，pre是最后一个节点，也是就反转后的头结点，最后返回pre即可
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
	//头插法插入链表
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
	//递归法
	public static ListNode reverseList3(ListNode head){
		if(head.next == null)
			return head;
		ListNode next = head.next;
		head.next = null;
		ListNode re = reverseList3(next);
		next.next = head;
		return re;
	}
	//迭代法
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
		
		System.out.println("打印链表：");
		PrintList.printFromHeadToTail(node1);
		System.out.println("打印反转后链表：");
//		PrintList.printFromHeadToTail(reverseList1(node1));
//		PrintList.printFromHeadToTail(reverseList2(node1));
		PrintList.printFromHeadToTail(reverseList4(node1));
	}
}
