package Leetcode_Array;

public class leetcode_665 {
	/**
	 * �ǵݼ�����
	 * ����һ������Ϊ n ���������飬����������ж������ı� 1 ��Ԫ�ص�����£��������ܷ���һ���ǵݼ����С�
	 * ����: [4,2,3]
	 * ���: True
	 * ����: �����ͨ���ѵ�һ��4���1��ʹ������Ϊһ���ǵݼ����С�
	 */
    public boolean checkPossibility(int[] nums) {
        int i = 0,j = nums.length - 1;
        while(i < j && nums[i] <= nums[i + 1])
            i++;
        while(i < j && nums[j] >= nums[j - 1])
            j--;
        System.out.println(i + "----" + j);
        int head = 0;
        if(i == 0)
            head = Integer.MIN_VALUE;
        else
            head = nums[i - 1];
        int next = (j==nums.length - 1)?Integer.MAX_VALUE:nums[j + 1];
        if(j - i <= 1 && (head <= nums[j] || nums[i] <= next))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
		leetcode_665 l665 = new leetcode_665();
		int[] nums = {1, 2, 9, 8, 5, 6, 7};
		System.out.println("The result is :"+l665.checkPossibility(nums));
	}


}
