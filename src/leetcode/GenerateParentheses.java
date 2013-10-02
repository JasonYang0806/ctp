public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n <= 0) return null;
        ArrayList<String> res = new ArrayList<String>();
        char[] parenthesis = new char[2 * n];
        _generateParenthesis(res, parenthesis, n, n, 0);
        return res;
    }
    
    private void _generateParenthesis(ArrayList<String> parenthesisList, char[] parenthesis, 
                                        int left, int right, int count){
        if(left == 0 && right == 0) parenthesisList.add(String.valueOf(parenthesis));
        
        if(left > 0){
            parenthesis[count] = '(';
            _generateParenthesis(parenthesisList, parenthesis, left - 1, right, count + 1);
        }
        
        if(left < right){
            parenthesis[count] = ')';
            _generateParenthesis(parenthesisList, parenthesis, left, right - 1, count + 1);
        }
    }
}