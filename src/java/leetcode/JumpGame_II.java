// Second Version: running time O(N), space cost O(1)
// Name it as "Two pointer and covered area problem"
public class Solution {
    public int jump(int[] A) {
        // Two pointers, and covered area problem
        if(A == null || A.length == 0 || A.length == 1){
            return 0;
        }
        int start = 0, end = 0, step = 0;
        while(start <= end && end < A.length){
            int max = 0;
            // iterate the covered area by [start, end]
            for(int i = start; i <= end; i++){
                if(A[i] + i >= A.length - 1){
                    return step + 1;
                }else{
                    max = Math.max(max, A[i] + i);
                }
            }
            start = end + 1;
            end = max;
            step++;
        }
        return start <= end ? step : Integer.MAX_VALUE;
    }
}

// First version: Running time O(N^2), space cost O(N)
public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return 0;
        }
        int[] step = new int[A.length];
        step[0] = 1;
        for(int i = 1; i < A.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i - 1; j >= 0; j--){
                if(step[j] > 0 && A[j] >= (i - j)){
                    min = Math.min(min, step[j]);
                }
            }
            step[i] = (min == Integer.MAX_VALUE ? 0 : min + 1);
        }
        return step[A.length - 1] == 0 ? Integer.MAX_VALUE : step[A.length - 1] - 1;
    }
}