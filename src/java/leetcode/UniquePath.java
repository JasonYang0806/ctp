public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m <= 0 || n <= 0){
            return 0;
        }
        int[][] pathNum = new int[m+1][n+1];
        pathNum[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <=n; j++){
                if(i > 1){
                    pathNum[i][j] += pathNum[i-1][j];
                }
                if(j > 1){
                    pathNum[i][j] += pathNum[i][j-1];
                }
            }
        }
        return pathNum[m][n];
    }
}