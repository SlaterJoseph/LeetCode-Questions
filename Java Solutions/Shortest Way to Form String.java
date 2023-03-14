// https://leetcode.com/problems/shortest-way-to-form-string/

class Solution {
    /*
    Make a HashMap of <String, List<Integer>> Where String is the letter and the lsit conatains integers
    If the letter of source is not in the map, return -1
    If it is, save the position. Look for the next letter.
    If the next letter has a index after the previous letters index, save it
    Use binray search to find the closest index that works
    If not and the index is before, restart the iteration of source and increment by 1
    Return the counter
    */
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> charMap = new HashMap<>();

        for(int i = 0; i < source.length(); i++){
            char c = source.charAt(i);

            if(charMap.containsKey(c)) charMap.get(c).add(i); // Add the index to the letter's list
            else { // Add the key and list as a pair; add the index
                charMap.put(c, new ArrayList<>());
                charMap.get(c).add(i);
            }
        }

        int counter = 1;
        int lastIndex = -1;
        for(char c: target.toCharArray()){ // Iterate over the char array
            if(!charMap.containsKey(c)) return -1; // The letter is not in the source string

            List<Integer> indices = charMap.get(c);

            if(lastIndex >= indices.get(indices.size() - 1)){ // The last index of this letter is before the index we are on
                lastIndex = indices.get(0); // Reset
                counter++; // Increment
            } else { // There is a index of our letter after our current letter's index
                int listIndex = binarySearch(indices, lastIndex); 
                lastIndex = indices.get(listIndex);
            }

        }


        return counter;
    }

    public int binarySearch(List<Integer> indices, int num){
        int left = 0;
        int right = indices.size() - 1;
        if(left == right) return 0;

        int mid = (left + right) / 2;

        while(left < right){
            mid = (left + right) / 2;
            int midNum = indices.get(mid);

            if(midNum > num){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if(indices.get(mid) > num) return mid;
        else return mid + 1;
    }
}
