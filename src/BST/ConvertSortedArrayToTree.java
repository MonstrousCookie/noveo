package BST;

public class ConvertSortedArrayToTree {

    public static void main(String[] args) {

        int[][] testCases = {{-10,-3,0,5,9},{1,3}};

        Tree.Node tree = convertArrayToBST(testCases[0]);

    }

    public static Tree.Node convertArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    // O(N) Time
    // O(N) Space
    private static Tree.Node sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Tree.Node root = new Tree.Node(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

}
