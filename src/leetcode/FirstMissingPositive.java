public class Solution {
    public int firstMissingPositive(int[] A) {
        /**
         * The idea behind the scene:
         * loop from 0 to n-1, and exchange A[i] and A[A[i]] if possible until A[i] == A[A[i]]
         * final interation and find the first A[i] != i position from i == 1;
         */
        if(A == null || A.length == 0){
            return 1;
        }
        for(int i = 0; i < A.length; i++){
            while(A[i] >= 0 && A[i] < A.length && A[i] != A[A[i]]){
                swap(A, i, A[i]);
            }
        }
        for(int j = 1; j < A.length; j++){
            if(A[j] != j){
                return j;
            }    
        }
        if(A[0] == A.length){
            return A.length + 1;
        }
        return A.length;
    }
    
    private void swap(int[] A, int a, int b){
        A[a] = A[a] + A[b];
        A[b] = A[a] - A[b];
        A[a] = A[a] - A[b];
    }
}