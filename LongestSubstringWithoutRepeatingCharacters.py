class Solution:
    """
    Using a sliding window approach
    Iterate over letters, adding them to a list
    Stretch the back of the window
    Once a repeat is found, move the front until the repeat is lost
    Continue until the back reaches the end of the substring
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0: return 0 # Edge case

        substring, front, back, curr_let = 0, 0, 0, set()

        while back < len(s):
            substring = max(substring, back - front)  # Checking if the new window length is greater

            while s[back] in curr_let:  # Shrink the window from the front
                if s[front] == s[back]:  # We reached the repeat
                    front += 1
                    break

                curr_let.remove(s[front])  # The letter is no longer in the substring
                front += 1

            curr_let.add(s[back])  # Add the new character
            back += 1

       
        return max(substring, back - front)  # In case the final distance is the greatest
