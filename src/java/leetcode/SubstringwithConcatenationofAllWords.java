// This can be run in O(n*m)
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S == null || L == null || S.length() == 0 || L.length == 0) return res;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String l : L){
            if(map.containsKey(l)){
                map.put(l, map.get(l) + 1);
            }else{
                map.put(l, 1);
            }
        }
        
        int strLen = L[0].length();
        int index = 0;
        
        while(index <= S.length() - strLen * L.length){
            String tmpStr = S.substring(index, index + strLen);
            if(map.containsKey(tmpStr)){
                HashMap<String, Integer> tmpMap = (HashMap<String, Integer>)map.clone();
                String _str = tmpStr;
                int _index = index;
                while(!tmpMap.isEmpty() && tmpMap.containsKey(_str)){
                    if(tmpMap.get(_str) == 1){
                        tmpMap.remove(_str);
                    }else{
                        tmpMap.put(_str, tmpMap.get(_str) - 1);
                    }
                    _index += strLen;
                    if(_index <= S.length() - strLen)
                        _str = S.substring(_index, _index + strLen);
                    else 
                        return res;
                }
                if(tmpMap.isEmpty()){
                    res.add(index);
                }
            }
            index++;
        }
        return res;
    }
}



// Run time: O(n + m^3): n: S.length(), m: L.length
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S == null || L == null || S.length() == 0 || L.length == 0) return res;
        
        int strLen = L[0].length();
        int singleCombinationLen = L.length * strLen;
        if(S.length() < singleCombinationLen) return res;
        
        HashSet<String> combinations = combinations(L, strLen, L.length - 1);
        
        int index = 0;
        while(index <= S.length() - singleCombinationLen){
            String tmpStr = S.substring(index, index + singleCombinationLen);
            if(combinations.contains(tmpStr)){
                res.add(index);
            }
            index++;
        }
        return res;
    }
    
    private HashSet<String> combinations(String[] L, int strLen, int index){
        HashSet<String> set = new HashSet<String>();
        if(index == 0){
            set.add(L[0]);
        }else{
            HashSet<String> tmpSet = combinations(L, strLen, index - 1);
            for(String l : tmpSet){
                int numInsertSlot = l.length() / strLen;
                for(int i = 0; i <= numInsertSlot; i++){
                    set.add(l.substring(0, strLen * i) + L[index] + l.substring(strLen * i));
                }
            }
        }
        return set;
    }
}