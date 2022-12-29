package HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProductSum {

    public static void main(String[] args) {

        int[] productSum = {3, 2, 4};
        int[] productSum2 = {3, 3};

        System.out.println(Arrays.toString(productSum(productSum, 6)));
        System.out.println(Arrays.toString(productSum(productSum2, 6)));

    }

    // O(N) Time
    // O(N) Space
    public static int[] productSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                int idx = productSumHelper(nums, target - nums[i]);
                return new int[]{i, idx};
            }
            set.add(nums[i]);
        }
        return new int[2];
    }

    private static int productSumHelper(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
