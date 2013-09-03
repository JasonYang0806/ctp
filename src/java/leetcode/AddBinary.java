public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        
        int aPtr = a.length() - 1, bPtr = b.length() - 1;
        int carry = 0, tmpSum = 0;
        StringBuilder res = new StringBuilder();
        
        while(aPtr >= 0 || bPtr >= 0 || carry == 1){
            tmpSum = carry;
            if(aPtr >= 0){
                tmpSum += (a.charAt(aPtr) - '0');
            }
            if(bPtr >= 0){
                tmpSum += (b.charAt(bPtr) - '0');
            }
            carry = tmpSum / 2;
            res.insert(0, tmpSum % 2);
            aPtr--;
            bPtr--;
        }
        return res.toString();
    }
}