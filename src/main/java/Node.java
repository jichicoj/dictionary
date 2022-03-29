public class Node {
    private Entry entry;
    private Node parent;
    private Node left;
    private Node right;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void inorder() {
        if (left != null) {
            left.inorder();
        }
        this.visit();
        if (right != null) {
            right.inorder();
        }
    }

    public void visit()
    {
        System.out.println(this.getEntry().getKey());
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
}
