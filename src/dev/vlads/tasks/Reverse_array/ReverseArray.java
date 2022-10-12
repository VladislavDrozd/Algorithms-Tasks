package dev.vlads.tasks.Reverse_array;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        reverse(arr);
        for (int j : arr) System.out.println(j);

    }
    static void reverse(int[] arr) {
        int leftI = 0;
        int rightI = arr.length-1;
        while (leftI < rightI) {
            int temp = arr[leftI];
            arr[leftI] = arr[rightI];
            arr[rightI] = temp;
            leftI++;
            rightI--;
        }
    }
}
