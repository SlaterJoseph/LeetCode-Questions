# https://leetcode.com/problems/koko-eating-bananas/editorial/

class Solution:
    """
    Binary Search
    1 is the low bounds
    The max value in piles is the high bounds
    Test the middle value over piles
    If it works, then move the right bounds over and save the value
    If the next one works overide the saved value
    If it doesn't, move left bounds over
    Repeat until left and right cross
    Return the found value
    """
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        if h == len(piles):  # Edge Case
            return max(piles)

        left = 1
        right = max(piles)

        while left < right:
            mid = (left + right) // 2
            count = 0

            for pile in piles:
                count += -(pile // -mid)
                

            if count <= h: # Right shift
                right = mid
            else: # Value does work, shift left over
                left = mid + 1


        return right
