// This is my code: Rrecursive DP, can pass "small test", but not "large test" (Exceed Time Limit)

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1 == null && s2 != null) return s2.equals(s3);
        if(s2 == null && s1 != null) return s1.equals(s3);
        if(s1 == null && s2 == null) return s3 == null ? true : false;
        if(s3 == null) return false;
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
        return _isInterleave(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean _isInterleave(String s1, int index1,
                                  String s2, int index2,
                                  String s3, int index3){
        char ch1 = s1.charAt(index1), ch2 = s2.charAt(index2), ch3 = s3.charAt(index3);
        if(ch1 == ch3 && ch2 != ch3){
            if(index1 == s1.length() - 1) return s2.substring(index2).equals(s3.substring(index3 + 1));
            else return _isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1);
        
        }else if(ch1 != ch3 && ch2 == ch3){
            if(index2 == s2.length() - 1) return s1.substring(index1).equals(s3.substring(index3 + 1));
            else return _isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1);
        }else if(ch1 == ch3 && ch2 == ch3){
            if(index1 == s1.length() - 1){
                return  s2.substring(index2).equals(s3.substring(index3 + 1)) || 
                        _isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1);
                        
            }
            if(index2 == s2.length() - 1){
                return  _isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1) ||
                        s1.substring(index1).equals(s3.substring(index3 + 1));
            }
            return _isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1) ||
                   _isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1);
        }else{
            return false;
        }
    }
}

// Great code by others 
/*
最后还是得用DP。对于
s1 = a1, a2 ........a(i-1), ai
s2 = b1, b2, .......b(j-1), bj
s3 = c1, c3, .......c(i+j-1), c(i+j)

定义 match[i][j] 意味着，S1的(0, i)和S2的(0,j)，匹配与S3的(i+j)
如果 ai == c(i+j), 那么 match[i][j] = match[i-1][j]， 等价于如下字符串是否匹配。

s1 = a1, a2 ........a(i-1)
s2 = b1, b2, .......b(j-1), bj
s3 = c1, c3, .......c(i+j-1)

同理，如果bj = c(i+j), 那么match[i][j] = match[i][j-1];

所以，转移方程如下：
Match[i][j]
    =   (s3.lastChar == s1.lastChar) && Match[i-1][j]
      ||(s3.lastChar == s2.lastChar) && Match[i][j-1]
初始条件：
    i=0 && j=0时，Match[0][0] = true;
    i=0时， s3[j] = s2[j], Match[0][j] |= Match[0][j-1]
           s3[j] != s2[j], Match[0][j] = false;

    j=0时， s3[i] = s1[i], Match[i][0] |= Match[i-1][0]
           s3[i] != s1[i], Match[i][0] = false;

Url: http://fisherlei.blogspot.com/2012/12/leetcode-interleaving-string.html
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1 == null && s2 != null) return s2.equals(s3);
        if(s1 != null && s2 == null) return s1.equals(s3);
        if(s1 == null && s2 == null) return s3 == null ? true : false;
        
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1 + len2 != len3) return false;
        
        boolean[][] M = new boolean[len1 + 1][len2 + 1];
        M[0][0] = true;
        
        for(int i = 1; i <= len1; i++) M[i][0] = M[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        for(int j = 1; j <= len2; j++) M[0][j] = M[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        
        for(int i = 1; i <= len1; i++)
            for(int j = 1; j <= len2; j++)
                M[i][j] = (M[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) ||
                          (M[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
        return M[len1][len2];
    }
}