package Leetcode_LinkedList;

public class LinkedList {
	//实现链表的基本操作
	//链表的头节点
	Node head = null;
	
	/*
	 * 增加操作：直接在链表的左后插入新增的结点
	 * 将原来最后一个结点指向新结点
	 */
	public void addNode(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = newNode;
	}
	/*
	 * 求链表的长度
	 */
	public int length(){
		int length = 0;
		Node curNode = head;
		while(curNode != null){
			curNode = curNode.next;
			length++;
		}
		return length;
	}
	/*
	 * 链表删除结点，根据index来进行删除
	 */
	public boolean deleteNode(int index){
		if(index<1 || index>length()){//待删除结点不存在
			return false;
		}
		if(index == 1){//删除头结点
			head = head.next;
			return true;
		}
		Node preNode = head;
		Node curNode = preNode.next;
		int i = 1;
		while(curNode != null){
			if(i==index){//寻找到待删除结点
				preNode.next = curNode.next;
				return true;
			}
			//结点向后移动
			preNode = preNode.next;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
	/*
	 * 链表结点排序，并返回排序后的头结点
	 * 选择排序算法，即每次都选出未排序结点中最小的结点，与第一个未排序结点进行交换
	 */
	public Node linkSort(){
		Node curNode = head;
		while(curNode != null){
			Node nextNode = curNode.next;
			while(nextNode != null){
				if(curNode.data > nextNode.data){
					int temp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
	/*
	 * 打印结点
	 */
	public void printLink(){
		Node curNode = head;
		System.out.println("The LinkedList : ");
		while(curNode != null){
			System.out.print(curNode.data+" ");
			curNode = curNode.next;
		}
		System.out.println();
	}
	/*
	 * 查找第k个元素
	 */
	public Node findNode(int k){
		if(k<1 || k>length()){
			return null;
		}
		Node temp = head;
		for(int i=0; i<k-1; i++){
			temp = temp.next;
		}
		return temp;
	}
	/*
	 * 在指定位置插入结点，插入位置只需要知道一个结点即可，当前位置的前一个结点
	 * index:插入的位置
	 * ListNode:插入的结点
	 */
	public void insertNodeByIndex(int index, Node node){
		if(index<1||index>length()){
		}
	}
	

}
