package BS;

public class BinarySearch {

    public static void main(String[] args) {

        int[] bsArr1 = {1, 2, 3, 4, 5, 6, 7, 10, 34};

        int[] bsArr3 = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(binarySearch(bsArr1, 34, 0, bsArr1.length - 1));

        System.out.println(binarySearchInRotatedArray(bsArr3,  6));
    }

    // O(log N) Time
    // O(log N) Space
    public static int binarySearch(int[] arr, int target, int left, int right) {
        int middleIndex = (left + right) / 2;
        int middle = arr[middleIndex];
        if (middle < target) {
            return binarySearch(arr, target, middleIndex + 1, right);
        }
        if (middle > target) {
            return binarySearch(arr, target, left, middleIndex - 1);
        }
        return middleIndex;
    }

    // O(log N) Time
    // O(1) Space
    public static int binarySearchInRotatedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middleIndex = (left + right) / 2;
            int middle = nums[middleIndex];
            if (middle == target) {
                return middleIndex;
            }
            if (middle < nums[right]) {
                if (target > middle && target <= nums[right]) {
                    left = middleIndex + 1;
                } else {
                    right = middleIndex - 1;
                }
            } else {
                if (target >= nums[left] && target < middle) {
                    right = middleIndex - 1;
                } else {
                    left = middleIndex + 1;
                }
            }
        }
        return -1;
    }

}
