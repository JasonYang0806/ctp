public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null){
            return -1;
        }
        if(A.length == 0){
            return 0;
        }
        
        int start = 0, end = A.length - 1, mid;
        while(start < end){
            mid = (start + end) / 2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        if(A[start] == target){
            return start;
        }else if(A[start] > target){
            return start;
        }else{
            return start + 1;
        }
    }
}