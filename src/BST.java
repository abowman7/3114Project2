import java.lang.reflect.Array;
// Binary Search Tree implementation
// mostly from OpenDSA
class BST {
    private BSTNode root; // Root of the BST
    private int nodecount; // Number of nodes in the BST
    private int nodesV;
// CHANGE IMPLEMENTATION INTO B TREE
// constructor

    BST() {
        root = null;
        nodecount = 0;
    }


    // Reinitialize tree
    public void clear() {
        root = null;
        nodecount = 0;
    }


    public BSTNode root() {
        return root;
    }


    // Insert a record into the tree.
    // Records can be anything, but they must be Comparable
    // e: The record to insert.
    public void insert(Comparable e) {
        root = inserthelp(root, e);
        nodecount++;
    }


    // Remove a record from the tree
    // key: The key value of record to remove
    // Returns the record removed, null if there is none.
    public Comparable remove(Comparable key) {
        Comparable[] temp = findhelp(root, key); // First find it
        if (temp != null) {
            root = removehelp(root, key); // Now remove it
            nodecount--;
        }
        else {
            return null;
        }
        return temp[0];
    }


    // Return the record with key value k, null if none exists
    // key: The key value to find
    public Comparable[] find(Comparable key) {
        return findhelp(root, key);
    }
    
    public Comparable[] find(Comparable l, Comparable r) {
        nodesV = 0;
        Comparable[] temp = findRange(root, l, r);
        //System.out.println(nodesV);
        return temp;
    }


    // Return the number of records in the dictionary
    public int size() {
        return nodecount;
    }


    // Get the maximum valued element in a subtree
    public BSTNode getmax(BSTNode rt) {
        if (rt.right() == null)
            return rt;
        return getmax(rt.right());
    }


    // Delete the maximum valued element in a subtree
    public BSTNode deletemax(BSTNode rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deletemax(rt.right()));
        return rt;
    }


    private Comparable[] findhelp(BSTNode rt, Comparable key) {
        Comparable[] arr = new Comparable[nodecount];
        if (rt == null) {
            return null;
        }
        if (rt.value().compareTo(key) > 0) {
            return findhelp(rt.left(), key);
        }
        else if (rt.value().compareTo(key) == 0) {
            Comparable[] keys = findhelp(rt.left(), key);
            arr[0] = rt.value();
            return append(keys, arr);
        }
        else {
            return findhelp(rt.right(), key);
        }
    }
    
    private Comparable[] findRange(BSTNode rt, Comparable left, Comparable right) {
        nodesV++;
        if (rt == null) {
            return null;
        }
        Comparable[] arr = new Comparable[nodecount];
        int lComp = rt.value().compareTo(left);
        int rComp = rt.value().compareTo(right);
        
        if (rComp > 0) {
            return findRange(rt.left(), left, right);
        }
        else if (lComp >= 0) {
            Comparable[] keys = findRange(rt.left(), left, right);
            Comparable[] keys2 = findRange(rt.right(), left, right);
            arr[0] = rt.value();
            Comparable[] leftArr = append(keys, arr);
            return append(leftArr, keys2);
        }
        else {
            return findRange(rt.right(), left, right);
        }
    }

    private BSTNode inserthelp(BSTNode rt, Comparable e) {
        if (rt == null) {
            return new BSTNode(e);
        }
        if (rt.value().compareTo(e) >= 0) {
            rt.setLeft(inserthelp(rt.left(), e));
        }
        else {
            rt.setRight(inserthelp(rt.right(), e));
        }
        return rt;
    }


    private BSTNode removehelp(BSTNode rt, Comparable key) {
        if (rt == null) {
            return null;
        }

        if (rt.value().compareTo(key) > 0) {
            rt.setLeft(removehelp(rt.left(), key));
        }
        else if (rt.value().compareTo(key) < 0) {
            rt.setRight(removehelp(rt.right(), key));
        }
        else {
            if (rt.left() == null) {
                return rt.right();
            }
            else if (rt.right() == null) {
                return rt.left();
            }
            else {
                BSTNode temp = getmax(rt.left());
                rt.setValue(temp.value());
                rt.setLeft(deletemax(rt.left()));
            }
        }
        return rt;
    }
    
    public int getNodesVisited() {
        return nodesV;
    }

    public Comparable[] append(Comparable[] arr, Comparable[] keys) {
        if (arr == null) {
            return keys.clone(); // Return a copy of array2 if array1 is null
        }
        if (keys == null) {
            return arr.clone(); // Return a copy of array1 if array2 is null
        }

        // Create a new array of the same type as array1
        Comparable[] result = (Comparable[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);

        // Copy elements from array1 to result
        System.arraycopy(arr, 0, result, 0, arr.length);

        // Index to track elements from array2
        int index2 = 0;

        // Loop through the result array to find null positions
        for (int i = 0; i < result.length; i++) {
            if (result[i] == null && index2 < keys.length) {
                result[i] = keys[index2++];
            }
        }

        return result;
    }
}
