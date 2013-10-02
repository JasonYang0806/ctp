// Sort + binary search
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3) return res;
        
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 2; i++){
            for(int j = i + 1; j < num.length - 1; j++){
                int rest = 0 - num[i] - num[j];
                int index = binarySearch(num, rest, j + 1, num.length - 1);
                if(index >= 0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[index]);
                    set.add(list);
                }
            }
        }
        for(ArrayList<Integer> _list : set){
            res.add(_list);
        }
        return res;
    }
    
    private int binarySearch(int[] num, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(num[mid] == target){
                return mid;
            }else if(num[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}