public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null){
            return null;
        }
        return _permute(num, num.length - 1);
    }
    
    private ArrayList<ArrayList<Integer>> _permute(int[] num, int index){
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        if(index == 0){
            ArrayList<Integer> tmpList = new ArrayList<Integer>();
            tmpList.add(num[index]);
            resList.add(tmpList);
            return resList;
        }
        int digit = num[index];
        ArrayList<ArrayList<Integer>> tmpList = _permute(num, index - 1);
        ArrayList<Integer> _list;
        for(ArrayList<Integer> list : tmpList){
            for(int i = list.size(); i >= 0; i--){
                _list = (ArrayList<Integer>)list.clone();
                _list.add(i, digit);
                resList.add(_list);
            }
        }
        return resList;
    }
}