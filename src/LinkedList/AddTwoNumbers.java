package LinkedList;

import static LinkedList.LinkedList.Node;

public class AddTwoNumbers {

    public static void main(String[] args) {

        Node root = new Node(3, null);

        Node node1 = new Node(4, root);

        Node node2 = new Node(2, node1);


        Node root2 = new Node(4, null);

        Node node3 = new Node(6, root2);

        Node node4 = new Node(5, node3);

        examine(node2);

        System.out.println();

        examine(node4);

        Node result = addTwoNumbers(node2, node4);

        System.out.println();

        examine(result);

    }

    // O(N) Time
    // O(1) Space
    public static void examine(Node root) {
        while (root.next() != null) {
            System.out.print(root.val+"->");
            root = root.next();
        }
        System.out.println(root.val);
    }

    // O(N) Time
    // O(N) Space
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node root = new Node();
        Node curr = root;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            int sumVal = sum % 10;

            curr.next = new Node(sumVal, null);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (carry > 0) {
                curr.next = new Node(carry);
            }
        }

        return root.next;
    }

}


