# https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

class Solution:
    """
    Iterate over the 2d array, appending numbers to a list
    Sort the list
    Return the kth element
    """
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        items = list()
        for row in matrix:
            items += row

        items.sort()
        return items[k - 1]
