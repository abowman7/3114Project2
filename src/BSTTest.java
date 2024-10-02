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
    }
    
    public void testAppendNull1() {
        Comparable[] keys = {1, 2, 3};
        Comparable[] result = bst.append(null, keys);
        assertArrayEquals(keys, result);
    }

    public void testAppendNull2() {
        Comparable[] arr = {4, 5, 6};
        Comparable[] result = bst.append(arr, null);
        assertArrayEquals(arr, result);
    }

    public void testAppendEmpty() {
        Comparable[] arr = {4, 5, 6};
        Comparable[] result = bst.append(arr, new Comparable[0]);
        assertArrayEquals(arr, result);
    }

    public void testAppend() {
        Comparable[] arr = {4, null, null};
        Comparable[] keys = {1, 2, 3};
        Comparable[] result = bst.append(arr, keys);
        Comparable[] expected = {4, 1, 2}; // appended keys
        assertArrayEquals(expected, result);
    }

    public void testAppendFull() {
        Comparable[] arr = {1, 2, 3};
        Comparable[] keys = {4, 5, 6};
        Comparable[] result = bst.append(arr, keys);
        Comparable[] expected = {1, 2, 3}; // add no keys
        assertArrayEquals(expected, result);
    }
    
    //getting getmax and deletemax mutations

    public void testGetMax_SingleNode() {
        bst.insert(5);
        assertEquals(5, bst.getmax(bst.root()).value());
    }

    public void testGetMax_MultipleNodes() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);
        assertEquals(8, bst.getmax(bst.root()).value());
    }

    public void testDeleteMax_SingleNode() {
        bst.insert(5);
        BSTNode newRoot = bst.deletemax(bst.root());
        assertNull(newRoot);
        assertEquals(1, bst.size());
    }

    public void testDeleteMax_MultipleNodes() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);

        // Deleting the max value
        bst.deletemax(bst.root());
        //assertEquals(7, newRoot.value());

        // Checking the new max value
        assertEquals(7, bst.getmax(bst.root()).value());
    }

    public void testDeleteMax_UpdateTreeStructure() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);
        bst.insert(6);

        // Delete max and check structure
        bst.deletemax(bst.root());
        assertEquals(7, bst.getmax(bst.root()).value());
        assertEquals(5, bst.root().value());
    }
    
    public void testFindRangeWithinBounds() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(3);
        bst.insert(12);
        bst.insert(18);

        Comparable[] result = bst.find(5, 15);
        Comparable[] expected = {5, 7, 10, 12, 15, null, null}; // The order may vary depending on tree structure
        
        for (Comparable r : result ) {
            System.out.println(r);
        }
        
        assertArrayEquals(expected, result);
        assertEquals(12, bst.getNodesVisited());
    }

    public void testFindRangeExactMatch() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(3);
        bst.insert(12);
        bst.insert(18);

        Comparable[] result = bst.find(7, 12);
        Comparable[] expected = {7, 10, 12, null, null, null, null}; // The order may vary
        
        
        assertArrayEquals(expected, result);
        assertEquals(8, bst.getNodesVisited());
    }

    public void testFindRangeNoMatches() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(3);
        bst.insert(12);
        bst.insert(18);

        Comparable[] result = bst.find(20, 30);
        
        assertNull(result);
        assertEquals(3, bst.getNodesVisited());
    }

    public void testFindRangeLowerBoundOnly() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(3);
        bst.insert(12);
        bst.insert(18);

        Comparable[] result = bst.find(5, 18);
        Comparable[] expected = {5, 7, 10, 12, 15, 18, null}; // The order may vary
        assertArrayEquals(expected, result);
        assertEquals(13, bst.getNodesVisited());
    }

    public void testFindRangeUpperBoundOnly() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(3);
        bst.insert(12);
        bst.insert(18);

        Comparable[] result = bst.find(1, 10);
        Comparable[] expected = {3, 5, 7, 10, null, null, null}; // The order may vary

        
        assertArrayEquals(expected, result);
        assertEquals(10, bst.getNodesVisited());
    }
    /*
    public void testFindRangeMore() {
        bst.insert(10);
        bst.insert(9);
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);
        bst.insert(2);
        bst.insert(1);

        Comparable[] result = bst.find(1, 10);
        Comparable[] expected = {10, 9, 8, 7, 6, 2, 1}; // The order may vary

        
        assertArrayEquals(expected, result);
    }*/
}
