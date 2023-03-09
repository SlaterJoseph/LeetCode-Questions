# https://leetcode.com/problems/count-and-say/

class Solution:
    """
    Start at the base case (1)
    Iterate until n
    Every time go over the number, counting the sequences
    Store strings as count then number counted
    Once n is reached, return the stored numebr
    """
    def countAndSay(self, n: int) -> str:
        x, count = 1, '1'

        while x < n:
            new_count = ''
            curr_digit, curr_count = count[0], 0

            for c in count: # Iterate over the current sequence
                if c == curr_digit: # Our char is the same
                    curr_count += 1
                else:  # New number found
                    new_count += str(curr_count) + str(curr_digit) # Add the last sequence, reset the variables accordinly
                    curr_digit = c
                    curr_count = 1
            
            new_count += str(curr_count) + str(curr_digit)  # Add the last sequence
            x += 1
            count = new_count


        return count
