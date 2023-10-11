// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

class Solution {
    /*
    Create a map with a String, Set strucutre
    The set is to hold all indices of a given string
    Iterate over the array twice
    First populate the map
    Then check if the target starts with the current string
    If not, continue
    If so, check if the remaining string exists in the map
    If it does, check if it is a repetition of the current chunk
    If so, add the size - 1 (to account for repeating the same index)
    If not, add the size
    Return
    */
    
    public int numOfPairs(String[] nums, String target) {
        int concats = 0;
        Map<String, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], new HashSet<Integer>());
            map.get(nums[i]).add(i);
        }

        for(int i = 0; i < nums.length; i++){
            String curr = nums[i];
            if(curr.length() > target.length()){
                continue;
            }

            if(curr.equals(target.substring(0, curr.length()))){
                String chunk = target.substring(curr.length(), target.length());
                Set<Integer> set = map.get(chunk);

                if(curr.equals(chunk)){
                    concats += set.size() - 1;
                } else if (set != null){
                    concats += set.size();
                }

            }

        }

        return concats;
    }
}
