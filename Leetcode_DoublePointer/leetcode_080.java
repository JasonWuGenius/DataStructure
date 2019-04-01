package Leetcode_DoublePointer;

public class leetcode_080 {
	/* Medium - ��ȷ��
	 * 
	 * ɾ�������������ظ���2
	 * �����26������֮������Ҫ���ڣ�ÿ�������ظ���������Ϊ2�Ρ�
	 * 
	 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�
		��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
		ʾ�� 1:
		���� nums = [1,1,1,2,2,3],
		����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3 ��
		�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
		ʾ�� 2:
		���� nums = [0,0,1,1,1,1,2,3,3],
		����Ӧ�����³��� length = 7, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 0, 0, 1, 1, 2, 3, 3 ��
	 */
	public static int removeDuplicates(int[] nums) {
        if(nums.length < 3 ) return nums.length;
        int j = 0;
        int count = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            if(count < 2){
                nums[j++] = nums[i - 1];
            }
            if(i != nums.length && nums[i - 1] == nums[i]){
                count++;
            }else{
                count = 0;
            }
        }
        return j;
    }
	
	public static int removeDuplicates1(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int i=0;
		int j=0;
		int count=0;
		while(j<nums.length){
			if(nums[i]!=nums[j] && count<3){
				nums[i++] = nums[j];
				count++;
			}
			else{
				count++;
			}
			j++;
		}
		return 0;
			
	}
	public static int removeDuplicates(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int i=0;
		int j=2;
		while(j<nums.length){
			if(nums[j] == nums[j-2]){
				j = i;
			}
			j++;
		}
	}
    public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println("The Length of The Changed List: "+removeDuplicates(nums));
	}
}
