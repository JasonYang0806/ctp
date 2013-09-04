
public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null || str.length() == 0){
            return 0;
        }
        
        boolean negative = false, overflow = false;
        boolean withE = false;
        
        int i = 0, len = str.length(), res = 0, tmp;    
        char ch;
        
        // Get rid of spaces
        while(i < len && str.charAt(i) == ' ') i++;
        
        if(str.charAt(i) == '-'){
            negative = true;
        }
        if(str.charAt(i) == '-' || str.charAt(i) == '+'){
            i++;
        }
        
        while(i < len){
            ch = str.charAt(i);
            if('0' <= ch && ch <= '9'){
                tmp = ch - '0';
                if( res > Integer.MAX_VALUE / 10 || 
                    res == Integer.MAX_VALUE / 10 && (negative && tmp >= 8 || !negative && tmp >=7)
                ){
                    overflow = true;
                    break;
                }else{
                    res = res * 10 + tmp;
                }
                i++;
            }else if(ch == 'e'){
                withE = true;
                i++;
                break;
            }else{
                break;
            }
        }
        
        // Deal with 'e'
        if(withE){
            while(i < len && (str.charAt(i) == ' ' || str.charAt(i) == '+')) i++;
            ch = str.charAt(i);
            if('0' <= ch && ch <= '9'){
                tmp = ch - '0';
                if(res <= Integer.MAX_VALUE / (int)Math.pow(10, tmp)){
                    res = (int)(res * Math.pow(10, tmp));
                }else{
                    overflow = true;
                }
            }
        }
        
        if(overflow){
            if(negative){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }else{
            if(negative){
                return -res;
            }else{
                return res;
            }
        }
    }
}