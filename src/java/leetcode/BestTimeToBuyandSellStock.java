public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        
        int smallest = prices[0], maxP = Integer.MIN_VALUE;
        int tmpProfit;
        for(int i = 1; i < prices.length; i++){
            tmpProfit = prices[i] - smallest;
            maxP = Math.max(maxP, tmpProfit);
            smallest = Math.min(smallest, prices[i]);
        }
        if(maxP >= 0){
            return maxP;
        }else{
            return 0;
        }
    }
}