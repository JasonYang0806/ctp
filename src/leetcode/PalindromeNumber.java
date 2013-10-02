public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0){
            return false;
        }
        
        // Pay attention to the situation where "div" can be overflow!!!
        // Because it's an integer variable!!!
        int div = 1;
        while(x / div >= 10){
            div *= 10;
        }
        
        int left, right;
        while(x > 0){
            right = x % 10;
            left = x / div;
            if(left != right){
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
    
}