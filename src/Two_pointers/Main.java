package Two_pointers;

public class Main {

    public static void main(String[] args) {

        int[][] testCases = {{0,1,0,2,1,0,1,3,2,1,2,1}, {4,2,0,3,2,5}};

        for (int[] testCase: testCases) {
            System.out.printf("res = %d\n", trap(testCase));
        }
    }

    // O(N) Time
    // O(1) Space
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }

}
