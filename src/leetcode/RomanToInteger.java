public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null) return 0;
        
        // Becasue the maxinum value is 3999 (Roman version: MMMCMXCIX)
        int[] res = new int[4];
        char[] reference = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int index = 0;
        int rIndex = 6;
        // 1. thousand
        while(index < s.length() && s.charAt(index) == reference[rIndex]){
            res[0]++;
            index++;
        }
        rIndex -= 2;
        
        for(int i = 1; i <= 3 && rIndex >= 0 && index < s.length(); i++){
            if(index + 1 < s.length() && s.charAt(index) == reference[rIndex] && s.charAt(index + 1) == reference[rIndex + 1]){
                res[i] = 4;
                index += 2;
            }else if(index + 1 < s.length() && s.charAt(index) == reference[rIndex] && s.charAt(index + 1) == reference[rIndex + 2]){
                res[i] = 9;
                index += 2;
            }else{
                if(s.charAt(index) == reference[rIndex + 1]){
                    res[i] += 5;
                    index++;
                }
                while(index < s.length() && s.charAt(index) == reference[rIndex]){
                    res[i]++;
                    index++;
                }
            }
            rIndex -= 2;
        }
        
        int result = 0;
        for(int j = 0; j <= 3; j++) result = 10 * result + res[j];
        return result;
    }
}