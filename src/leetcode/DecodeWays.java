// This is solved by Dynamic Progeramming (Linear Space Version): 
//                  0                                           if "0****" || "****30****"     
// numDecoding[n] = numDecoding[n - 2] + numDecoding[n - 1]     if "****12****"
//                  numDecoding[n - 2]                          if "****10****"
//                  numDecoding[n - 1]                          if "****76****"
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return 0;
        
        int len = s.length();
        int[] numDecoding = new int[len + 1];
        numDecoding[0] = 1;
        
        for(int i = 1; i <= len; i++){
            if(s.charAt(i - 1) == '0'){
                if(i >= 2 && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')){
                    numDecoding[i] = numDecoding[i - 2];
                }else{
                    return 0;
                }
            }else{
                if(i >= 2 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))){
                    numDecoding[i] = numDecoding[i - 2] + numDecoding[i - 1];
                }else{
                    numDecoding[i] = numDecoding[i - 1];
                }
            }
        }
        return numDecoding[len];
    }
}

// This is sovled by Dynamic Programming (Constant Space Version):
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return 0;
        
        int len = s.length();
        int first = 0, second = 1, cur = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '0'){
                if(i > 0 && (s.charAt(i - 1) == '1' || s.charAt(i-1) == '2')) cur = first;
                else return 0;
            }else{
                if(  i > 0 && 
                    (s.charAt(i - 1) == '1' || 
                    (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) cur = first + second;
                else cur = second;
            }
            first = second;
            second = cur;
        }
        return cur;
    }
}