package BST;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        Tree bst = new Tree();
        Tree.Node p = new Tree.Node(5);
        Tree.Node q = new Tree.Node(1);

       bst.root = new Tree.Node(3);
       bst.root.left = p;
       bst.root.right = q;
       bst.root.left.left = new Tree.Node(6);
       bst.root.left.right = new Tree.Node(2);
       bst.root.right.left = new Tree.Node(0);
       bst.root.right.right = new Tree.Node(8);
       bst.root.left.right.left = new Tree.Node(7);
       bst.root.left.right.right = new Tree.Node(4);

       System.out.println(findLowestCommonAncestor(bst.root, p, q).val);

    }

    // O(N) Time
    // O(N) Space
    public static Tree.Node findLowestCommonAncestor(Tree.Node root, Tree.Node q, Tree.Node p) {
        if (root == null){
            return null;
        }
        if (q == root || p == root) {
            return root;
        }
        Tree.Node left = findLowestCommonAncestor(root.left, q, p);
        Tree.Node right = findLowestCommonAncestor(root.right, q, p);
        if (left != null && right !=null) {
            return root;
        }
        return left != null ? left : right;
    }

}
