public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if( obstacleGrid == null || 
            obstacleGrid.length == 0 || 
            obstacleGrid[0] == null || 
            obstacleGrid[0].length == 0)
        {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] pathNum = new int[m][n];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }else{
            pathNum[0][0] = 1;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 0){
                    if(i > 0){
                        pathNum[i][j] += pathNum[i - 1][j];
                    }
                    if(j > 0){
                        pathNum[i][j] += pathNum[i][j - 1];
                    }
                }
            }
        }
        return pathNum[m-1][n-1];
    }
}