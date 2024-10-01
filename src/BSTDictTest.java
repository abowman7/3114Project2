import student.TestCase;

public class BSTDictTest extends TestCase {
    private BSTDict dict;

    public void setUp() {
        dict = new BSTDict();
    }


    public void testInsertAndSize() {
        assertEquals(0, dict.size());
        dict.insert(1, "Value1");
        assertEquals(1, dict.size());
        dict.insert(2, "Value2");
        dict.insert(1, "Value3"); // repeat key
        assertEquals(3, dict.size());
    }


    public void testFind() {
        assertNull(dict.find(1)); //not found
        assertNull(dict.find(2));
        assertNull(dict.find(3));
        dict.insert(1, "Value1");
        dict.insert(2, "Value2");
        dict.insert(3, "Value3");
        assertTrue(dict.find(1) != null);
        assertEquals("(1, Value1)", dict.find(1)[0].toString());
        assertEquals("(2, Value2)", dict.find(2)[0].toString());
        assertEquals("(3, Value3)", dict.find(3)[0].toString());
        assertNull(dict.find(4)); //not found

        assertTrue(dict.find(2) != null);
        assertTrue(dict.find(3) != null);
    }


    public void testRemove() {
        dict.insert(1, "Value1");
        dict.insert(2, "Value2");
        dict.insert(3, "Value3");

        assertEquals("Value1", dict.remove(1));
        assertEquals(2, dict.size());
        assertNull(dict.find(1)); // 1 should be removed

        assertEquals("Value2", dict.remove(2));
        assertEquals(1, dict.size());
        assertNull(dict.find(2)); // 2 should be removed

        assertEquals("Value3", dict.remove(3));
        assertEquals(0, dict.size());
        assertNull(dict.find(3)); // 3 should be removed
    }


    public void testRemoveNonExistent() {
        dict.insert(1, "Value1");
        dict.insert(2, "Value2");

        assertNull(dict.remove(3)); // remove nonexistent key
        assertEquals(2, dict.size()); // size is 2
    }


    public void testRemoveAny() {
        dict.insert(1, "Value1");
        dict.insert(2, "Value2");

        assertNotNull(dict.removeAny());
        assertEquals(1, dict.size()); // remove from dict

        assertNotNull(dict.removeAny());
        assertEquals(0, dict.size()); // empty dict

        assertNull(dict.removeAny()); // no item
    }


    public void testClear() {
        dict.insert(1, "Value1");
        dict.insert(2, "Value2");
        assertEquals(2, dict.size());

        dict.clear();
        assertEquals(0, dict.size());
        assertNull(dict.find(1)); // no records
        assertNull(dict.find(2));
    }
}
