package dev.vlads.tasks.Container_With_Most_Water;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        //int[] height = {1,2,1};
        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }
}

class Solution {
    // correct, but Time Limit Exceeded
    public int maxArea1(int[] height) {
        int maxCapacity = 0;
        for (int leftWallI = 0; leftWallI < height.length-1; leftWallI++) {
            int leftWallHeight = height[leftWallI];
            for (int rightWallI = leftWallI+1; rightWallI < height.length; rightWallI++) {
                int distance = rightWallI - leftWallI;
                int rightWallHeight = height[rightWallI];
                int minWallHeight = Math.min(leftWallHeight, rightWallHeight);
                int newMaxCapacity = minWallHeight * distance;
                if (newMaxCapacity > maxCapacity) maxCapacity = newMaxCapacity;
            }
        }
        return maxCapacity;
    }

    // fast
    public int maxArea(int[] height) {
        int maximumArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int shorterLine = Math.min(height[left], height[right]);
            maximumArea = Math.max(maximumArea, shorterLine * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximumArea;
    }
}