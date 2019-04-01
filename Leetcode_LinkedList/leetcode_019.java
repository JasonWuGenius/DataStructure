package Leetcode_LinkedList;

public class leetcode_019 {
	/*
	 *  ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
		ʾ����
		����һ������: 1->2->3->4->5, �� n = 2.
		��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
		˵����
		������ n ��֤����Ч�ġ�
		���ף�
		���ܳ���ʹ��һ��ɨ��ʵ����
		
		˼·:
		ʹ������ָ�룬һ����ָ�룬һ����ָ�룻
		������Ҫ�ҵ�����K���ڵ㣬����K��2����ô���ǵ����ڶ����ڵ㣻
		��ָ�����ߣ�K-1������Ҳ������1����
		Ȼ�����ָ��ͬʱ�ߣ������ָ���ߵ��������ĩβ����ô��ָ�����ָ����Ҫɾ���Ľڵ㣻
		���ý���ɾ���ڵ��ֵ����һ���ڵ��ֵ�ķ�����ɾ���ڵ㣬�������k��1����ôҲ����Ҫɾ�����һ���ڵ㣬
		��������ֿ��������������ҵ����һ���ڵ㣬ɾ�����ɡ�
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n){
		ListNode fast = head;
		ListNode slow = head;
		for(int i=0; i<n; i++){
			fast = fast.next;
		}
		if(fast == null){
			head = head.next;
			return head;
		}
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
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
		
		System.out.println("Before:");
		PrintList.printFromHeadToTail(node1);
		removeNthFromEnd(node1, 1);
		System.out.println("After Delete:");
		PrintList.printFromHeadToTail(node1);
	}

}
