package BST;

public class Tree {

    public Node root;

    // O(log N) Time
    // O(log N) Space
    public boolean search(int val) {
        return search(root, val);
    }

    private boolean search(Node node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        if (val < node.val) {
            return search(node.left, val);
        }
        if (val > node.val) {
            return search(node.right, val);
        }
        return false;
    }

    // O(log N) Time
    // O(log N) Space
    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        }

        if (val >= node.val) {
            node.right =  insert(node.right, val);
        }

        return node;
    }

    // O(log N) Time
    // O(log N) Space
    public void invert(Node node) {
        if (node.left == null && node.right == null) {
            return;
        }

        Node tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invert(node.left);
        invert(node.right);
    }

    // O(log N) Time
    // O(log N) Space
    public boolean isValid(Node node) {
        if (node.right == null && node.left == null) {
            return true;
        }
        if (node.val < node.left.val || node.val > node.right.val) {
           return false;
        }
        return isValid(node.left) && isValid(node.right);
    }

    // O(log N) Time
    // O(log N) Space
    public int rangeSumOfBST(Node node, int low, int high) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.val <= high && node.val >= low) {
            sum += node.val;
        }
        sum += rangeSumOfBST(node.left, low, high);
        sum += rangeSumOfBST(node.right, low, high);
        return sum;
    }

    // O(log N) Time
    // O(1) Space
    public int[] floorAndCeil(int key, Node node) {
        int floor = -1, ceil = -1;
        while(node != null) {
            if (node.val == key) {
                return new int[]{node.val, node.val};
            }
            if (key > node.val) {
                floor = node.val;
                node = node.right;
            }
            else {
                ceil = node.val;
                node = node.left;
            }
        }
        return new int[]{floor, ceil};
    }

    public static class Node {
        public final int val;

        public Node left;

        public Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
