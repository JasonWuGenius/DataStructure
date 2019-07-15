package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * ��k������
 *
 * ��������?[1,2,3,��,n]��������Ԫ�ع���?n! �����С�

	����С˳���г����������������һһ��ǣ���?n = 3 ʱ, �����������£�

	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	����?n ��?k�����ص�?k?�����С�

	˵����

	���� n?�ķ�Χ�� [1, 9]��
	���� k?�ķ�Χ��[1, ?n!]��
	ʾ��?1:

	����: n = 3, k = 3
	���: "213"
	ʾ��?2:

	����: n = 4, k = 9
	���: "2314"

 */
public class leetcode_060 {
	static List<List<Integer>> res = new ArrayList<>();
	static boolean[] used;
    public static String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		used = new boolean[n+1];
		getPermutationSub(n, k, list, 0);
		String s = "";
		for(int item: res.get(res.size()-1)){
			s+=String.valueOf(item);
		}
		return s;
	}
	public static void getPermutationSub(int n, int k, List<Integer> list, int index){
		if(index == n){
			res.add(new ArrayList<>(list));
			return;
		}
		if(k == res.size()){
			return;
		}
		for(int i=1; i<=n; i++){
			if(!used[i]){
				list.add(i);
				used[i] = true;
				getPermutationSub(n, k, list, index+1);
				list.remove(list.size()-1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 9;
		System.out.println("The n: "+n+"  The k: "+k);
		System.out.println("The subsets: "+getPermutation(n ,k));
	}

}


















