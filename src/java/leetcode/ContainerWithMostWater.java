public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null) return 0;
        
        int left = 0, right = height.length - 1;
        int max = 0, area;
        
        while(left < right){
            area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}