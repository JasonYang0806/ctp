public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n < 0) return;
        if(m < 0){
            A = B;
            return;
        }
        int i = m - 1, j = n - 1, k = A.length - 1;
        int a, b;
        while(i >= 0 || j >= 0){
            if(i >= 0){
                a = A[i];
            }else{
                a = Integer.MIN_VALUE;
            }
            
            if(j >= 0){
                b = B[j];
            }else{
                b = Integer.MIN_VALUE;
            }
            if(a > b){
                A[k] = a;
                i--;
            }else{
                A[k] = b;
                j--;
            }
            k--;
        }
    }
}