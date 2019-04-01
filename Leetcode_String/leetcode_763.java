package Leetcode_String;

import java.util.ArrayList;
import java.util.List;

public class leetcode_763 {
	/* Midimum
	 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
	 * 同一个字母只会出现在其中的一个片段。
	 * 返回一个表示每个字符串片段的长度的列表。
	 * 
	 *  输入: S = "ababcbacadefegdehijhklij"
		输出: [9,7,8]
		解释:
		划分结果为 "ababcbaca", "defegde", "hijhklij"。
		每个字母最多出现在一个片段中。
		像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

		解题思路：以示例一为例子， S = "ababcbacadefegdehijhklij"
		遍历S字符串，首先对于S[0]:a，使用S.lastIndexOf(a)找到a在S中出现的最后一次的下标8，
		记为maxSubIndex，再次遍历i-maxSubIndex的位置，
		查找其中其它字母的最后一次出现的下标大于maxSubIndex，
		如果有的话更新maxSubIndex，然后继续遍历到最新的maxSubIndex，
		找到最大的maxSubIndex后，maxSubIndex-i+1就是该段划分区间的长度。
		为了避免每一次都要查找想要字符的最后一次出现的下标，
		所以先设置一个辅助数组int charTable[] = new int[26]。
		先遍历一次S，记录下每个字母的lastIndex。那么在循环中只需要查这个表就可以了。
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
