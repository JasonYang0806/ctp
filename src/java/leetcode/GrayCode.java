/*
The final rule:
n = k, the result is 1 << k + (reverse order of arraylist of (n == k - 1))
*/
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n < 0){
            return res;
        }
        
        res.add(0);
        for(int i = 0; i < n; i++){
            int highDigit = 1 << i;
            int len = res.size();
            // Reverse order
            for(int j = len - 1; j >= 0; j--){
                res.add(highDigit + res.get(j));
            }
        }
        return res;
    }
}