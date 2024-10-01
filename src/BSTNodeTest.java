import student.TestCase;

public class BSTNodeTest extends TestCase {
    private BSTNode node;

    
    public void setUp() {
        node = new BSTNode(5);
    }

    public void testConstruct() {
        // default constructor
        BSTNode nullNode = new BSTNode();
        assertNull(nullNode.left());
        assertNull(nullNode.right());
        
        // one input constructor
        assertEquals(5, node.value());
        assertNull(node.left());
        assertNull(node.right());
        
        // 3 input constructor
        BSTNode left = new BSTNode(3);
        BSTNode right = new BSTNode(7);
        BSTNode three = new BSTNode(5, left, right);
        assertEquals(5, three.value());
        assertEquals(left, three.left());
        assertEquals(right, three.right());
    }

    public void testValueSetter() {
        node.setValue(10);
        assertEquals(10, node.value());

        // set value when already set
        node.setValue((Comparable) 15);
        assertEquals(15, node.value());
    }

    public void testLeftRightSetter() {
        BSTNode left = new BSTNode(3);
        BSTNode right = new BSTNode(7);
        
        node.setLeft(left);
        node.setRight(right);
        
        assertEquals(left, node.left());
        assertEquals(right, node.right());
    }

    public void testLeaf() {
        assertTrue(node.isLeaf()); // is leaf
        node.setLeft(new BSTNode(3));
        assertFalse(node.isLeaf()); // left child
        node.setRight(new BSTNode(7));
        assertFalse(node.isLeaf()); // both children
        node.setLeft(null);
        assertFalse(node.isLeaf()); // no left child
        node.setRight(null);
        assertTrue(node.isLeaf()); // leaf again
    }
}
