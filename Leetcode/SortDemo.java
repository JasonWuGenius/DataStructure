package Leetcode;

public class SortDemo {
	/*
	 * ���������ֱࣺ�Ӳ�������ϣ������
	 * ѡ�������ࣺ��ѡ�����򡢶�����
	 * ���������ࣺð�����򡢿�������
	 */
	//���������㷨
	public void insertSort1(int[] a){
		int len = a.length;
		int insertNum;
		for(int i=1; i<len; i++){
			insertNum = a[i];
			int j=i-1;
			while(j>=0 && a[j]>insertNum){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = insertNum;
		}
	}
	public void insertSort2(int[] a){
		int len = a.length;
		int i, j;
		for(i=1; i<len; i++){
			int temp = a[i];
			for(j=i; j>0 && a[j-1]>temp; j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
		}
	}
	
	//ϣ������
	public void sheelSort(int[] a){
		int len = a.length;
		while(len != 0){
			len = len/2;
			for(int i=0; i<len; i++){
				for(int j=i+len; j<a.length; j+=len){
					int k=j-len;
					int temp = a[j];
					while(k>=0 && temp<a[k]){
						a[k+len] = a[k];
						k -= len;
					}
					a[k+len] = temp;
				}
			}
		}
	}
	
	//ѡ������
	public void selectSort(int[] a){
		int len = a.length;
		for(int i=0; i<len; i++){
			for(int j=i+1; j<len; j++){
				if(a[j] > a[i]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	//������
	public static void heapSort(int[] a){
		buildMaxHeap(a, a.length-1);
		swap(a, 0, a.length-1);
		for(int i=1; i<a.length-1; i++){
			adjustMaxHeap(a, 0, a.length-1-i);
			swap(a, 0, a.length-1-i);
		}
	}
	public static void buildMaxHeap(int[] data, int lastIndex){
		for(int i=(lastIndex-1)/2; i>=0; i--){
			adjustMaxHeap(data, i, lastIndex);
		}
	}
	public static void adjustMaxHeap(int[] data, int parent, int lastIndex){
	     /*
	      * ͨ������ͨ��һά������ʵ�ֵġ���������ʼλ��Ϊ 0 �������У�
	      * ���ڵ� i �����ӽڵ���λ�� (2*i+1);
	      * ���ڵ� i �����ӽڵ���λ�� (2*i+2);
	      * �ӽڵ� i �ĸ��ڵ���λ�� floor((i-1)/2);
	      */
		while(2*parent+1 <= lastIndex){
			int maxChildIndex = 2*parent+1;
			
			if(maxChildIndex < lastIndex){
				//�������С���к��ӣ�ȡ�Һ����±�
				if(data[maxChildIndex] < data[maxChildIndex+1]){
					maxChildIndex++;
				}
			}
			
			if(data[parent] < data[maxChildIndex]){
				swap(data, parent, maxChildIndex);
				parent = maxChildIndex;
			}
			else{
				break;
			}
		}
	}
	public static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	
	//ð������
	public void bubbleSort(int[] a){
		int j = a.length-1;
		while(j>=1){
			for(int i=0; i<j; i++){
				if(a[i] > a[i+1]){
					int temp = a[i];
					a[i] =a[i+1];
					a[i+1] = temp;
				}
			}
			j--;
		}
	}

}
