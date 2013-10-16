public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        return combinationSum(candidates, 0, candidates.length - 1, target);
    }
    
    private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int start, int end, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(start > end || target < candidates[start]){
            return res;
        }
        
        int num = target / candidates[start];
        for(int i = 0; i <= num; i++){
            int leftTarget = target - i * candidates[start];
            if(leftTarget == 0){
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                for(int j = 1; j <= i; j++){
                    tmpList.add(candidates[start]);
                }
                res.add(tmpList);
                break;
            }else{
                ArrayList<ArrayList<Integer>> subResult = 
                    combinationSum(candidates, start + 1, end, leftTarget);
                for(ArrayList<Integer> list : subResult){
                    for(int j = 1; j <= i; j++){
                        list.add(0, candidates[start]);
                    }
                }
                res.addAll(subResult);
            }
        }
        return res;
    }
}