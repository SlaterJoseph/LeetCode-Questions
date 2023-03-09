// https://leetcode.com/problems/find-the-pivot-integer/description/

class Solution {
    /*
    Make left a sum of all numbers
    Iterate over the numbers before n bakcwards (n, n-1, n-2... 0)
    Increment right by i
    Check if left = right
    If so return the i
    Otherwise decreemnt left by i
    */
    public int pivotInteger(int n) {
        int left = 0;
        for(int i = 0; i <= n; i++) left += i;

        int right = 0;
        for(int i = n; i > 0; i--){
            if(right > left) return -1;

            right += i;
            if(left == right) return i;
            left -= i;
        }

        return -1;
    }
}
