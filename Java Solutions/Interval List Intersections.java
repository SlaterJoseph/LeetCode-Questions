//https://leetcode.com/problems/interval-list-intersections/

class Solution {
    /*
    First declare an array list of arrays which will be converted into a 2d array (to return)
    Plan
    Have a pointer for each array
    Check the 1st index's first index -- save the higher number
    Then check the 1st index's 2nd index -- save the lower number
    Add the combination of higher 1st to lower 2nd
    Move the lower 2nd over to the 2nd index ect.
    In the event they both end at the same index, shift both over by one
    Once one of the 2 reaches the end we are done, as the 2nd can't match a finished first    

    Edges cases
    Either or both are null, return an empty array;

    */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0){
            return new int[0][0];
        }

        List<int[]> intervals = new ArrayList<>();

        int i = 0, j = 0; // i - first list : j - second list

        while(i < firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if(start <= end){ // We found a valid interval
                intervals.add(new int[]{start, end});
            }

            if(end == firstList[i][1]){
                i += 1;
            }

            if(end == secondList[j][1]){
                j += 1;
            }
        }


        return convert(intervals);
    }

    private int[][] convert(List<int[]> list){
        int[][] arr = new int[list.size()][2];

        for(int i = 0; i < arr.length; i++){
            arr[i][0] = list.get(i)[0];
            arr[i][1] = list.get(i)[1];
        }

        return arr;
    }
}
