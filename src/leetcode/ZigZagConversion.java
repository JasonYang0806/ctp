public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0 || nRows == 1){
            return s;
        }
        if(nRows <= 0){
            return null;
        }
        
        int group = s.length() / (2*nRows-2), left = s.length() % (2*nRows-2);
        StringBuilder res = new StringBuilder();
        // 1. add the first row into the result.
        int index1 = 0, bound1 = group;
        if(left > 0){
            bound1++;
        }
        while(index1 < bound1){
            res.append(s.charAt(index1 * (2*nRows - 2)));
            index1++;
        }

        // 2. add the internal rows (1 -- nRows-2)
        for(int j = 1; j < nRows-1; j++){
            int index2 = 0;
            while(index2 < group){
                res.append(s.charAt(j + index2*(2*nRows-2)));
                res.append(s.charAt((index2+1)*(2*nRows-2) - j));
                index2++;
            }
            if(left > j){
                res.append(s.charAt(j + index2*(2*nRows-2)));
            }
            if(left > 2*nRows-2-j){
                res.append(s.charAt((index2+1)*(2*nRows-2) - j));
            }
        }
        // 3. add the last row
        int index3 = 0, bound3 = group;
        if(left > nRows - 1){
            bound3++;
        }
        while(index3 < bound3){
            res.append(s.charAt(index3 * (2*nRows-2) + nRows - 1));
            index3++;
        }
        return res.toString();
    }
}