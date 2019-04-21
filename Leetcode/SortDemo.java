package Leetcode;

public class SortDemo {
	/*
	 * 插入排序类：直接插入排序、希尔排序
	 * 选择排序类：简单选择排序、堆排序
	 * 交换排序类：冒泡排序、快速排序
	 */
	//插入排序算法
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
	
	//希尔排序
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
	
	//选择排序
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
	
	//堆排序
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
	      * 通常堆是通过一维数组来实现的。在数组起始位置为 0 的情形中：
	      * 父节点 i 的左子节点在位置 (2*i+1);
	      * 父节点 i 的右子节点在位置 (2*i+2);
	      * 子节点 i 的父节点在位置 floor((i-1)/2);
	      */
		while(2*parent+1 <= lastIndex){
			int maxChildIndex = 2*parent+1;
			
			if(maxChildIndex < lastIndex){
				//如果左孩子小于有孩子，取右孩子下标
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
	
	
	//冒泡排序
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
