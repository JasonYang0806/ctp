public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0) return 0;
        int[] num = new int[n + 1];
        for(int i = 0; i <= n; i++) num[i] = -1;
        return _numTrees(n, num);
    }
    
    private int _numTrees(int n, int[] num){
        if(n == 0 || n == 1){
            num[n] = 1;
            return 1;
        }
        if(num[n] != -1) return num[n];
        
        int i = 1, totalNum = 0;
        while(i <= n){
            totalNum += _numTrees(i - 1, num) * _numTrees(n - i, num);
            i++;
        }
        num[n] = totalNum;
        return totalNum;
    }
}