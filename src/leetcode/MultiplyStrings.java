public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num1 == null || num2 == null || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        int num1Len = num1.length(), num2Len = num2.length();
        int tmpSum;
        int[] carry = new int[num1Len + num2Len];
        int[] res = new int[num1Len + num2Len];
        for(int i = num1Len - 1; i >= 0; i--){
            _clearArray(carry);
            for(int j = num2Len - 1; j >= 0; j--){
                tmpSum = (num1.charAt(i) - '0') *
                         (num2.charAt(j) - '0') + 
                         carry[(num1Len - 1 - i) + (num2Len - 1 - j)];
                carry[(num1Len - 1 - i) + (num2Len - 1 - j) + 1] = tmpSum / 10;         
                res[(num1Len - 1 - i) + (num2Len - 1 - j)] += tmpSum % 10;
            }
            res[(num1Len - 1 - i) + num2Len] += carry[num1Len - 1 - i + num2Len];
        }
        
        StringBuilder result = new StringBuilder();
        int _carry = 0;
        for(int i = 0; i < num1Len + num2Len; i++){
            tmpSum = res[i] + _carry;
            _carry = tmpSum / 10;
            if(i != (num1Len + num2Len - 1) || tmpSum != 0){
                result.insert(0, tmpSum % 10);
            }
            
        }
        return result.toString();
    }
    
    private void _clearArray(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = 0;
        }
    }
}

public class Solution{
    public String multiply(String num1, String num2){
        if(num1 == null || num1.equals("0") || num2 == null || num2.equals("0")) return "0";

        int len1 = num1.length(), len2 = num2.length();
        int[] num = new int[len1 + len2];

        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                num[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        int carry = 0;
        for(int i = len1 + len2 - 1; i >= 0; i--){
            num[i] += carry;
            carry = num[i] / 10;
            num[i] %= 10;
        }

        int start;
        if(num[0] == 0){
            start = 1;
        }else{
            start = 0;
        }

        StringBuilder res = new StringBuilder();
        for(int i = start; i <= len1 + len2 - 1; i++){
            res.append(num[i]);
        }
        return res.toString();
    }
}