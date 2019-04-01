package Leetcode_BinarySearch;

public class leetcode_240 {
	/*
	 * ������ά����
	 * 
	 * Medium
	 * �ڶ�ά����������һ���� ��leetcode_074����
	 * 
	 * ��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target���þ�������������ԣ�
		ÿ�е�Ԫ�ش������������С�
		ÿ�е�Ԫ�ش��ϵ����������С�
		ʾ��:
		���о��� matrix ���£�
		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
		���� target = 5������ true��
		���� target = 20������ false��
		�������Ŀ��ÿ��һ��leetcode-74 �ڶ�ά����������n
		������������ǵ��ⲻͬ�ط���������ǵ���ÿ�еġ���ĩβ�����ֱ�ȻС����һ�еĿ�ͷ�����֣�
		���������Ŀÿ�еġ���ĩβ����������һ�еĿ�ͷ������û�б�Ȼ����ϵ
	 */
	//����һ��
	public static boolean searchMatrix1(int[][] matrix, int target){
		if(matrix.length == 0){
			return false;
		}
		int begin = 0;
		int end = matrix.length-1;
		int midRow = (begin+end)/2;
		while(begin<=end){
			midRow = (begin+end)/2;
			if(matrix[midRow][0] == target)
				return true;
			else if(matrix[midRow][0] > target)
				end = midRow-1;
			else
				begin = midRow+1;
		}
		for(int i=0; i<midRow; i++){
			int left = 0;
			int right = matrix[0].length-1;
			while(left<=right){
				int mid=(left+right)/2;
				if(matrix[i][mid] == target)
					return true;
				else if(matrix[i][mid] > target)
					right = mid-1;
				else
					left = mid+1;
			}
		}
		return false;
	}
	//��������
	public static boolean searchMatrix2(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		int m = 0;
		int n = matrix[0].length-1; 
		while(m<matrix.length && n>=0){
			if(matrix[m][n] == target){
				return true;
			}
			if(matrix[m][n] < target){
				m++;
			}
			else{
				n--;
			}
		}
		return false;
	}
	//����������Ҫ��һ��size()
    public static boolean searchMatrix3(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while(m<matrix.length && n>=0){
            if(matrix[m][n] == target){
                return true;
            }
            if(matrix[m][n] > target){
                n--;
            }
            else{
                m++;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,5,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
		System.out.println("The Matrix:");
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		int target = 5;
//		int target = 20;
		System.out.println("\nThe Target '"+target+"' is in the matrix: "+searchMatrix3(matrix, target));
	}


}
