package Leetcode_String;

public class leetcode_744 {
	/*
	 * ����һ��ֻ����Сд��ĸ����������letters ��һ��Ŀ����ĸ target��
	 * Ѱ���������������Ŀ����ĸ�����С��ĸ��
	        ��������ĸ��˳����ѭ���ġ�
	        �ٸ����ӣ����Ŀ����ĸtarget = 'z' ������������Ϊ letters = ['a', 'b']����𰸷��� 'a'��
	        
	          ����:
		letters = ["c", "f", "j"]
		target = "a"
		���: "c"
		����:
		letters = ["c", "f", "j"]
		target = "c"
		���: "f"
		
		˵����
		letters���ȷ�Χ��[2, 10000]�����ڡ�
		letters ����Сд��ĸ��ɣ����ٰ���������ͬ����ĸ��
		Ŀ����ĸtarget ��һ��Сд��ĸ��
	 */
	public char nextGreatestLetter(char[] letters, char target){
		int n = letters.length;
		int left = 0;
		int right = n;
		while(left<right){
			int mid = (left+right)/2;
			if(letters[mid]>target){
				right = mid;
			}
			else{
				left = mid+1;//�����1�����ǿ��ǵ���Ҫ�ҵ���ǰ��ĸ�ĺ�һ�������ĸ����������
			}
		}
		return left<n? letters[right]:letters[0];
	}
	public static void main(String[] args) {
		leetcode_744 l744 = new leetcode_744();
		char[] letters = {'c', 'f', 'j'};
		char[] targets = {'a', 'c', 'd', 'g', 'j', 'k'};
		System.out.print("The Letters : ");
		for(char item:letters){
			System.out.print(item+" ");
		}
		System.out.println();
		for(char target:targets){
			System.out.println("The target : "+target+"        ");
			System.out.println("The result : "+l744.nextGreatestLetter(letters, target));
			System.out.println();
		}
	}

}
