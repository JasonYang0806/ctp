public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null){
            return 0;
        }
        if(A.length <= 2){
            return A.length;
        }
        
        int pre = 0, cur = 1, num = 1;
        while(cur < A.length){
            if(A[pre] == A[cur]){
                if(num < 2){
                    num++;
                    A[++pre] = A[cur++];
                }else{
                    cur++;
                }
            }else{
                num = 1;
                A[++pre] = A[cur++];
            }
        }
        return pre + 1;
    }
}