package Leetcode_BinarySearch;

public class leetcode_215 {
	/*
	 * �����еĵ�K�����Ԫ��
	 * 
	 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
		ʾ�� 1:
		����: [3,2,1,5,6,4] �� k = 2
		���: 5
		ʾ�� 2:
		����: [3,2,3,1,2,4,5,5,6] �� k = 4
		���: 4
		˵��:
		����Լ��� k ������Ч�ģ��� 1 �� k �� ����ĳ��ȡ�
	 */
	//����һ��
	public static int findKthLargest(int[] nums, int k){
		if(nums.length==1 && k==1){
			return nums[0];
		}
//		int max = Integer.MAX_VALUE;
//		int min = Integer.MIN_VALUE;
		int max = 10;
		int min = 0;
		for(int val: nums){
			max = Math.max(val, max);
			min = Math.min(val, min);
		}
		//�������ѡ�����ֵ����Сֵ���򴴽���acount��̫��
		int[] acount = new int[max-min+1];
		for(int i=0; i<nums.length; i++){
			acount[nums[i]-min]++;
		}
		int m=0;
		for(int i=acount.length-1; i>=0; i--){
			for(int j=0; j<acount[i]; j++){
				nums[m++] = i+min;
			}
		}
		return nums[k-1];
	}
	//������������һ������
	class MaxHeap{
		int[] data;
		int count;
		int capacity;
		
		MaxHeap(int capacity){
			this.capacity = capacity;
			count = 0;
			data = new int[capacity+1];
		}
		
		boolean isEmpty(){
			return count==0;
		}
		
		void insert(int e){
			data[++count] = e;
			shiftUp(count);
		}
		
		int extract(){
			int ret = data[1];
			swap(1,count--);
			shiftDown(1);
			return ret;
		}
		
		private void shiftUp(int k){
			while(k/2 > 0){
				if(data[k] > data[k/2]){
					swap(k, k/2);
					k/=2;
				}
				else{
					break;
				}
			}
		}
		
		private void shiftDown(int k){
			while(k*2<=count){
				int j=k*2;
				if(j+1<=count && data[j+1]>data[j]){
					j++;
				}
				if(data[j]>data[k]){
					swap(k, j);
					k = j;
				}
				else{
					break;
				}
			}
		}
		
		private void swap(int i, int j){
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}
	
	public static int findKthLargest2(int[] nums, int k){
		leetcode_215 l215 = new leetcode_215();
		MaxHeap maxHeap = l215.new MaxHeap(nums.length);
		for(int num:nums){
			maxHeap.insert(num);
		}
		int ret = 0;
		for(int i=0; i<k; i++){
			ret = maxHeap.extract();
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.print("The nums: ");
		for(int item: nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe k: "+k);
		System.out.println("The kth Largest Num: "+findKthLargest2(nums, k));
	}

}
