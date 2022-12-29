package LinkedList;
import java.util.*;

import static LinkedList.LinkedList.Node;

public class Merge {

    public static void main(String[] args) {

        Node root = new Node(4, null);

        Node node1 = new Node(3, root);

        Node node2 = new Node(2, node1);


        Node root2 = new Node(6, null);

        Node node3 = new Node(5, root2);

        Node node4 = new Node(4, node3);


        examine(node2);

        System.out.println();

        examine(node4);

        System.out.println();

        Node merged = merge(new Node[]{node2, node4});

        examine(merged);

    }

    public static void examine(Node root) {
        while (root.next() != null) {
            System.out.print(root.val+"->");
            root = root.next;
        }
        System.out.println(root.val);
    }

    // O(N) Time
    // O(N) Space
    public static Node merge(Node[] nodes) {
        Node root = new Node();
        Node curr = root;

       Queue<Node> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (Node node: nodes) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        while(!minHeap.isEmpty()) {
            Node min = minHeap.poll();
            curr.next = min;
            curr = min;

            if (min.next != null) {
                minHeap.add(min.next);
            }
        }

        return root.next;
    }

}
