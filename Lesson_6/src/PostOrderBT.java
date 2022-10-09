public class PostOrderBT {
    static class Node {
        int item;
        Node left, right;

        public Node(int key) {
            item = key;
            left = right = null;
        }
    }

    static class Tree {
        Node root;

        Tree() {
            root = null;
        }

        void postorder(Node node) {
            if (node == null)
                return;

            postorder(node.left);
            postorder(node.right);

            System.out.print(node.item + " ");
        }

        public static void main(String[] args) {

            Tree tree = new Tree();

            tree.root = new Node(1);
            tree.root.left = new Node(3);
            tree.root.right = new Node(2);

            tree.root.left.left = new Node(31);
            tree.root.left.right = new Node(511);
            tree.root.right.left = new Node(4);
            tree.root.right.right = new Node(5);
            tree.root.left.right.left = new Node(202);

            System.out.println("Postorder traversal:");
            tree.postorder(tree.root);
        }
    }
}