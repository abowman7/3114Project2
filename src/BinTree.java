
class Point {
    short x;
    short y;
    Seminar sem;

    Point(short x, short y, Seminar sem) {
        this.x = x;
        this.y = y;
        this.sem = sem;
    }
    
    Point(short x, short y) {
        this.x = x;
        this.y = y;
        this.sem = null;
    }
    
    public boolean equals(Point p) {
        return (x == p.x && y == p.y);
    }
}

class BinTreeNode {
    Point point; // Store point-value pairs only at leaf nodes
    BinTreeNode left;
    BinTreeNode right;
    BinTreeNode prev;
    int level; // Level of the node in the tree
    boolean leaf;

    BinTreeNode(Point point, int level, boolean leaf) {
        this.point = point;
        this.level = level;
        this.left = null;
        this.right = null;
        this.leaf = leaf;
    }
    
    BinTreeNode(short x, short y, Seminar sem, int level, boolean leaf) {
        this.point = new Point(x, y, sem);
        this.level = level;
        this.left = null;
        this.right = null;
        this.leaf = leaf;
    }
    
    public void setLeft(BinTreeNode left) {
        this.left = left;
    }
    
    public void setRight(BinTreeNode right) {
        this.right = right;
    }
}

public class BinTree {
    private BinTreeNode root;
    private int worldSize;

    public BinTree(int worldSize) {
        this.worldSize = worldSize;
    }
    
    public boolean inBounds(short x, short y) {
        return (x >=0 && x < worldSize) && 
            (y >=0 && y < worldSize);
    }
    
    public void insert(short x, short y, Seminar sem) {
        Point p = new Point(x, y, sem);
        if (root == null) {
            root = new BinTreeNode(p, 0, true);
            return;
        }
        inserthelp(root, p);
    }
    
    public BinTreeNode inserthelp(BinTreeNode rt, Point p) {
        if (rt == null) {
            return new BinTreeNode(p, rt.prev.level + 1, true);
        }
        //find if comparing x or y
        int dim = rt.level % 2;
        //dimension = 0 compare y, if 1 compare x
        if (dim == 0) {
            if (p.y > rt.point.y) {
                //parent.setRight(offShoot);
                if (rt.right.leaf) {
                    splitNode(rt.right, true);
                    if (rt.right.point.equals(p)) {
                        //add point to list
                        // rt.right.point.semList.add(sem);
                        return rt.right;
                    }
                    else {
                        splitNode(rt.right, true);
                    }
                }
                rt.setRight(inserthelp(rt.right, p));
                rt.right.prev = rt;
            }
            else {
                //parent.setLeft(offShoot);
                if (rt.left.leaf) {
                    if (rt.left.point.equals(p)) {
                        //add point to list
                        // rt.left.point.semList.add(sem);
                        return rt.left;
                    }
                    else {
                        splitNode(rt.left, false);
                    }
                }
                rt.setLeft(inserthelp(rt.left, p));
                rt.left.prev = rt;
            }
        }
        else {
            if (p.x > rt.point.x) {
                //parent.setRight(offShoot);
                if (rt.right.leaf) {
                    splitNode(rt.right, true);
                    if (rt.right.point.equals(p)) {
                        //add point to list
                        // rt.right.point.semList.add(sem);
                        return rt.right;
                    }
                    else {
                        splitNode(rt.right, true);
                    }
                }
                rt.setRight(inserthelp(rt.right, p));
                rt.right.prev = rt;
            }
            else {
                //parent.setLeft(offShoot);
                if (rt.left.leaf) {
                    if (rt.left.point.equals(p)) {
                        //add point to list
                        // rt.left.point.semList.add(sem);
                        return rt.left;
                    }
                    else {  //splitNode if node we want to 
                            //insert to is a leaf
                        splitNode(rt.left, false);
                    }
                }
                //recursive call
                rt.setLeft(inserthelp(rt.left, p));
                rt.left.prev = rt;
            }
        }
        
        return rt;
    }
    
    //lr - true for right, false for left
    public void splitNode(BinTreeNode parent, boolean lr) {
        if (parent == null) {
            return;
        }
        
        int newKey;
        Point np;
        //splitting by x or y?
        int dim = parent.level % 2;
        if (dim == 0) {
            if (parent.level == 0) {
                newKey = worldSize / 2;
            }
            else {
                //if true go right, if false go left
                if (lr) {
                    newKey = parent.prev.point.x + (worldSize) / (2*(parent.level + 1));
                }
                else {
                    newKey = parent.prev.point.x - (worldSize) / (2*(parent.level + 1));
                }
            }
            np = new Point(parent.prev.point.x, parent.prev.point.y);
        }
        else {
            np = new Point(parent.prev.point.y, parent.prev.point.y);
        }
        //create new internal node with new point
        BinTreeNode internal = new BinTreeNode(np, parent.level, false);
        BinTreeNode offShoot = new BinTreeNode(parent.point, parent.level+1, true);
        parent = internal;
        //parent.point = np;
        //parent.leaf = false; 
        
        if (dim == 0) {
            if (offShoot.point.y > parent.point.y) {
                parent.setRight(offShoot);
            }
            else {
                parent.setLeft(offShoot);
            }
        }
        else {
            if (offShoot.point.x > parent.point.x) {
                parent.setRight(offShoot);
            }
            else {
                parent.setLeft(offShoot);
            }
        }
    }
    
    public Seminar find(int x, int y) {
        return findhelp(root, x, y);
    }
    
    public Seminar findhelp(BinTreeNode rt, int x, int y) {
        if (rt == null) {
            return null;
        }
        //check equivalent if leaf node
        if (rt.leaf) {
            if (rt.point.x == x && rt.point.y == y) {
                //return seminar - change to List later
                return rt.point.sem;
            }
        }
        // get if checking for x/y
        int dim = rt.level % 2;
        // 0 test y, 1 test x
        if (dim == 0) {
            if (y > rt.point.y) {   //find right
                return findhelp(rt.right, x, y);
            }
            else { //find left
                return findhelp(rt.left, x, y);
            }
        }
        else {
            if (x > rt.point.x) {
                // find right
                return findhelp(rt.right, x, y);
            }
            else { //find left
                return findhelp(rt.left, x, y);
            }
        }
    }
}
