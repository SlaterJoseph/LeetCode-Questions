#  https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution:
    """
    Find the length of the needle
    Analyze chunks 1 by 1, checking if they are equal
    If so return the start index
    Otherwise iterate through
    Then return -1
    """
    def strStr(self, haystack: str, needle: str) -> int:
        length = len(needle)

        for x in range(len(haystack)):
            chunk = haystack[x:x + length]
            if chunk == needle:
                return x

        return -1
