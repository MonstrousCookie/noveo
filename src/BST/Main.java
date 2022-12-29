package BST;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

       Tree bst = new Tree();
       Tree bst2 = new Tree();
       Tree bst3 = new Tree();

       // Test with valid BST
       bst.insert(5);
       bst.insert(3);
       bst.insert(7);
       bst.insert(2);
       bst.insert(4);
       bst.insert(6);
       bst.insert(8);

       System.out.println(bst.isValid(bst.root));

       // Test with an invalid BST
       bst = new Tree();
       bst.insert(5);
       bst.insert(3);
       bst.insert(7);
       bst.insert(2);
       bst.insert(4);
       bst.insert(6);
       bst.root.getRight().setRight(new Tree.Node(1));

       System.out.println(bst.isValid(bst.root));

       // Test with a single-node valid BST
       bst = new Tree();
       bst.insert(5);

       System.out.println(bst.isValid(bst.root));

       // Range Sum of BST
       bst2.root = new Tree.Node(10);
       bst2.root.left = new Tree.Node(5);
       bst2.root.right = new Tree.Node(15);
       bst2.root.left.left = new Tree.Node(3);
       bst2.root.left.right = new Tree.Node(7);
       bst2.root.right.right = new Tree.Node(18);

       System.out.println(bst2.rangeSumOfBST(bst2.root, 7, 15));

       // Floor and Ceil of BST
       bst3.root = new Tree.Node(8);
       bst3.root.left = new Tree.Node(4);
       bst3.root.right = new Tree.Node(12);
       bst3.root.left.left = new Tree.Node(2);
       bst3.root.left.right = new Tree.Node(6);
       bst3.root.right.left = new Tree.Node(10);
       bst3.root.right.right = new Tree.Node(14);

       for (int i = 0; i < 16; i++) {
          System.out.println(i + " " + Arrays.toString(bst3.floorAndCeil(i, bst3.root)));
       }
    }

}
