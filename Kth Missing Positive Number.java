//https://leetcode.com/problems/kth-missing-positive-number/

class Solution {
    /*
    Iterate over the array
    If the number is not up to the counter, increment counter and decrement kth
    Continue until they match
    If k is 0 during the loop return
    If not loop until k = 1
    When k = 1 return counter
    */
    public int findKthPositive(int[] arr, int k) {
        int counter = 1;
        for(int i = 0; i < arr.length; i++){
            if(counter != arr[i]){
                k--;
                i--;
            }
            if(k == 0) return counter;
            counter++;
        }

        while(k-- > 1) counter++;
        return counter;
    }
}
