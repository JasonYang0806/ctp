public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix == null || matrix.length == 0){
            return;
        }
        
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> column = new ArrayList<Integer>();
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i] == null || matrix[i].length == 0){
                return;
            }else{
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == 0){
                        row.add(i);
                        column.add(j);
                    }
                }
            }
        }
        // row
        for(int index : row){
            for(int i = 0; i < matrix[index].length; i++){
                matrix[index][i] = 0;
            }
        }
        //column
        for(int index : column){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][index] = 0;
            }
        }
    }
}