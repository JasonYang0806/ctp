// Using stack: running time O(n)
public class Solution{
    public boolean isValid(String s){
        if(s == null || s.length() == 0) return true;

        Stack<Character> stack = new LinkedList<Character>();
        int i = 0;
        char ch, chPeek;

        while(i < s.length()){
            ch = s.charAt(i);
            if(!stack.isEmpty()){
                chPeek = stack.peek();
                if( chPeek == '(' && ch == ')' ||
                    chPeek == '[' && ch == ']' ||
                    chPeek == '{' && ch == '}')
                {
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
            i++;
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}


// Not use stack. Running time O(n^2)
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null) return true;
        int i = 0, left1 = 0, right1 = 0, left2 = 0, right2 = 0, left3 = 0, right3 = 0;
        while(i < s.length()){
            switch(s.charAt(i)){
                case '(':
                    left1++;
                    break;
                case ')':
                    right1++;
                    break;
                case '[': 
                    left2++;
                    break;
                case ']':
                    right2++;
                    break;
                case '{':
                    left3++;
                    break;
                case '}':
                    right3++;
                    break;
            }
            i++;
        }
        if(left1 != right1 ||
           left2 != right2 ||
           left3 != right3){
               return false;
           }
        return _isValid(s);
    }
    
    private boolean _isValid(String s){
        if(s == null || s.length() == 0) return true;
        
        StringBuilder str = new StringBuilder();
        
        int i = 0, j = 1;
        char chI, chJ;
        while(j < s.length()){
            chI = s.charAt(i);
            chJ = s.charAt(j);
            if(chI == '(' && chJ == ')' ||
               chI == '[' && chJ == ']' ||
               chI == '{' && chJ == '}' )
            {
                i += 2;
                j += 2;
                if(i == s.length() - 1) str.append(s.charAt(i));
            }
            else if(chI == '(' && chJ == ']' ||
                    chI == '(' && chJ == '}' ||
                    chI == '[' && chJ == ')' ||
                    chI == '[' && chJ == '}' ||
                    chI == '{' && chJ == ')' ||
                    chI == '{' && chJ == ']')
            {
                return false;
            }
            else
            {
                str.append(chI);
                if(j == s.length() - 1){
                    str.append(chJ);
                }
                i++;
                j++;
            }
        }
        return _isValid(str.toString());
    }
}