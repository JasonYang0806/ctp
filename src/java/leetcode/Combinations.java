public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n <= 0 || k <= 0) return res;
        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        if(k > n){
            for(int i = 1; i <= n; i++) tmpList.add(i);
            res.add(tmpList);
            return res;
        }
        
        if(k == 1){
            for(int i = 1; i <= n; i++){
                tmpList = new ArrayList<Integer>();
                tmpList.add(i);
                res.add(tmpList);
            }
        }else{
            for(ArrayList<Integer> list : combine(n - 1, k - 1)){
                for(int i = list.get(list.size() - 1) + 1; i <= n; i++){
                    tmpList = new ArrayList<Integer>(list);
                    tmpList.add(i);
                    res.add(tmpList);
                }
            }
        }
        return res;
    }
}