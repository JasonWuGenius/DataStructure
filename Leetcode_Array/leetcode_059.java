
/*
	ת�þ���

	����һ������ A�� ���� A ��ת�þ���

	�����ת����ָ����������Խ��߷�ת���������������������������

	 

	ʾ�� 1��

	���룺[[1,2,3],[4,5,6],[7,8,9]]
	�����[[1,4,7],[2,5,8],[3,6,9]]
	ʾ�� 2��

	���룺[[1,2,3],[4,5,6]]
	�����[[1,4],[2,5],[3,6]]
	 

	��ʾ��

	1 <= A.length <= 1000
	1 <= A[0].length <= 1000
*/

class Solution {
    public int[][] transpose(int[][] A) {
        int leni = A.length, lenj = A[0].length;
        int[][] res = new int[lenj][leni];
        for(int i=0; i<leni; i++){
            for(int j=0; j<lenj; j++){
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
