public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length == 0){
            return;
        }
        int index = num.length - 1, pivot = -1;
        // 1. find the first element who violates the increasing trend, and name it pivot.
        while(index > 0){
            if(num[index - 1] < num[index]){
                pivot = index - 1;
                break;
            }
            index--;
        }
        if(index == 0){
            // just got the largest number in num[], reverse it to be the smallest one.
            reverse(num, 0, num.length - 1);
            return;
        }
        // 2. find the first element which is larger that pivot element.
        index = num.length - 1;
        while(index >= 0 && num[index] <= num[pivot]){
            index--;
        }
        swap(num, index, pivot);
        // 3. in the end, reverse all the elements to the right of pivot element.
        reverse(num, pivot + 1, num.length - 1);
    }
    private void reverse(int[] num, int start, int end){
        if(num == null || start >= end || end >= num.length){
            return;
        }
        int left = start, right = end;
        while(left < right){
            swap(num, left++, right--);
        }
    }
    private void swap(int[] num, int a, int b){
        num[a] = num[a] + num[b];
        num[b] = num[a] - num[b];
        num[a] = num[a] - num[b];
    }
}