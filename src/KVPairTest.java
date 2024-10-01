import student.TestCase;

public class KVPairTest extends TestCase {
    private KVPair kvPair;

    public void setUp() {
        kvPair = new KVPair(1, "Value1");
    }

    void testConstructor() {
        assertEquals(1, kvPair.key());
        assertEquals("Value1", kvPair.value());
    }

    public void testKey() {
        assertEquals(1, kvPair.key());
        kvPair = new KVPair("Key", "Value2");
        assertEquals("Key", kvPair.key());
    }

    public void testValue() {
        assertEquals("Value1", kvPair.value());
        kvPair = new KVPair(2, null);
        assertNull(kvPair.value());
    }

    public void testCompareToWithKVPair() {
        KVPair anotherPair = new KVPair(2, "Value2");
        assertTrue(kvPair.compareTo(anotherPair) < 0); //1 < 2

        anotherPair = new KVPair(1, "Value3");
        assertEquals(0, kvPair.compareTo(anotherPair)); //1 == 1

        anotherPair = new KVPair(0, "Value4");
        assertTrue(kvPair.compareTo(anotherPair) > 0); //1 > 0
    }

    public void testCompareToWithComparable() {
        assertTrue(kvPair.compareTo(2) < 0); //1 < 2
        assertEquals(0, kvPair.compareTo(1)); //1 == 1
        assertTrue(kvPair.compareTo(0) > 0); //1 > 0
    }

    public void testToString() {
        assertEquals("(1, Value1)", kvPair.toString());
        kvPair = new KVPair(null, null);
        assertEquals("(null, null)", kvPair.toString());
    }
}