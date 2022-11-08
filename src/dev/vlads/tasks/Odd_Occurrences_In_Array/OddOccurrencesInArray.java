package dev.vlads.tasks.Odd_Occurrences_In_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.solution(new int[] {
                        1,3,9,7,7,7,7,3,9,4,1,2,9,9,4
                })
        );
    }
}

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int elem : A) {
            if (!set.add(elem)) {
                set.remove(elem);
            }
        }
        return set.stream().findFirst().orElse(-1);
    }
}