package dev.vlads.tasks.Frog_Jamp;

public class FrogJmp {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int X, int Y, int D) {
        /*
        int counter = 0;
        while (X <= Y) {
            X+=D;
            counter++;
        }
        return counter;
        */
        return (int) Math.ceil((1D*(Y-X))/D);
    }
}
