package Leetcode_LinkedList;

public class PrintList {
	//��ӡ����
	public static void printFromHeadToTail(ListNode node){
		while(node != null){
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}
}
