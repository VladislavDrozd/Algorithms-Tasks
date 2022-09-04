package dev.vlads.tasks.Pascal_Triangle;

/*
Pascal Triangle
https://leetcode.com/problems/pascals-triangle/
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> l = solution.generate(1);
        for (List<Integer> $ : l) {
            for (Integer _$ : $) {
                System.out.print(_$);
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<>(5);
        list.add(new ArrayList<>(Collections.singletonList(1)));
        for (int row = 1; row < numRows; row++) {
            List<Integer> listInn = new ArrayList<>();
            listInn.add(1);
            for (int i = 1; i < row; i++) {
                listInn.add(
                        list.get(row-1).get(i-1) + list.get(row-1).get(i)
                );
            }
            listInn.add(1);
            list.add(listInn);
        }
        return list;
    }
}
