public class BinarySearchTree {
    Node root;
    int size;

    public Node Find(String key) {
        Node node = root;

        while (node != null) {
            int comp = key.compareTo(node.getEntry().getKey());

            if (comp < 0) {
                node = node.getLeft();
            } else if (comp > 0) {
                node = node.getRight();
            } else {
                return node;
            }
        }

        return null;
    }

    public Entry Insert(String key, Word word) {
        if (root == null) {
            root = new Node();
            root.setEntry(new Entry(key, word));
        }

        Node node = root;
        Node newNode = new Node();
        newNode.setEntry(new Entry(key, word));

        while (node != null) {
            int comp = key.compareTo(node.getEntry().getKey());

            if (comp < 0) {

            }
        }
    }
}
