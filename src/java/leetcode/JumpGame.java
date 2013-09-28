// Second Version: Running Time: O(n), Space cost: O(1)
public class Solution {
    public boolean canJump(int[] A) {
        // You do not need to record all the previous information, just record the previous max just distence
        if(A == null || A.length == 0){
            return true;
        }
        int max = A[0];
        for(int i = 1; i < A.length; i++){
            if(max <= 0){
                return false;
            }else{
                max = Math.max(max - 1, A[i]);
            }
        }
        return true;
    }
}


// First version: running time O(n^2), space cost: O(n)
public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return true;
        }
        boolean[] cache = new boolean[A.length];
        cache[0] = true;
        for(int i = 1; i < A.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(cache[j] && A[j] >= (i - j)){
                    cache[i] = true;
                    break;
                }
            }
        }
        return cache[A.length - 1];
    }
}