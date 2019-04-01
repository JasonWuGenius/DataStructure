package Leetcode_BinarySearch;

public class leetcode_074 {
	/*
	 * �ڶ�ά����������n
	 * 
	 * ��дһ����Ч���㷨���ж� m x n �����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�
		ÿ���е����������Ұ��������С�
		ÿ�еĵ�һ����������ǰһ�е����һ��������
		ʾ�� 1:
		����:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 3
		���: true
		
		ʾ�� 2:
		����:
		matrix = [
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		target = 13
		���: false
	 */
	//����һ��
	/*
	 * ���������˿���������ʱ�򣬿϶������뵽��ָoffer��˼·.���ǱȽϾ�������Ͻǵ�����target�Ĵ�С�����target������������Ͻǵ��������ھ�������Ͻ�Ԫ��A��A�����е�����ֵ������target�϶�����A���ڵ����ˣ�������ʱ���Ӧ�þ��ڳ�ȥ��һ�е�ʣ�µ�����ȥ�����target;
		���target�Ⱦ������Ͻǵ���AС����ô����A���ڵ�����A����С�ģ���ôtarget���ڳ�ȥ���ұߵ��е��������У�
		�����ȣ�����true;
	 */
	public static boolean searchMatrix1(int[][] matrix, int target){
		if(matrix.length == 0){
			return false;
		}
		int rowIndex = 0;
		int colIndex = matrix[0].length-1;
		while(rowIndex < matrix.length && colIndex >= 0){
			if(target == matrix[rowIndex][colIndex])
				return true;
			else if(target > matrix[rowIndex][colIndex]){
				rowIndex++;
			}
			else{
				colIndex--;
			}
		}
		return false;
	}
	//�����������ֲ��ҵķ���
	public static boolean searchMatrix2(int[][] matrix, int target){
		if(matrix.length == 0){
			return false;
		}
		int n = matrix[0].length;
		int left = 0;
		int right = matrix.length * matrix[0].length - 1;
		while(left <= right){
			int mid = left + (right - left)/2;
			if(target == matrix[mid/n][mid%n])
				return true;
			else if(target < matrix[mid/n][mid%n])
				right = mid-1;
			else
				left = mid+1;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
		System.out.println("The Matrix:");
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		int target = 3;
//		int target = 13;
		System.out.println("\nThe Target '"+target+"' is in the matrix: "+searchMatrix2(matrix, target));
	}

}
