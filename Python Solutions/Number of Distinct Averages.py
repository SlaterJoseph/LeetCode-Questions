# https://leetcode.com/problems/number-of-distinct-averages/
class Solution:
    """
    Sort nums
    Make a set to track distinct averages
    Pop the front and back off of nums, add the average to the set
    Return the list of the set
    """
    def distinctAverages(self, nums: List[int]) -> int:
        averages = set()

        nums.sort()
        while len(nums) > 0:
            averages.add((nums.pop(0) + nums.pop(len(nums) - 1)) / 2)

        return len(averages)
