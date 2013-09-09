// Two Pointer
public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack == null || needle == null ) return null;    
        if(haystack.length() == 0 && needle.length() == 0) return "";
        if(haystack.length() == 0) return null;
        if(needle.length() == 0) return haystack;
        
        int haystackLen = haystack.length(), needleLen = needle.length();
        
        int i = 0, j = 0, k = 0;
        while(i < haystackLen && j < needleLen && (haystackLen - k) >= needleLen){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                k++;
                i = k;
                j = 0;
            }
        }
        
        if(j == needleLen){
            return haystack.substring(k);
        }else{
            return null;
        }
    }
}

// KMP

// Rolling Hash