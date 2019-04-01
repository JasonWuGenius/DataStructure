package Leetcode_Heap;

import java.util.Arrays;

public class Heap {
	/*
	 * ��һ������ѣ���ʵ�ֶ�����
	 */
	public static void buildMaxHeap(int[] a){
		for(int i=(a.length/2)-1; i>=0; i--){
			adjustDown(a, i, a.length);
		}
	}
	//���µ���
	public static void adjustDown(int[] a, int i, int len){
		int temp, j;
		temp = a[i];
		for(j=2*i+1; j<len; j=2*j+1){
			if(j+1<len && a[j+1]>a[j])
				j++;
			if(a[j]<=temp)
				break;
			else{
				a[i]=a[j];
				i=j;
			}
		}
		a[i]=temp;
	}
	//������
	public static void heapSort(int[] a){
		buildMaxHeap(a);
		for(int i=a.length-1; i>=0; i--){
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			adjustDown(a, 0, i);//��ʣ��len-1����Ϊ�󶥶ѣ�ѭ����������i��ʾ
		}
	}
	//���ϸ���
	public static void adjustUp(int[] a, int i){
		int temp, j;
		temp = a[i];
		j = (i-1)/2;
		while(j>=0 && a[j]<temp){
			a[i] = a[j];
			i = j;
			j = (j-1)/2;
		}
		a[i] = temp;
	}
	//����
	public static int[] insert(int[] a, int num){
		int[] b = new int[a.length+1];
		int i,j;
		i=0;
		j=0;
		while(i<a.length){
			b[j++] = a[i++];
		}
		b[a.length] = num;
		adjustUp(b, a.length);
		return b;
	}
	//ɾ����ֻ�жѶ���Ԫ�زŻᱻɾ����
	public static int[] delete(int[] a){
		int temp = a[0];
		a[0] = a[a.length-1];
		a[a.length-1] = temp;
		adjustDown(a, 0, a.length-1);
		int[] b = new int[a.length-1];
		int i,j;
		i=j=0;
		while(i<a.length-1){
			b[j++] = a[i++];
		}
		return b;
	}
	public static void main(String[] args) {
        int[] a= {5,88,45,37,91,26,13,66,50};
        buildMaxHeap(a);       //����
        System.out.println(Arrays.toString(a));
        a=insert(a,77);           //����
        System.out.println(Arrays.toString(a));
        a=delete(a);           //ɾ����ֻ��ɾ���Ѷ�Ԫ��
        System.out.println(Arrays.toString(a));
        heapSort(a);          //����
        System.out.println(Arrays.toString(a));
	}

}
