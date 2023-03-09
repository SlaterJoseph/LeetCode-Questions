// https://leetcode.com/problems/find-duplicate-subtrees/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    /*
    Create a HashSet of ArrayLists, where the last val is the root
    Start from the leafs and work backwards
    Add the left-root, right-root, and left-right-root
    Check all 3 against the HashSet
    If duplicate found add to the list
    Otherwise add to the Set
    return list once base root is reached
    */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> dupes = new ArrayList<>();
        Set<ArrayList<Integer>> foundDupes = new HashSet<>();
        Set<ArrayList<Integer>> nodeSet = new HashSet<>();
        helper(root.left, dupes, nodeSet, foundDupes); // Pass the left side
        helper(root.right, dupes, nodeSet, foundDupes); // Pass the right side
        return dupes;
    }

    public ArrayList<Integer> helper(TreeNode root, 
                                     List<TreeNode> dupes,  
                                     Set<ArrayList<Integer>> nodeSet, 
                                     Set<ArrayList<Integer>> foundDupes){

        if(root == null){ // Root is null, return list with -1 to represent null
            ArrayList<Integer> toReturn = new ArrayList<>();
            toReturn.add(-1);
            return toReturn;
        } 
        ArrayList<Integer> left = helper(root.left, dupes, nodeSet, foundDupes);
        ArrayList<Integer> right = helper(root.right, dupes, nodeSet, foundDupes);

        ArrayList<Integer> combo = new ArrayList<>(left);
        combo.addAll(left);
        combo.addAll(right);
        combo.add(root.val);

        if(nodeSet.contains(combo) && !foundDupes.contains(combo)){ 
            dupes.add(root);
            foundDupes.add(combo);
        }
        else nodeSet.add(combo);

        return combo;
    }
}
Console
