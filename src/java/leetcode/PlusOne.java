public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(digits == null){
            return null;
        }
        
        int carry = 1, tmpSum;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int len = digits.length, i = len - 1;
        while(i >= 0 || carry == 1){
            tmpSum = carry;
            if(i >= 0){
                tmpSum += digits[i];
            }
            carry = tmpSum / 10;
            res.add(0, tmpSum % 10);
            i--;
        }
        int[] result = new int[res.size()];
        for(int j = 0; j < result.length; j++){
            result[j] = res.get(j);
        }
        return result;
    }
}