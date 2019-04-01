package Leetcode_LinkedList;

public class LinkedList {
	//ʵ������Ļ�������
	//�����ͷ�ڵ�
	Node head = null;
	
	/*
	 * ���Ӳ�����ֱ��������������������Ľ��
	 * ��ԭ�����һ�����ָ���½��
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
	 * ������ĳ���
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
	 * ����ɾ����㣬����index������ɾ��
	 */
	public boolean deleteNode(int index){
		if(index<1 || index>length()){//��ɾ����㲻����
			return false;
		}
		if(index == 1){//ɾ��ͷ���
			head = head.next;
			return true;
		}
		Node preNode = head;
		Node curNode = preNode.next;
		int i = 1;
		while(curNode != null){
			if(i==index){//Ѱ�ҵ���ɾ�����
				preNode.next = curNode.next;
				return true;
			}
			//�������ƶ�
			preNode = preNode.next;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
	/*
	 * ���������򣬲�����������ͷ���
	 * ѡ�������㷨����ÿ�ζ�ѡ��δ����������С�Ľ�㣬���һ��δ��������н���
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
	 * ��ӡ���
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
	 * ���ҵ�k��Ԫ��
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
	 * ��ָ��λ�ò����㣬����λ��ֻ��Ҫ֪��һ����㼴�ɣ���ǰλ�õ�ǰһ�����
	 * index:�����λ��
	 * ListNode:����Ľ��
	 */
	public void insertNodeByIndex(int index, Node node){
		if(index<1||index>length()){
		}
	}
	

}
