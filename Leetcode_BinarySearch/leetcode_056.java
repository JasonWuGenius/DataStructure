package Leetcode_BinarySearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_056 {
	/*
	 * 合并区间
	 * 
	 * 给出一个区间的集合，请合并所有重叠的区间。
		示例 1:
		输入: [[1,3],[2,6],[8,10],[15,18]]
		输出: [[1,6],[8,10],[15,18]]
		解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
		示例 2:
		输入: [[1,4],[4,5]]
		输出: [[1,5]]
		解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
	 */
	static class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s, int e){
			start = s;
			end = e;
		}
	}
	
	public static List<Interval> merge(List<Interval> intervals){
		List<Interval> result = new LinkedList<>();
		for(int i=0; i<intervals.size(); i++){
			for(int j=i+1; j<intervals.size(); j++){
				if(intervals.get(i).start > intervals.get(j).start){
					Interval temp = intervals.get(i);
					intervals.set(i, intervals.get(j));
					intervals.set(j, temp);
				}
			}
		}
		int min = intervals.get(0).start;
		int max = intervals.get(0).end;
		for(int i=1; i<intervals.size(); i++){
			if(intervals.get(i).start <= max){
				max = intervals.get(i).end > max? intervals.get(i).end: max;
			}
			else{
				result.add(new Interval(min, max));
				min = intervals.get(i).start;
				max = intervals.get(i).end;
			}
		}
		result.add(new Interval(min, max));
		return result;
	}
	public static void main(String[] args) {
		List<Interval> interval = new LinkedList<>();
		interval.add(new Interval(2,6));
		interval.add(new Interval(8,10));
		interval.add(new Interval(1,3));
		interval.add(new Interval(15,18));
		
		System.out.println("The Origin List: ");
		for(Interval item: interval){
			System.out.print("["+item.start+","+item.end+"] ");
		}
		System.out.println("\nThe Merged List: ");
		for(Interval item: merge(interval)){
			System.out.print("["+item.start+","+item.end+"] ");
		}
	}

}
