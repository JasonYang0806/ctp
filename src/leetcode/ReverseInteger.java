public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean negative = false, overflow = false;
        
        if(x < 0){
            negative = true;
            x = -x;
        }
        
        int res = 0;
        int tmpBit;
        
        while(x != 0){
            tmpBit = x % 10;
            x /= 10;
            // If the input of the function is "int", the second part is unnecessary.
            if((res < (Integer.MAX_VALUE / 10)) || (res == Integer.MAX_VALUE / 10 && tmpBit <= 7)){
                res = 10 * res + tmpBit;
            }else{
                overflow = true;
                break;
            }
        }
        
        if(overflow){
            if(negative){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }else{
            if(negative){
                return -res;
            }else{
                return res;
            }
        }
    }
}