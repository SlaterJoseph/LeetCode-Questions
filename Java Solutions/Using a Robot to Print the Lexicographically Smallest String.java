// https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/

class Solution {
    /*
    Lexographically, we only really care about the lowest point, then the lowest point from then on.
    So in a string like "kvvasxb", we care about the a, then the b and so on. After that we just send the letters out
    We use a stack to store all the letters in the way to our lowest letter.
    But how do we know the lowest letters
    We make a map of letters to a list of indices
    We run over all the letters and find the order of least until the end is reached
    For example, in kvvasxb we would have a map of
    k, [0] : v, [1, 2]: a, [3], s, [4]: x, [5]: b[6]
    we find the first index of the lowest letter (a = 3)
    Iterate to it in our string, pushing the passed letters to the stack
    At this time also removing the indices from the list, and if the list is empty removing the entry to improve runntime
    If there are no more As, follow to b and so forth until the end of the string or z is reached
    After pop all remaining values from the stack to the string
    Return the finalized string
    */

    public String robotWithString(String s) {
        Stack<Character> storage = new Stack<>();
        Map<Character, LinkedList<Integer>> indices = new HashMap<>();
        StringBuilder lexo = new StringBuilder();
        int size = s.length();

        System.out.println(s);

        // Populating our map
        for(int i = 0; i < size; i++){   //O(n)
            char c = s.charAt(i);
            indices.putIfAbsent(c, new LinkedList<Integer>());
            indices.get(c).add(i);
        }

        int i = 0;
        char counter = 'a';

        while(counter <= 'z' && i < size){ // O(n + 25) = O(n)
        
            while(!storage.isEmpty() && storage.peek() <= counter){
                lexo.append(storage.pop());
            }

            if(indices.containsKey(counter)){
                LinkedList<Integer> loc = indices.get(counter);


                while(loc.size() > 0){ // Get all of the indices of the current lowest letter
                    int currLoc = loc.removeFirst();

                    while(i < currLoc){ // While I has not caught up to the current index
                        char pass = s.charAt(i);
                        storage.push(pass); // Push the letter to storage
                        indices.get(pass).removeFirst(); // The first indices corresponds to the first appearence and so on
                        if(indices.get(pass).size() <= 0){ // Remove the entry of the map if it now empty
                            indices.remove(pass);
                        }
                        
                        i += 1;
                    }

                    lexo.append(counter);
                    i += 1;
                }
                indices.remove(counter);
            } else {
                counter = (char) (counter + 1);
            }
        }


        while(!storage.isEmpty()){  // O(n)
            lexo.append(storage.pop());
        }

        return lexo.toString();
    }
}
