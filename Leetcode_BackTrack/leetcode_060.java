package Leetcode_BackTrack;

import java.util.ArrayList;
import java.util.List;

/*
 * 第k个排列
 *
 * 给出集合?[1,2,3,…,n]，其所有元素共有?n! 种排列。

	按大小顺序列出所有排列情况，并一一标记，当?n = 3 时, 所有排列如下：

	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	给定?n 和?k，返回第?k?个排列。

	说明：

	给定 n?的范围是 [1, 9]。
	给定 k?的范围是[1, ?n!]。
	示例?1:

	输入: n = 3, k = 3
	输出: "213"
	示例?2:

	输入: n = 4, k = 9
	输出: "2314"

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


















