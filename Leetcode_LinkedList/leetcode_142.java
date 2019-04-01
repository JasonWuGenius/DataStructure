package Leetcode_LinkedList;

import java.util.HashMap;

public class leetcode_142 {
	/*
	 * ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��
		Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
		˵�����������޸ĸ���������
		ʾ�� 1��
		���룺head = [3,2,0,-4], pos = 1
		�����tail connects to node index 1
		���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
		
		ʹ�ö���ռ��˼·
		����ʹ��һ��hashmap��ȥ����һ������ÿ����һ������
		�������������ڵ㣬��ô�Ͳ���hashmap��������ڣ�
		˵������ڵ��Ѿ������ˣ���ô����ڵ�����ظ��Ľڵ㣬Ϊɶ�ظ��ˣ�
		���ǻ�����ڽڵ��ˡ�
	 */
	//ʹ�ö���ռ�
	public static ListNode detectCycle1(ListNode head){
		HashMap<ListNode, Integer> map = new HashMap<>();
		if(head == null || head.next == null)
			return null;
		while(head != null){
			if(!map.containsKey(head)){
				map.put(head, head.val);
				head = head.next;
			}
			else{
				System.out.println("The Node is :"+head.val);
				return head;
			}
		}
		return null;
	}
	//��ʹ�ö���Ŀռ�
	public static ListNode detectCycle2(ListNode head){
		if(head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean hasCycle = false;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				hasCycle = true;
				break;
			}
		}
		//�ж��Ѿ��л��Ժ�Ĳ���
		if(hasCycle){
			ListNode temp = head;
			while(temp != slow){
				temp = temp.next;
				slow = slow.next;
			}
			return temp;
		}
		else{
			System.out.println("No Cycle");
			return null;
		}
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
		
		System.out.println("The circle entry in the ListNode is : "+detectCycle2(node1));
	}

}
