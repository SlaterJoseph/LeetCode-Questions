// https://leetcode.com/problems/linked-list-cycle-ii/description/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
    Make a HashSet of ListNodes
    Iterate over the linked list
    Add nodes to the HashSet
    If a node is repeated, return it 
    If the linked list ends, return -1
    */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        if(head == null) return null; // Edge case

        while(head.next != null){
            if(nodeSet.contains(head)) return head;
            nodeSet.add(head);
            head = head.next;
        }

        return null;
    }
}
