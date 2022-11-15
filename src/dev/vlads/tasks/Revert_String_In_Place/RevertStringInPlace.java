package dev.vlads.tasks.Revert_String_In_Place;

import java.util.Arrays;

public class RevertStringInPlace {
    public static void main(String[] args) {
        String[] str = {"c", "a", "r", " ", "b", "o", "d", "y", " ", "s", "e", "a", "t"};
        System.out.println("1) "+ Arrays.toString(str));
        revertStringInPlace(str);
        System.out.println("2) "+ Arrays.toString(str));
    }

    public static void revertStringInPlace(String[] str) {
        // reverse whole arr
        swapWord(str, 0, str.length-1);

        // reverse each word
        int rightI;
        for (int leftI = 0; leftI < str.length;) {
            for (rightI = leftI+1; rightI < str.length; rightI++) {
                if (str[rightI].equals(" ")) {
                    break;
                }
            }
            swapWord(str, leftI, rightI-1);
            leftI = rightI+1;
        }
    }

    private static void swapWord(String[] arr, int leftI, int rightI) {
        for (;leftI < rightI;leftI++,rightI--) {
            String temp = arr[leftI];
            arr[leftI] = arr[rightI];
            arr[rightI] = temp;
        }
    }

}
