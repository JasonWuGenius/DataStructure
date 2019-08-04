package Leetcode_Dynamic;
/*
	����ͼ���-���鲻�ɱ�

	����һ����������  nums�������������� i �� j  (i �� j) ��Χ��Ԫ�ص��ܺͣ����� i,  j ���㡣

	ʾ����

	���� nums = [-2, 0, 3, -5, 2, -1]����ͺ���Ϊ sumRange()

	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
	˵��:

	����Լ������鲻�ɱ䡣
	���ε��� sumRange ������
	����ʵ������������������⣿
*/

class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        if(nums.length == 0){
            return;
        }
        sums[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            sums[i] = sums[i-1]+nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0){
            return sums[j];
        }
        return sums[j] - sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
