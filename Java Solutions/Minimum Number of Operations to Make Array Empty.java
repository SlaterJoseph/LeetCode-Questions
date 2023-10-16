// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/

class Solution {
    /*
    We make a map of integer, count
    Iterate over the array populating the map
    Have a variable for count
    If the count is 1, return -1
    Otherwise, add count / 3, and if it there is a decimal add 1
    So if the count is 19, divide by 3 = 6.33
    Subtract 4 = 15 / 3 = 5, so 7 total moves
    return total moves

    Populating map O(n) where n is the length of the array
    Finding the total count is O(m) where m is the number of unique numbers
    Total runntime is O(n + m)
    */

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int count = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int base = entry.getValue();

            if(base == 1){
                return -1;
            }

            count += (base / 3) + (base % 3 != 0 ? 1 : 0);            
        }

        return count;
    }
}
