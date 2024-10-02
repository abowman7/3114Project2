import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * CommandProcessor for GraphProject.
 * Usage: CommandProcessor commandProcessor = new CommandProcessor(filename)
 * 
 * Adapted from OpenDSA
 *
 * @author {Rami Benhamida}
 * @version {1.0}
 *
 */
public class CommandProcessor {
    
    /**
     * Private filename for input file
     */
    private String filename;
    
    /**
     * @param commandFile
     *            path to input file
     */
    public CommandProcessor(String commandFile) {
        this.filename = commandFile;
    }
    
    /**
     * Parsing function that's modified from OpenDSA section 2.7
     * @param controller
     *            controller class instance
     */
    public void beginParsingByLine(Controller controller) {
        try {
            Scanner sc = new Scanner(new File(this.filename));
            Scanner scancmd;
            while (sc.hasNextLine()) { //While we have text to read
                String line = sc.nextLine(); //Get our next line
                scancmd = new Scanner(line); //Create a scanner from this line
                // Get the first word (the command) on each line
                String cmd = scancmd.next();
                String type;
                switch(cmd) {
                    case "insert":
                     // parse the ID
                        int id = scancmd.nextInt();
                        
                        // parse the title from the next line
                        String title = sc.nextLine().trim();
                        
                        // parse the date/time, length, x, y, and cost from the next line
                        line = sc.nextLine().trim();
                        scancmd = new Scanner(line); // Scanner for this line
                        String dateTime = scancmd.next().trim();
                        int length = scancmd.nextInt();
                        int x = scancmd.nextInt();
                        int y = scancmd.nextInt();
                        int cost = scancmd.nextInt();
                        
                        // Parse the keywords from the next line
                        line = sc.nextLine().trim();
                        ArrayList<String> keywords = new ArrayList<>();
                        scancmd = new Scanner(line); // Scanner for the keywords line
                        while (scancmd.hasNext()) {
                            keywords.add(scancmd.next().trim());
                        }
                        short shortx = (short ) x;
                        short shorty = (short) y;
                        
                        String[] arrayKeywords = keywords.toArray(new String[0]);
                        
                        // parse the description from the next line
                        String description = sc.nextLine().trim();
                        Seminar newSeminar = new Seminar(id, title, dateTime, length, shortx, shorty, cost, arrayKeywords, description);
                        // call a method in the controller to store or handle the parsed data
                        controller.insert(newSeminar);
                        break;
                    case "delete":
                        int idnumber = scancmd.nextInt();
                        controller.remove(idnumber);
                        break;
                    case "print":// print command
                        type = scancmd.next(); //get the type of print command
                        break;
                    case "search":// print command
                        type = scancmd.next(); //get the type of print command
                        String searchKey = scancmd.next();
                        controller.search(type, searchKey);
                        
                        break;
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
