import student.TestCase;
import static org.junit.Assert.*;

public class BSTTest extends TestCase {
    private BST bst;

    public void setUp() {
        bst = new BST();
    }


    public void testInsertAndSize() {
        assertEquals(0, bst.size());
        bst.insert(5);
        assertEquals(1, bst.size());
        bst.insert(3);
        bst.insert(7);
        assertEquals(3, bst.size());
    }


    public void testFind() {
        bst.insert(5);
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals(5, bst.find(5)[0]);
        assertEquals(5, bst.find(5)[1]);
        assertEquals(3, bst.find(3)[0]);
        assertEquals(7, bst.find(7)[0]);
        assertNull(bst.find(10)); // Not found
    }


    public void testRemove() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals(3, bst.remove(3));
        assertEquals(2, bst.size());
        assertNull(bst.find(3)); // 3 should be removed

        assertEquals(5, bst.remove(5));
        assertEquals(1, bst.size());
        assertNull(bst.find(5)); // 5 should be removed

        assertEquals(7, bst.remove(7));
        assertEquals(0, bst.size());
        assertNull(bst.find(7)); // 7 should be removed
    }


    public void testRemoveNonExistentElement() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertNull(bst.remove(10)); // Trying to remove a non-existent element
        assertEquals(3, bst.size()); // Size should remain unchanged
    }


    public void testClear() {
        bst.insert(5);
        bst.insert(5);
        bst.insert(5);
        assertNull(bst.remove(7)); // Not found
        assertNull(bst.remove(3)); // Not found
        assertEquals(5, bst.remove(5));
        assertEquals(5, bst.remove(5));
        bst.insert(3);
        bst.insert(7);
        assertEquals(3, bst.size());

        bst.clear();
        assertEquals(0, bst.size());
        assertNull(bst.find(5)); // All elements should be removed
        assertNull(bst.find(3));
        assertNull(bst.find(7));

        assertNull(bst.remove(5)); // Not found
        assertNull(bst.remove(7)); // Not found
        assertNull(bst.remove(3)); // Not found
    }


    public void betterTesting() {
        bst.insert(5);
        bst.insert(5);
        bst.insert(5);
        assertNull(bst.remove(7)); // Not found
        assertNull(bst.remove(3)); // Not found
        assertEquals(5, bst.remove(5));
        assertEquals(5, bst.remove(5));
        bst.insert(7);
        bst.insert(7);
        bst.insert(7);
        bst.insert(3);
        bst.insert(7);
        assertEquals(7, bst.remove(7));
        assertEquals(7, bst.remove(7));
        assertEquals(7, bst.remove(7));
        assertEquals(3, bst.size());

        bst.clear();
        assertEquals(0, bst.size());
        assertNull(bst.find(5)); // All elements should be removed
        assertNull(bst.find(3));
        assertNull(bst.find(7));

        assertNull(bst.remove(5)); // Not found
        assertNull(bst.remove(7)); // Not found
        assertNull(bst.remove(3)); // Not found

        assertEquals(7, bst.getmax(new BSTNode(7)));
        assertEquals(7, bst.getmax(new BSTNode(3, new BSTNode(1), new BSTNode(
            7))));
        assertNull(bst.getmax(new BSTNode()));

        assertEquals(3, bst.deletemax(new BSTNode(5, new BSTNode(2),
            new BSTNode())));
        BSTNode node = new BSTNode(5, new BSTNode(2), new BSTNode(6,
            new BSTNode(), new BSTNode(10)));
        assertTrue(bst.getmax(node) != null);
        assertEquals(5, bst.deletemax(node));

        assertFalse(null == bst.getmax(node));
    }
    
    public void testAppendWithNullKeys() {
        Comparable[] arr = new Comparable[]{1, 2, null, null, null};
        Comparable[] keys = null;

        Comparable[] result = bst.append(arr, keys);

        assertArrayEquals(new Comparable[]{1, 2, null, null, null}, result);
    }

    public void testAppendFullArray() {
        Comparable[] arr = new Comparable[]{1, 2, 3, 4, 5};
        Comparable[] keys = {6, 7};

        Comparable[] result = bst.append(arr, keys);

        assertArrayEquals(new Comparable[]{1, 2, 3, 4, 5}, result); 
    }

    public void testAppendEmptyKeys() {
        Comparable[] arr = new Comparable[5];
        Comparable[] keys = {};

        Comparable[] result = bst.append(arr, keys);
        //all null
        assertArrayEquals(new Comparable[]{null, null, null, null, null}, result); 
    }

}
