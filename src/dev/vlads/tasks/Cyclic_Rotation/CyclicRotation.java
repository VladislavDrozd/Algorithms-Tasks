package dev.vlads.tasks.Cyclic_Rotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicRotation {
    public static void main(String[] args) {
        List<Input> list = new ArrayList<>();
        list.add(new Input(new int[]{},1,new int[] {}));
        list.add(new Input(new int[]{4},32,new int[] {4}));
        list.add(new Input(new int[]{4,3},1,new int[] {3,4}));
        list.add(new Input(new int[]{4,3},2,new int[] {4,3}));
        list.add(new Input(new int[]{4,3},3,new int[] {3,4}));
        list.add(new Input(new int[]{4,3},4,new int[] {4,3}));
        list.add(new Input(new int[]{1,2,3,4,5},3,new int[] {3,4,5,1,2}));
        list.add(new Input(new int[]{1,2,3,4,5},10,new int[] {1,2,3,4,5}));
        list.add(new Input(new int[]{3,8,9,7,6},3,new int[] {9,7,6,3,8}));

        Solution solution = new Solution();
        for (Input input : list) {
            int[] actual = solution.solution(input.A, input.K);
            if (!Arrays.equals(actual, input.expected)) {
                System.out.println(Arrays.toString(actual) + "!=" + input.toString());
            }
        }
    }
}

class Solution {
    public int[] solution(int[] A, int K) {
        int[] resultArray = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int circularIndex = (i+K) % A.length;
            resultArray[circularIndex] = A[i];
        }
        return resultArray;
    }
}

class Input {
    int[] A;
    int K;
    int[] expected;

    public Input(int[] a, int k, int[] expected) {
        A = a;
        K = k;
        this.expected = expected;
    }

    @Override
    public String toString() {
        return "Input{" +
                "A=" + Arrays.toString(A) +
                ", K=" + K +
                ", expected=" + Arrays.toString(expected) +
                '}';
    }
}