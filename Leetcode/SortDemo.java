package Leetcode;

public class SortDemo {
	/*
	 * ≈≈–ÚÀ„∑® µœ÷
	 */
	//≤Â»Î≈≈–ÚÀ„∑®
	public void insertSort(int[] a){
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
	
	//œ£∂˚≈≈–Ú
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

}
