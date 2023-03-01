// https://leetcode.com/problems/sort-an-array/

class Solution {
    /*
    I chose to implement merge-sort for this problem
    First send the array to the helper method
    If the length is 1, it is 1 number, return
    Otherwise keep splitting the array in halves until the lenght is 1
    When the array is 2, organize the two
    Do this for both halves
    Repeat at 4s and so on until the whole array is sorted
    Return the sorted array
    */
    public int[] sortArray(int[] nums) {
        return merge(nums);  
    }


    public int[] merge(int[] nums){
        if(nums.length == 1) return nums;

        int[] left = merge(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int[] right = merge(Arrays.copyOfRange(nums, (nums.length / 2), nums.length));

        int leftPoint = 0;
        int rightPoint = 0;
        int mergePoint = 0;

        int[] merged = new int[left.length + right.length];

        while(leftPoint < left.length && rightPoint < right.length){
            if(left[leftPoint] < right[rightPoint]) merged[mergePoint++] = left[leftPoint++];
            else merged[mergePoint++] = right[rightPoint++];
        }

        while(leftPoint < left.length) merged[mergePoint++] = left[leftPoint++];
        while(rightPoint < right.length) merged[mergePoint++] = right[rightPoint++];

        return merged;
    }
}
