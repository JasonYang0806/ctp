public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        // Base Cases
        if(s == null || s.length() == 0)
        {
        	return true;
        }

        int i = 0, j = s.length() - 1;

        while(i <= j)
        {
        	// Get rid of all spaces for pointer 'i'.
        	while(i <= j && !_validCharacter(s.charAt(i)))
        	{
        		i++;
        	}

        	// Get rid of all spces for pointer 'j'.
        	while(i <= j && !_validCharacter(s.charAt(j)))
        	{
        		j--;
        	}

        	if((i <= j) && s.charAt(i) != s.charAt(j) && Math.abs(s.charAt(i) - s.charAt(j)) != 32)
        	{
        		return false;
        	}

        	if(i <= j)
        	{
        		i++;
        		j--;
        	}
        }

        return true;
    }

    private boolean _validCharacter(char ch)
    {
    	if(ch >= 65 && ch <= 90)
    	{
    		return true;
    	}

    	if(ch >= 97 && ch <= 122)
    	{
    		return true;
    	}

    	if((ch - '0') >= 0 && (ch - '0') <= 9)
    	{
    		return true;
    	}	
    	return false;
    }
}