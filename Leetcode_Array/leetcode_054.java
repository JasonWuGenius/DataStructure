
/*
	��������

	����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�

	ʾ�� 1:

	����:
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	���: [1,2,3,6,9,8,7,4,5]
	ʾ�� 2:

	����:
	[
	  [1, 2, 3, 4],
	  [5, 6, 7, 8],
	  [9,10,11,12]
	]
	���: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList<>();
    	if(matrix.length == 0) return res;
        int m = matrix.length,n = matrix[0].length;
        for(int i = 0; i < (Math.min(m,n)+1)/2; i++) {
            for(int j=i; j<=n-1-i; j++){
                res.add(matrix[i][j]);
            }
            for(int j=i+1; j<m-1-i; j++){
                res.add(matrix[j][n-1-i]);
            }
            if(m-1-i > i){
                for(int j=n-1-i; j>=i; j--){
                    res.add(matrix[m-1-i][j]);
                }
            }
            if(i<n-1-i){
                for(int j=m-1-i-1; j>i; j--){
                    res.add(matrix[j][i]);
                }
            }
        }
        return res;
    }
}
