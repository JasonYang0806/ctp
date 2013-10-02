public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n <= 0 || k <= 0){
            return "";
        }
        
        StringBuilder res = new StringBuilder();
        // Reconstruct k and an arraylist holding elements.
        List<Integer> elements = new ArrayList<Integer>();
        int factorial = 1;
        for(int i = 1; i <= n; i++){
            elements.add(i);
            factorial *= i;
        }
        k--;
        for(int i = 1; i <= n; i++){
            if(factorial > 1){
                factorial /= (n - i + 1);
            }
            int index = k / factorial;
            res.append(elements.remove(index));
            k %= factorial;
        }
        return res.toString();
    }
}