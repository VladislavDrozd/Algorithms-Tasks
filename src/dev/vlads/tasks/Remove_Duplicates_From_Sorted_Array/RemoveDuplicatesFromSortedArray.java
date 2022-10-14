package dev.vlads.tasks.Remove_Duplicates_From_Sorted_Array;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int[] arr2 = new int[arr.length];

        // method 1
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        int numOfDistinct1 = solution.removeDuplicatesByGod(arr);
        System.out.println("numOfDistinct="+numOfDistinct1);
        for (int $ : arr) System.out.print($+" ");

        // method 2
        int numOfDistinct2 = solution.removeDuplicatesByMe(arr2);
        System.out.println("numOfDistinct="+numOfDistinct2);
        for (int $ : arr2) System.out.print($+" ");
    }
}

class Solution {
    public int removeDuplicatesByGod(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] != nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public int removeDuplicatesByMe(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nums[i] = iterator.next();
            i++;
        }
        return set.size();
    }
}