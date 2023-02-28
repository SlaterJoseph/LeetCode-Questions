class Solution {
    /*
    Create mapping of all chars to ints (as chars)
    Iterate through string 1, creating 1 output for each possibility
    After each letter iterate over the current letterCombinanations
    Add all letterCombinations
    Repeat until digits is interated
    Return list
    */
    public List<String> letterCombinations(String digits) {
        List<String> combos = new ArrayList<>();
        if (digits.length() == 0) return new ArrayList<String>();
        for(char c : digits.toCharArray()) combos = helper(combos, c);
        return combos;
    }

    public List<String> helper(List<String> combos, char digit){
        Map<Character, Character[]> charMap = createMap();
        List<String> newCombos = new ArrayList<>(); // For storing new combos

        if(combos.size() == 0){ // First digit, add all letters
            for(char c: charMap.get(digit)) combos.add("" + c);
            return combos;   
        } else {
            for(String s: combos){ // Iterate over existing strings
                for(char c: charMap.get(digit)){ // Iterate over possible letter combos
                    newCombos.add(s + c); // Add the new combo
                }
            }
            return newCombos;
        }
    }

    public Map<Character, Character[]> createMap(){
        //Creation of the charMap
        Map<Character, Character[]> charMap = new HashMap<>();
        charMap.put('2', new Character[]{'a', 'b', 'c'});
        charMap.put('3', new Character[]{'d', 'e', 'f'});
        charMap.put('4', new Character[]{'g', 'h', 'i'});
        charMap.put('5', new Character[]{'j', 'k', 'l'});
        charMap.put('6', new Character[]{'m', 'n', 'o'});
        charMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        charMap.put('8', new Character[]{'t', 'u', 'v'});
        charMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        return charMap;
    }
}
