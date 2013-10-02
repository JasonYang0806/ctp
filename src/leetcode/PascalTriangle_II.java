public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(rowIndex < 0) return res;
        
        int[] parent = new int[rowIndex + 1];
        int[] child = new int[rowIndex + 1];
        
        child[0] = 1;
        parent[0] = child[0];
        
        if(rowIndex >= 1){
            for(int i = 2; i <= rowIndex + 1; i++){
                child[0] = 1;
                child[i - 1] = 1;
                for(int j = 1; j < i - 1; j++) child[j] = parent[j - 1] + parent[j];
                for(int k = 0; k < i; k++) parent[k] = child[k];
            }
        }
        for(int i = 0; i <= rowIndex; i++) res.add(child[i]);
        return res;
    }
}