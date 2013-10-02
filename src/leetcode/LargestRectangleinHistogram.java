public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0, index = 0, area;
        while(index < height.length){
            if(stack.empty() || height[index] > height[stack.peek()]){
                stack.push(index);
                index++;
            }else{
                int tmpIndex = stack.pop();
                if(!stack.empty()){
                    area = height[tmpIndex] * (index - stack.peek() - 1);
                }else{
                    // The popped element is the smallest one at this stage.
                    area = height[tmpIndex] * (index - 0 + 1 - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        
        // In the end, we should use a 0 to pop all from stack.
        while(!stack.empty()){
            int tmpIndex = stack.pop();
            if(!stack.empty()){
                area = height[tmpIndex] * (index - stack.peek() - 1);
            }else{
                area = height[tmpIndex] * (index);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}