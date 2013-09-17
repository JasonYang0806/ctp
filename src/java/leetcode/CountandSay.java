public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n <= 0) return "";
        
        String pre = "1", cur = "";
        for(int i = 2; i <= n; i++){
            int index = 1, count = 1;
            char present = pre.charAt(0), next;
            while(index < pre.length()){
                next = pre.charAt(index);
                if(present == next){
                    count++;
                }else{
                    cur += count;
                    cur += present;
                    present = next;
                    count = 1;
                }
                index++;
            }
            cur += count;
            cur += present;
            pre = cur;
            cur = "";
        }
        return pre;
    }
}