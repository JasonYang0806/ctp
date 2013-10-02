// I think two pointers will work fine
public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Base cases:
        if(A == null) return 0;
        
        // Real two pointers process:
        int left = 0, right = A.length - 1;
        // Find the correct "right" position.
        while(left <= right && A[right] == elem){
            right--;
        }
        
        while(left <= right){
            if(A[left] == elem){
                // Exchange A[left] and A[right]
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                // left and right move forward and backward, respectively.
                left++;
                right--;
                // Find the correct position for "right"
                while(left <= right && A[right] == elem){
                    right--;
                }
            }else{
                left++;
            }
        }
        
        return Math.max(0, right + 1);
    }
}