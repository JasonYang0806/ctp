public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null) return true;
        
        int index = 0, len = s.length();
        // Get rid of spaces
        while(index < len && s.charAt(index) == ' '){
            index++;
        }
        if(index >= len){
            return false;
        }
        // get rid of the tail spaces
        int postIndex = len - 1;
        while(postIndex >= 0 && s.charAt(postIndex) == ' '){
            postIndex--;
            len--;
        }
        if(s.charAt(index) == '+' || s.charAt(index) == '-'){
            index++;
        }
        boolean hasDigit =false;
        boolean hasDot = false;
        boolean eHasDigit = false;
        while(index < len){
            if(!validChar(s.charAt(index))){
                return false;
            }else{
                if('0' <= s.charAt(index) && s.charAt(index) <= '9'){
                    hasDigit = true;
                }else if(s.charAt(index) == '.'){
                    if(hasDot){
                        return false;
                    }else{
                        hasDot = true;
                    }
                }else if(s.charAt(index) == 'e'){
                    if(!hasDigit){
                        return false;
                    }
                    if(index + 1 < len && (s.charAt(index + 1) == '-' || s.charAt(index + 1) == '+')){
                        index++;
                    }
                    index++;
                    while(index < len && ('0' <= s.charAt(index) && s.charAt(index) <= '9')){
                        eHasDigit = true;
                        index++;
                    }
                    if(index >= len && eHasDigit){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
            index++;
        }
        if(!hasDigit){
            return false;
        }else{
            return true;
        }
    }
    
    private boolean validChar(char ch){
        if('0' <= ch && ch <= '9'){
            return true;
        }else if(ch == '.'){
            return true;
        }else if(ch == 'e'){
            return true;
        }else{
            return false;
        }
    }
}