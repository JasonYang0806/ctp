// The laziest way, and of course, the slowest way.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs == null || strs.length == 0) return "";
        
        Arrays.sort(strs);
        
        int index = 0;
        StringBuilder str = new StringBuilder();
        
        while(index < strs[0].length() && 
              strs[0].charAt(index) == strs[strs.length - 1].charAt(index))
        {
            str.append(strs[0].charAt(index));
            index++;
        }
        return str.toString();
    }
}

// Better way, but still can not pass "Large Test", but for loop can pass, not while loop
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs == null || strs.length == 0) return "";

        char standard;
        for(int index = 0; index < strs[0].length(); index++){
            standard = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++){
                if(index >= strs[i].length() || strs[i].charAt(index) != standard){
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0];
    }
}