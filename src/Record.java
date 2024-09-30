/**
* Record class
* 
*   Record holds all values regarding
*   a lecture inputted from the sampleInput
*   file;
*   
*   @author Adam Bowman
*   @version 2.0
*/
public class Record 
{
    private int id;  
    private String title;
    private int length; //length of class
    private int cost;   //cost of class
    private int x;
    private int y;
    private String desc;    //description
    private String[] keywords;     //array of keywords
    private DateTime date;
    private String type;

    /**
     * Constructor
     * @param node
     *      node integer
     *  
     * @param token
     *      token to be stored
     */
    public Record(int id, String title, DateTime date, int length, 
        int x, int y, int cost, String[] keywords, String description, String type) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.length = length;
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.keywords = keywords;
        this.desc = description;
        this.type = type;
    }
    
    /**
     * getTitle string
     * 
     * @return String
     *      returns the title
     *
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * getID integer
     * 
     * @return 
     *      returns integer associated with id
     *
     */
    public int getID() {
        return id;
    }
    
    /**
     * getLength integer
     * 
     * @return 
     *      returns integer associated with 
     *      length of seminar
     *
     */
    public int getLength() {
        return length;
    }
    
    /**
     * getCost integer
     * 
     * @return 
     *      returns integer associated with cost
     *
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * getX integer
     * 
     * @return 
     *      returns integer associated with x
     *
     */
    public int getX() {
        return x;
    }
    
    /**
     * getY integer
     * 
     * @return 
     *      returns integer associated with y
     *
     */
    public int getY() {
        return y;
    }
    
    /**
     * getDesc
     * 
     * @return 
     *      returns string associated
     *      with record's description
     *
     */
    public String getDesc() {
        return desc;
    }
    
    /**
     * getKeywords
     * 
     * @return 
     *      returns string array associated
     *      with all keywords for the record
     *
     */
    public String[] getKeywords() {
        return keywords;
    }
    
    /**
     * getDate
     * 
     * @return 
     *      returns DateTime object
     *      holding the date and time
     *      of the seminar
     *
     */
    public DateTime getDate() {
        return date;
    }
    
    /**
     * getType string
     * 
     * @return String
     *      returns the type
     *
     */
    public String getType() {
        return title;
    }
    
    /**
     * setToken
     * 
     * @param t
     *      string to set new token to
     *
     */
    //public void setToken(String t)
    //{
    //    token = t;
    //}
    
    /**
     * setNode
     * 
     * @param n
     *      integer to set new node value to
     *
     */
    //public void setNode(int n)
    //{
    //    node = n;
    //}
}