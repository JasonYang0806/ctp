public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null){
            return 0;
        }
        
        int strLength = s.length();
        int len = 0;
        int maxLen = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        while(i < strLength){
            while(i < strLength && !map.containsKey(s.charAt(i))){
                len++;
                map.put(s.charAt(i), i + 1);
                i++;
            }
            maxLen = (len > maxLen) ? len : maxLen;
            if(i == strLength){
                break;
            }else{
                i = map.get(s.charAt(i));
                map.clear();
                len = 0;
            }
        }
        return maxLen;
    }
}