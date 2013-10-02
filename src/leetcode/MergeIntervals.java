/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(intervals == null || intervals.size() == 0){
            return new ArrayList<Interval>();
        }
        quickSort(intervals, 0, intervals.size() - 1);
        int index = 1;
        while(index < intervals.size()){
            if(intervals.get(index - 1).end >= intervals.get(index).start){
                intervals.get(index - 1).end = Math.max(intervals.get(index - 1).end, intervals.get(index).end);
                intervals.remove(index);
            }else{
                index++;
            }
        }
        return intervals;
    }
    
    private void quickSort(ArrayList<Interval> intervals, int p, int r){
        if(p < r){
            int q = partition(intervals, p, r);
            quickSort(intervals, p, q - 1);
            quickSort(intervals, q + 1, r);
        }
    }
    
    private int partition(ArrayList<Interval> intervals, int p, int r){
        if(p == r){
            return p;
        }
        int pivot = p;
        int b = p + 1, t = r;
        while(b < t){
            while(b <= t && intervals.get(b).start <= intervals.get(pivot).start){
                b++;
            }
            while(b <= t && intervals.get(t).start > intervals.get(pivot).start){
                t--;
            }
            if(b < t){
                swap(intervals, b, t);
            }
        }
        if(b == t && intervals.get(t).start > intervals.get(pivot).start){
            t--;
        }
        swap(intervals, pivot, t);
        return t;
    }
    
    private void swap(ArrayList<Interval> intervals, int a, int b){
        if(a < intervals.size() && b < intervals.size()){
            Interval tmp = intervals.get(a);
            intervals.set(a,intervals.get(b));
            intervals.set(b,tmp);
        }
    }
}