public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A == null || A.length == 0){
            return 0;
        }
        long sum = 0;
        for(int a : A){
            sum ^= a;
        }
        return (int)sum;
    }
}