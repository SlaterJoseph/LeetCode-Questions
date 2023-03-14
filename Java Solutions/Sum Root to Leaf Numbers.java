//  https://leetcode.com/problems/sum-root-to-leaf-numbers/

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
    Use DFS to make a list of all possible numbers
    Start at the root as the base string
    Append every number as they are found, passing the previous string as the value
    When a leaf is reached, return the number with a colon between the number from the other root
    If only one path has a number, check for it and lead to a different return statement
    Once all the numbers are together, split them and parse them 1 by 1, adding them together
    */
    public int sumNumbers(TreeNode root) {
        String nums = helper(root, "");

        int total = 0;
        for(String s : nums.split(":")) total += Integer.parseInt(s); // Adding the values found
        return total;
    }

    public String helper(TreeNode root, String base){
        if(root == null) return base ; // Return the previous value
        

        String newBase = base;
        newBase += String.valueOf(root.val); // Append the new value

        String left = helper(root.left, newBase);
        String right = helper(root.right, newBase);

        if(left == newBase){ // The left side ends
            return right;
        } else if (right == newBase){ // The right side ends
            return left;
        } else { // Both sides continue
            return left + ":" + right;
        }
    }
}
