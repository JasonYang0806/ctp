public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0) return 0;
        
        int cur = 0, fast = 1;
        while(fast < A.length){
            // find the next different element for "fast"
            while(fast < A.length && A[fast] == A[cur]){
                fast++;
            } 
            if(fast >= A.length){
               break;
            }else{
                int runner = cur + 1;
                while(runner < fast){
                    A[runner] = A[fast];
                    runner++;
                }
                cur++;
                fast = cur + 1;
            }
        }
        return cur + 1;
    }
}