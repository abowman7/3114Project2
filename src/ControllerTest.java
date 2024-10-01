import student.TestCase;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
    
    private Controller controller;
    
    @Before
    public void setUp() {
        controller = new Controller();
    }
    
    @Test
    public void testsearch() {
        short x = 0;
        short y = 5;
        String[] keywords = new String[1];
        keywords[0] = "Test";
        Seminar testSem = new Seminar(1, "Ok", "Fortnite", 1, x, y, 1, keywords, "Last" );
        Seminar testSem2 = new Seminar(2, "Ok", "Fortnite", 3, x, y, 3, keywords, "Last" );
        controller.insert(testSem);
        controller.insert(testSem2);
        String s = "1";
        controller.search("ID", s);
    }
}
