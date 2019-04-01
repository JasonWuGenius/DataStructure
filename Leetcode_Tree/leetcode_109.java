package Leetcode_Tree;


public class leetcode_109 {
	/*
	 *  ��������ת���ɶ���������
	 *  
	 *  ����һ�����������е�Ԫ�ذ��������򣬽���ת��Ϊ�߶�ƽ��Ķ�����������
		�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��
		ʾ��:
		�������������� [-10, -3, 0, 5, 9],
		һ�����ܵĴ��ǣ�[0, -3, 9, -10, null, 5], �����Ա�ʾ��������߶�ƽ�������������
		      0
		     / \
		   -3   9
		   /   /
		 -10  5
		
		��һ����������ת��Ϊƽ�����������������ƽ������������Ķ��壬
		���ǿ���ÿ��ȡ��������м����Ϊ���ڵ㣬Ȼ�������������м����Ϊ���ڵ�����ӽڵ㣬
		�ұ���������м����Ϊ���ڵ�����ӽڵ㡣������������ַ�ʽ��һ���Ǳ����������Σ�������ת��Ϊ���飬
		��ô�ͱ�ɺ���һ��һ���ˣ���һ����������ָ��õ�������м�㡣
	 */
	//����һ��ת��δ����
	public static TreeNode sortedListToBST1(ListNode head){
		int size = 0;
		ListNode curNode = head;
		while(curNode != null){
			size++;
			curNode = curNode.next;
		}
		int[] arr = new int[size];
		curNode = head;
		for(int i=0; i<size; i++){
			arr[i] = curNode.val;
			curNode = curNode.next;
		}
		return build1(0, size-1, arr);
	}
	public static TreeNode build1(int start, int end, int[] arr){
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = build1(start, mid-1, arr);
		root.right = build1(mid+1, end, arr);
		return root;
	}
	
	/*
	 * ��������ָ��slow��fast��
	 * ����ָ��ͬʱ��ǰ�ߣ�fastָ��ÿ����������
	 * slowָ��ÿ����һ����ֱ��fastָ���ߵ����һ�����ʱ��
	 * ��ʱslowָ����ָ�Ľ������м��㡣
	 */
	//��������ֱ���ҵ��м���
	public static TreeNode sortedListToBST2(ListNode head){
		if(head == null)
			return null;
		return build2(head,null);
	}
	public static TreeNode build2(ListNode head, ListNode end){
		if(head == end)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next!=end && fast.next.next!=end){
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = build2(head, slow);
		root.right = build2(slow.next, end);
		return root;
	}
	//��ӡ����
	public static void printFromHeadToTail(ListNode node){
		while(node != null){
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}	
	public static void main(String[] args) {
		//[-10, -3, 0, 5, 9]
		ListNode node1 = new ListNode(-10);
		ListNode node2 = new ListNode(-3);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(9);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		System.out.println("The List is :");
		printFromHeadToTail(node1);
//		TreeNode root = sortedListToBST1(node1);
		TreeNode root = sortedListToBST2(node1);
		System.out.println("List To BST :\n"+leetcode_102.levelOrder(root));
		
	}

}
