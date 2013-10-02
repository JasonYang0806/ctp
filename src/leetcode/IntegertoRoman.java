public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num <= 0) return null;
        
        StringBuilder str = new StringBuilder();
        
        char[] reference = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        // Because the maximum number is 3999.
        int[] digits = {num / 1000, (num % 1000) / 100, (num % 100) / 10, num % 10};
        // 1. thousand: 0 - 3
        for(int i = 1; i <= digits[0]; i++) str.append('M');
        // 2. hundred, ten, unit
        int digit, index = 4;
        for(int i = 1; i <= 3 && index >= 0; i++){
            digit = digits[i];
            if(digit == 4){
                str.append(reference[index]);
                str.append(reference[index + 1]);
            }else if(digit == 9){
                str.append(reference[index]);
                str.append(reference[index + 2]);
            }else{
                if(digit >= 5){
                    str.append(reference[index + 1]);
                    digit -= 5;
                }
                for(int j = 1; j <= digit; j++) str.append(reference[index]);
            }
            index -= 2;
        }
        return str.toString();
    }
}