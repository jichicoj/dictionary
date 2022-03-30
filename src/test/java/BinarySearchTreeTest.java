import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<ComparableAssociation<Integer, String>> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void add() { }

    @Test
    void find() {
        bst.add(new ComparableAssociation<Integer, String>(1, "a"));
        bst.add(new ComparableAssociation<Integer, String>(2, "b"));

        assertEquals("a", bst.find(new ComparableAssociation<Integer, String>(1)).getValue());
    }
}