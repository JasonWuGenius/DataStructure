package Leetcode_String;

import java.util.ArrayList;
import java.util.List;

public class leetcode_763 {
	/* Midimum
	 * �ַ��� S ��Сд��ĸ��ɡ�����Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�
	 * ͬһ����ĸֻ����������е�һ��Ƭ�Ρ�
	 * ����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
	 * 
	 *  ����: S = "ababcbacadefegdehijhklij"
		���: [9,7,8]
		����:
		���ֽ��Ϊ "ababcbaca", "defegde", "hijhklij"��
		ÿ����ĸ��������һ��Ƭ���С�
		�� "ababcbacadefegde", "hijhklij" �Ļ����Ǵ���ģ���Ϊ���ֵ�Ƭ�������١�

		����˼·����ʾ��һΪ���ӣ� S = "ababcbacadefegdehijhklij"
		����S�ַ��������ȶ���S[0]:a��ʹ��S.lastIndexOf(a)�ҵ�a��S�г��ֵ����һ�ε��±�8��
		��ΪmaxSubIndex���ٴα���i-maxSubIndex��λ�ã�
		��������������ĸ�����һ�γ��ֵ��±����maxSubIndex��
		����еĻ�����maxSubIndex��Ȼ��������������µ�maxSubIndex��
		�ҵ�����maxSubIndex��maxSubIndex-i+1���Ǹöλ�������ĳ��ȡ�
		Ϊ�˱���ÿһ�ζ�Ҫ������Ҫ�ַ������һ�γ��ֵ��±꣬
		����������һ����������int charTable[] = new int[26]��
		�ȱ���һ��S����¼��ÿ����ĸ��lastIndex����ô��ѭ����ֻ��Ҫ�������Ϳ����ˡ�
	 */
	public List<Integer> partitionLabels(String S){
		if(S == null || S.length() == 0){
			return null;
		}
		List<Integer> res = new ArrayList<Integer>();
		int len = S.length();
		int maxSubIndex = 0;
		int i = 0;
		int[] charTable = new int[26];
		for(i=0; i<S.length(); i++){
			charTable[(int)(S.charAt(i)-'a')] = i;
		}
		i = 0;
		while(i<len){
			maxSubIndex = charTable[(int)(S.charAt(i)-'a')];
			for(int j=i+1; j<=maxSubIndex&&j<len; j++){
				if(charTable[S.charAt(j)-'a']>maxSubIndex){
					maxSubIndex = charTable[S.charAt(j)-'a'];
				}
			}
			res.add(maxSubIndex-i+1);
			i = maxSubIndex+1;
		}
		return res;
		
	}
	public static void main(String[] args) {
		leetcode_763 l763 = new leetcode_763();
		String S = "ababcbacadefegdehijhklij";
		System.out.println("The partitioan is: "+l763.partitionLabels(S));
	}

}
