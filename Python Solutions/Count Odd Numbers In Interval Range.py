# Link --> https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

class Solution:
    def countOdds(self, low: int, high: int) -> int:
        # Plan
        # Use arithmetic. Find the difference between the low and high number
        # If the low number is even, it is the difference / 2
        # If the low number is odd, it is the (difference / 2) + 1
        
        base = high - low  # Difference of high and low
        base //= 2  # Floor divide by 2
        return base + 1 if low % 2 == 1 or high % 2 == 1 else base  # Increment if either high or low are odd
