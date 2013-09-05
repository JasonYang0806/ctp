public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null) return 0;
        
        int i = 0, tmpCount;
        Stack<Character> characterStack = new Stack<Character>();
        Stack<Integer> countStack = new Stack<Integer>();
        // First, we push a 0 into countStack as a count for the bottom.
        countStack.push(0);
        
        char ch, chPeek;
        
        while(i < s.length()){
            ch = s.charAt(i);
            
            if(!characterStack.isEmpty()){
                chPeek = characterStack.peek();
                if( chPeek == '(' && ch == ')' ||
                    chPeek == '[' && ch == ']' ||
                    chPeek == '{' && ch == '}')
                {
                    tmpCount = countStack.pop() + 2;
                    countStack.push(tmpCount + countStack.pop());
                    characterStack.pop();
                }else{
                    countStack.push(0);
                    characterStack.push(ch);
                }
            }else{
                characterStack.push(ch);
                countStack.push(0);
            }
            i++;
        }
        
        int max = 0;
        while(!countStack.isEmpty()){
            tmpCount = countStack.pop();
            max = Math.max(tmpCount, max);
        }
        return max;
    }
}