public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null){
            return null;
        }
        
        return _permuteUnique(num, num.length - 1);
    }
    
    private ArrayList<ArrayList<Integer>> _permuteUnique(int[] num, int index){
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if(index == 0){
            ArrayList<Integer> _list = new ArrayList<Integer>();
            _list.add(num[index]);
            resList.add(_list);
            return resList;
        }
        
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> _list;
        for(ArrayList<Integer> list : _permuteUnique(num, index - 1)){
            for(int i = list.size(); i >= 0; i--){
                _list = (ArrayList<Integer>)list.clone();
                _list.add(i, num[index]);
                set.add(_list);
            }
        }
        
        for(ArrayList<Integer> list : set){
            resList.add(list);
        }
        
        return resList;
    }
}