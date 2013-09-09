public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(numRows <= 0) return res;
        
        int[] parent = new int[numRows];
        int[] child = new int[numRows];
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        
        tmpList.add(1);
        res.add((ArrayList<Integer>)tmpList.clone());
        tmpList.clear();
        parent[0] = 1;
        
        if(numRows >= 2){
            for(int i = 2; i <= numRows; i++){
                child[0] = 1;
                child[i - 1] = 1;
                for(int j = 1; j < i - 1; j++){
                    child[j] = parent[j - 1] + parent[j];
                }
                for(int k = 0; k < i; k++) tmpList.add(child[k]);
                res.add((ArrayList<Integer>)tmpList.clone());
                tmpList.clear();
                for(int s = 0; s < i; s++) parent[s] = child[s];
            }
        }
        return res;
    }
}