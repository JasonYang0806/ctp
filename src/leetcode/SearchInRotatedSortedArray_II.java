public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null){
            return false;
        }
        return search(A, 0, A.length - 1, target);
    }
    
    private boolean search(int[] A, int start, int end, int target){
        if(start > end){
            return false;
        }
        int mid = (start + end) / 2;
        boolean res = false;
        if(A[mid] == target){
            res = true;
        }else if(A[mid] < target){
            // first, we should find the sorted side.
            if(A[mid] == A[start] || A[mid] == A[end]){
                res = search(A, start, mid - 1, target) || search(A, mid + 1, end, target);
            }else if(A[mid] < A[end]){
                // right is the sorted side.
                if(target <= A[end]){
                    res = search(A, mid + 1, end, target);
                }else{
                    res = search(A, start, mid - 1, target);
                }
            }else if(A[start] < A[mid]){
                // left is the sorted side.
                res = search(A, mid + 1, end, target);
            }
        }else{
            if(A[mid] == A[start] || A[mid] == A[end]){
                res = search(A, start, mid - 1, target) || search(A, mid + 1, end, target);
            }else if(A[start] < A[mid]){
                //left is sorted side.
                if(target >= A[start]){
                    res = search(A, start, mid - 1, target);
                }else{
                    res = search(A, mid + 1, end, target);
                }
            }else if(A[mid] < A[end]){
                // right is the sorted side
                res = search(A, start, mid - 1, target);
            }
        }
        return res;
    }
}