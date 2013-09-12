public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return _minimumTotal(triangle, 0, 0, new HashMap<String, Integer>());
    }
    
    private int _minimumTotal(ArrayList<ArrayList<Integer>> triangle, int level, int index, HashMap<String, Integer> cache){
        if(triangle == null) return 0;
        
        String key = level + "," + index;
        int value;
        if(level == triangle.size() - 1){
            value = triangle.get(level).get(index); 
            cache.put(key, value);
            return value;
        }
        if(cache.containsKey(key)) return cache.get(key);
        
        int left = _minimumTotal(triangle, level + 1, index, cache);
        int right = _minimumTotal(triangle, level + 1, index + 1, cache);
        value = triangle.get(level).get(index) + Math.min(left, right);
        cache.put(key, value);
        return value;
    }
}