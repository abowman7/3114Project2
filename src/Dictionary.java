/** The Dictionary abstract class. */
public interface Dictionary {

    /** Reinitialize dictionary */
    public void clear();


    /**
     * Insert a record
     * 
     * @param key
     *            The key for the record being inserted.
     * @param elem
     *            The record being inserted.
     */
    public void insert(Comparable key, Object elem);


    /**
     * Remove and return a record.
     * 
     * @param key
     *            The key of the record to be removed.
     * @return A maching record. If multiple records match
     *         "k", remove an arbitrary one. Return null if no record
     *         with key "k" exists.
     */
    public Object remove(Comparable key);


    /**
     * Remove and return an arbitrary record from dictionary.
     * 
     * @return the record removed, or null if none exists.
     */
    public Object removeAny();


    /**
     * @return A record matching "k" (null if none exists).
     *         If multiple records match, return all.
     * @param key
     *            The key of the record to find
     */
    public Object find(Comparable key);
    
    /**
     * @return A records between l and r (null if none exists).
     *         If multiple records match, return an arbitrary one.
     * @param l
     *            left bound
     * @param r
     *            right bound
     */
    public Object find(Comparable l, Comparable r);


    /** @return The number of records in the dictionary. */
    public int size();
}
