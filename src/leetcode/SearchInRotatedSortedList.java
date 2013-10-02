public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null){
            return -1;
        }else{
            return search(A, 0, A.length - 1, target);
        }
    }
    
    private int search(int[] A, int start, int end, int target){
        if(start <= end){
            int mid = (start + end) / 2, index = -1;
            if(A[mid] == target){
                index = mid;
            }else if(A[mid] < target){
                // First, I should find the sorted side and we have only exactly one sorted side.
                if(A[mid] <= A[end]){
                    // The reason for the '<=' is sometimes, mid == end or mid == start
                    // right is the sorted side.
                    if(target <= A[end]){
                        index = search(A, mid + 1, end, target);
                    }else{
                        index = search(A, start, mid - 1, target);
                    }
                }else if(A[mid] >= A[end]){
                    // left is the sorted side.
                    index = search(A, mid + 1, end, target);
                }
            }else if(A[mid] > target){
                // Find the exact one sorted side.
                if(A[mid] >= A[start]){
                    // left is the sorted side.
                    if(target >= A[start]){
                        index = search(A, start, mid - 1, target);
                    }else{
                        index = search(A, mid + 1, end, target);
                    }
                }else if(A[mid] <= A[end]){
                    // right is the sorted side.
                    index = search(A, start, mid - 1, target);
                }
            }
            return index;
        }else{
            return -1;
        }
    }
}