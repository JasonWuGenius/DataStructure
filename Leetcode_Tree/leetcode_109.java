package Leetcode_Tree;


public class leetcode_109 {
	/*
	 *  有序链表转换成二叉搜索树
	 *  
	 *  给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
		本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
		示例:
		给定的有序链表： [-10, -3, 0, 5, 9],
		一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
		      0
		     / \
		   -3   9
		   /   /
		 -10  5
		
		将一个升序链表转化为平衡二叉搜索树。根据平衡二叉搜索树的定义，
		我们可以每次取出数组的中间点作为根节点，然后左边子数组的中间点作为根节点的左子节点，
		右边子数组的中间点作为根节点的右子节点。这里可以用两种方式，一种是遍历链表两次，将链表转化为数组，
		那么就变成和上一题一样了；另一种是用两个指针得到链表的中间点。
	 */
	//方法一：转化未数组
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
	 * 设置两个指针slow和fast，
	 * 两个指针同时向前走，fast指针每次走两步，
	 * slow指针每次走一步，直到fast指针走到最后一个结点时，
	 * 此时slow指针所指的结点就是中间结点。
	 */
	//方法二：直接找到中间结点
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
	//打印链表
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
