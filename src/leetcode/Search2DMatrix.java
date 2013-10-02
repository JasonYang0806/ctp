public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        int start = 0, end = matrix.length - 1, mid;
        while(start < end){
            mid = (start + end) / 2;
            if(matrix[mid] == null || matrix[mid].length == 0){
                return false;
            }
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(matrix[start] == null || matrix[start].length == 0){
            return false;
        }
        int row = 0;
        if(matrix[start][0] == target){
            return true;
        }else if(matrix[start][0] < target){
            row = start;
        }else{
            if(start <= 0){
                return false;
            }else{
                row = start - 1;
            }
        }
        int _start = 0, _end = matrix[row].length - 1, _mid;
        while(_start <= _end){
            _mid = (_start + _end) / 2;
            if(matrix[row][_mid] == target){
                return true;
            }else if(matrix[row][_mid] < target){
                _start = _mid + 1;
            }else{
                _end = _mid - 1;
            }
        }
        return false;
    }
}