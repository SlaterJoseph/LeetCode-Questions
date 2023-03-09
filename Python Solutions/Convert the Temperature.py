# https://leetcode.com/problems/convert-the-temperature/description/
class Solution:
    """
    Just apply simple arithmetic and return the new list
    """
    def convertTemperature(self, celsius: float) -> List[float]:
        return [celsius + 273.15, celsius * 1.80 + 32.00]
