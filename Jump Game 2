//Link - https://leetcode.com/problems/jump-game-ii/

class Solution {
    public int jump(int[] nums) {

        if(nums.length == 1) return 0; //If length is 1 no jumps eneded.
        int minJumps = 0;

        /**
        Plan
        Start at index 0
        Check the spaces included in the range of the index (3rd index value of 4 is better then 1st index value of 5)
        Find the best location to stored value ratio
        Move to that index
        Continue until the end is reached 
        */

        for(int i = 0; i < nums.length; i++){
            int x = 1;
            int index = 0;
            int maxStep = 0;

            if(i + nums[i] >= nums.length - 1){ //If our index + range surpass our n - 1, increment for jump and end
                minJumps++;
                break;
            }

            while(x <= nums[i]){
                if(maxStep + index < nums[i + x] + i + x){ // Checks which ratio better
                     // If new is better update the values
                    index = i + x; 
                    maxStep = nums[i + x];
                }  
                x++;             
            }
            i = index - 1;
            minJumps++;
        }

        return minJumps;
    }
}
