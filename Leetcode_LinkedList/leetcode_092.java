package Leetcode_LinkedList;

public class leetcode_092 {
	/*
	 * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
		˵��:
		1 �� m �� n �� �����ȡ�
		ʾ��:
		����: 1->2->3->4->5->NULL, m = 2, n = 4
		���: 1->4->3->2->5->NULL
		
		˼·
		������������۹���һ����m����1�ģ�һ����m������1��
		m����1�Ļ����򵥣�����һ����ת������η�ת����ƪ���£�֮ǰд����m����1�Ļ����ȷ�תm-n��Щ�ڵ㣬��ת����Ժ�һ��ʼ��ͷ���ͳ������һ���ڵ㣬���Է�תǰ������ڵ㱣��������Ȼ��ת�����Ժ�Ѻ�������������У�
		m������1�Ļ���˵���Ƿ�ת���м䲿�ֵ���Щ�ڵ㣬
	 */
	public static ListNode reverseBetween(ListNode head, int m, int n){
		if(head == null || head.next == null){
			return head;
		}
		if(m != 1){
			ListNode temp = head.next;
			
		}
	}

}
