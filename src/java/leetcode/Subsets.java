public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null){
            return res;
        }
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        res.add(tmp);
        if(S.length == 0){
            return res;
        }
        
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> tmpList;
        ArrayList<Integer> _list;
        for(int i = 0; i < S.length; i++){
            tmpList = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> list : res){
                _list = new ArrayList<Integer>(list);
                _list.add(S[i]);
                tmpList.add(_list);
            }
            res.addAll(tmpList);
        }
        return res;
    }
}