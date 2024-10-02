// Dictionary implementation using BST
// This uses KVPair to manage the key/value pairs
public class BSTDict implements Dictionary {
    private BST theBST; // The BST that stores the records
    private boolean allowDupes;
    
    // constructor
    BSTDict() {
        theBST = new BST();
        allowDupes = false;
    }

    // constructor
    BSTDict(boolean dupe) {
        theBST = new BST();
        allowDupes = dupe;
    }

    // Reinitialize dictionary
    public void clear() {
        theBST = new BST();
    }


    // Insert a record
    // k: the key for the record being inserted.
    // e: the record being inserted.
    public void insert(Comparable k, Object e) {
        if (allowDupes) {
            if (theBST.find(k) != null)
                return;
        }
        theBST.insert(new KVPair(k, e));
    }


    // Remove and return a record.
    // k: the key of the record to be removed.
    // Return a maching record. If multiple records match "k", remove
    // an arbitrary one. Return null if no record with key "k" exists.
    public Object remove(Comparable k) {
        Object temp = theBST.remove(k);
        if (temp == null) {
            return temp;
        }
        else {
            return ((KVPair)temp).value();
        }
    }


    // Remove and return an arbitrary record from dictionary.
    // Return the record removed, or null if none exists.
    public Object removeAny() {
        if (theBST.size() == 0) {
            return null;
        }
        Object temp = theBST.remove(((KVPair)(theBST.root().value())).key());
        return ((KVPair)temp).value();
    }


    // Return a record matching "k" (null if none exists).
    // If multiple records match, return an arbitrary one.
    // k: the key of the record to find
    public Comparable[] find(Comparable l, Comparable r) {
        Comparable[] temp = theBST.find(l, r);

        if (temp == null) {
            return null;
        }
        else {
            return temp;
        }
    }
    
    public Comparable[] find(Comparable k) {
        Comparable[] temp = theBST.find(k);

        if (temp == null) {
            return null;
        }
        else {
            return temp;
        }
    }


    // Return the number of records in the dictionary.
    public int size() {
        return theBST.size();
    }
    
    public int getNodesV() {
        return theBST.getNodesVisited();
    }
}
