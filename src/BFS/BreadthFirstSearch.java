package BFS;

import BST.Tree;

import java.util.LinkedList;
import java.util.Queue;

import static BST.Tree.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        Tree bst = new Tree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bfs(bst.root);
    }

    // O(N) Time
    // O(N) Space
    public static void bfs(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

}
