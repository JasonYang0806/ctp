public class Solution {
    public String longestPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || s.length() == 0){
            return "";
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int max = 0;
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(i == j){
                    isPalindrome[j][i] = true;
                }else if(i == j + 1){
                    isPalindrome[j][i] = (s.charAt(i) == s.charAt(j));
                }else{
                    isPalindrome[j][i] = (s.charAt(i) == s.charAt(j) && isPalindrome[j + 1][i - 1]);
                }
                if(isPalindrome[j][i] && max < (i - j + 1)){
                    left = j;
                    right = i;
                    max = i - j + 1;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}