# https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/submissions/
class Solution:
    """
    If n is <=1, then no slices are needed
    If n is even, then full slices are viable, so n/2
    If n is odd, then half slices are needed, so n
    """
    def numberOfCuts(self, n: int) -> int:
        if n == 1 or n == 0: return 0
        return n // 2 if n % 2 == 0 else n
