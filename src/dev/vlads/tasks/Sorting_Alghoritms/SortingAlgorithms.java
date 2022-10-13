package dev.vlads.tasks.Sorting_Alghoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SortingAlgorithms {
    public static void main(String[] args) {
        Sort insertionSortMy = new TimeProxy(new InsertionSortMYIMPLEMENTATION());
        Sort insertionSortMaster = new TimeProxy(new InsertionSortMASTERIMPLEMENTATION());
        Sort bubbleSort = new TimeProxy(new BubbleSort());
        Sort selectionSort = new TimeProxy(new SelectionSort());
        Sort mergeSort = new TimeProxy(new MergeSort());
        int[] arrBase  = {6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4,6,4,2,1,8,5,0,4,3,9,7,4};
        int[] arr  = Arrays.copyOf(arrBase, arrBase.length);
        int[] arr2 = Arrays.copyOf(arrBase, arrBase.length);;
        int[] arr3 = Arrays.copyOf(arrBase, arrBase.length);;
        int[] arr4 = Arrays.copyOf(arrBase, arrBase.length);;
        //int[] arr5 = Arrays.copyOf(arrBase, arrBase.length);;
        int[] arr5 = {6,4,2,1,8,5,0};
        insertionSortMy.sort(arr);
        insertionSortMaster.sort(arr2);
        bubbleSort.sort(arr3);
        selectionSort.sort(arr4);
        arr5 = mergeSort.sort2(arr5);
        printEquals(arr, arr2, arr3, arr4, arr5);
    }
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+"] " + arr[i]);
        }
    }

    private static void printEquals(int[]... arrays) {
        int[] baseArr = arrays[0];
        for (int i = 0; i < baseArr.length; i++) {
            int base = baseArr[i];
            for (int[] arr : arrays) {
                if (base != arr[i]) System.out.println("ARRAYS ARE NOT CONSISTENT IN INDEX " + i);
            }
        }
    }
}
interface Sort {
    void sort(int[] arr); // sort in-place
    default int[] sort2(int[] arr) { return new int[arr.length]; } // sort and return new arr
}
class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int j = arr.length; j > 0; j--) {
            for (int i = 0; i < j-1; i++) {
                // swap func
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }
}

class InsertionSortMYIMPLEMENTATION implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int I = i - 1;
            int elem = arr[i];
            int prev = arr[I];
            if (prev > elem) {
                while (prev > elem && I >= 0) {
                    prev = arr[I];
                    I--;
                }
                I = I + 2;
                if (I == 1) I = 0;
                copy(arr, I, i);
                arr[I] = elem;
            }
        }
    }

    public void copy(int[] arr, int fromI, int toI) {
        int temp = arr[fromI];
        for (int i = fromI; i < toI; i++) {
                int temp2 = arr[i+1];
                arr[i+1] = temp;
                temp = temp2;
        }
    }
}

class InsertionSortMASTERIMPLEMENTATION implements Sort {
    public void sort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int elementToSort = elements[i];
            // Move element to the left until it's at the right position
            int j = i;
            while (j > 0 && elementToSort < elements[j - 1]) {
                elements[j] = elements[j - 1];
                j--;
            }
            elements[j] = elementToSort;
        }
    }
}

class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minI = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minI] > arr[j]) {
                    minI = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minI];
            arr[minI] = temp;
        }
    }
}

class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        throw new RuntimeException("NOT IMPLEMENTED");
    }

    @Override
    public int[] sort2(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int[] arrOne = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] arrTwo = Arrays.copyOfRange(arr, arr.length/2, arr.length);

        arrOne = sort2(arrOne);
        arrTwo = sort2(arrTwo);

        return merge(arrOne, arrTwo);
    }

    private int[] merge(int[] arr1, int[] arr2) {
        List<Integer> c = new ArrayList<>(arr1.length + arr2.length);
        LinkedList<Integer> a = Arrays.stream(arr1).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> b = Arrays.stream(arr2).boxed().collect(Collectors.toCollection(LinkedList::new));

        while (!a.isEmpty() && !b.isEmpty()) {
            if (a.getFirst() > b.getFirst()) {
                c.add(b.poll());
            } else {
                c.add(a.poll());
            }
        }

        while (!a.isEmpty()) {
            c.add(a.poll());
        }

        while (!b.isEmpty()) {
            c.add(b.poll());
        }

        return c.stream().mapToInt(Integer::intValue).toArray();
    }
}

class TimeProxy implements Sort {
    private final Sort sort;
    public TimeProxy(Sort sort) {
        this.sort = sort;
    }
    @Override
    public void sort(int[] arr) {
        long begin = System.nanoTime();
        sort.sort(arr);
        long end = System.nanoTime();
        System.out.println(sort.getClass().getSimpleName() + " TIME(SECONDS)=" + ((end - begin)/1_000_000_000D) );
    }

    @Override
    public int[] sort2(int[] arr) {
        long begin = System.nanoTime();
        int[] result = sort.sort2(arr);
        long end = System.nanoTime();
        System.out.println(sort.getClass().getSimpleName() + " TIME(SECONDS)=" + ((end - begin)/1_000_000_000D) );
        return result;
    }
}