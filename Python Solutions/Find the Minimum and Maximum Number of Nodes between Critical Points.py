#  https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """
    Saved the heads value and start iteration at the 1st node
    Compare the current value to the last and next value
    If it meets criteria save it to the crit_points list
    While adding elements check if the new added makes a new local min
    When iteration is complete, return the local min found and the distance between the first and last element of crit_points
    """
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        if head.next == None or head.next.next == None:  # Edge case
            return [-1, -1]

        crit_points = list()

        prev_val = head.val
        head = head.next
        count = 1
        minima = 1000000

        while head.next != None:
            next_val = head.next.val

            if (prev_val > head.val and next_val > head.val) or (prev_val < head.val and next_val < head.val): # Crit point found
                crit_points.append(count)

                if len(crit_points) >= 2:  # Testing for new minima
                    minima = min(minima, crit_points[len(crit_points) - 1] - crit_points[len(crit_points) - 2])

            prev_val = head.val
            head = head.next
            count += 1

        return [minima, crit_points[len(crit_points) - 1] - crit_points[0]] if len(crit_points)  > 1 else [-1, -1]
