// https://leetcode.com/problems/string-compression/

class Solution {
    /*
    Save the 1st char
    Have a pointer for the array replacement, and one for the location in the array
    While a char is like the last one, increment a counter
    When a new char is found, append the char and the counter
    Return the new length (AKA the array replacement pointer)
    */
    public int compress(char[] chars) {
        int replacement = 0, pointer = 0, counter = 0;
        char c = chars[0];

        while(pointer < chars.length){
            char curr = chars[pointer];
            if(c == curr) counter++; // The same char is found, increment
            else{
                chars[replacement++] = c; 
                if(counter > 1){ // If there is more then 1 we need to count the digit
                    for(char digit : String.valueOf(counter).toCharArray()){ // Iterate over the num
                        chars[replacement++] = digit; 
                    }
                }
                c = curr;
                counter = 1;
            }
            pointer++;
        }

        chars[replacement++] = c; // One last loop to make sure every letter is included
        if(counter > 1){
            for(char digit : String.valueOf(counter).toCharArray()){
                chars[replacement++] = digit;
            }
        }
        return replacement;
    }
}
