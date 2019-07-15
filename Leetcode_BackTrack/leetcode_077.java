package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * ���
 * 
	������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�

	ʾ��:

	����:?n = 4, k = 2
	���:
	[
	[2,4],
	[3,4],
	[2,3],
	[1,2],
	[1,3],
	[1,4],
	]
 */
public class leetcode_077 {
	static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
		List<Integer> list = new ArrayList<>();
		combineSub(n, k, list, 0, 1);
		return res;
	}
	public static void combineSub(int n, int k, List<Integer> list, int index, int curIndex){
		if(index == k){
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=curIndex; i<=n; i++){
			list.add(i);
			combineSub(n, k, list, index+1, i+1);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println("The n: "+n+"  The k: "+k);
		System.out.println("The subsets: "+combine(n ,k));
	}

}


















